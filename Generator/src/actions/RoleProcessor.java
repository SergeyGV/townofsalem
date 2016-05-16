package actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * All the flags, and the methods to change them, for each role
 * @author sergey
 *
 */

public class RoleProcessor {
	
	public class RoleData {
		
		String Role;
		String InvestResult;
		String SheriffResult;
		String Special;
		String Action;
		String Result;
		boolean Jailed = false;
		int Visiting = 0;
		int Alerted = 0;
		int Transported = 0;
		int Cleaned = 0;
		int Forged = 0;
		int Doused = 0;
		int Controlled = 0;
		int Bitten = 0;
		ArrayList<Integer> Visited = new ArrayList<Integer>();
		ArrayList<Integer> Attacked = new ArrayList<Integer>();
		ArrayList<Integer> Protected = new ArrayList<Integer>();
		ArrayList<Integer> Roleblocked = new ArrayList<Integer>();
		
		public RoleData(String roleName) {
			
			Role = roleName;
			InvestResult = RoleInfo.InvestResults.get(roleName);
			if (RoleInfo.SheriffResults.contains(roleName)) {
				SheriffResult = " a member of the Mafia!";
			} else if (roleName.equals("Serial Killer")) {
				SheriffResult = " a Serial Killer!";
			} else {
				SheriffResult = " not suspicious.";
			}
			
		}
		
	}
	
	HashMap<Integer, RoleData> Players;
	HashMap<Integer, Integer> Switches;
	ArrayList<Integer> Mafia;
	ArrayList<Integer> Witches;
	ArrayList<Integer> Roleblockers;
	ArrayList<Integer> Transporters;
	Random randomizer = new Random();
	String name;
	int Mafioso;
	int Godfather;
	int Jailor;
	int MafTarget;
	int MafKiller = 0;
	int JailTarget;
	
	public RoleProcessor(ArrayList<String> RoleList) {
		
		Players = new HashMap<>();
		Switches = new HashMap<>();
		Transporters = new ArrayList<>();
		Mafia = new ArrayList<>();
		Witches = new ArrayList<>();
		Roleblockers = new ArrayList<>();
		// Initializing players and roles
		for (int i = 1; i < 16; i++) {
			name = RoleList.get(i - 1);
			if (name.equals("Witch")) {
				Witches.add(i);
			} else if (name.equals("Transporter")) {
				Transporters.add(i);
			} else if (name.equals("Escort")) {
				Roleblockers.add(i);
			} else if (name.equals("Consort")) {
				Roleblockers.add(i);
				Mafia.add(i);
			} else if (name.equals("Jailor")) {
				Jailor = i;
			} else if (name.equals("Godfather")) {
				Godfather = i;
				Mafia.add(i);
			} else if (RoleInfo.SheriffResults.contains(name)) {
				if (name.equals("Mafioso")) {
					Mafioso = i;
				}
				Mafia.add(i);
			}
			Players.put(i, new RoleData(name));
		}
		RoleData player;
		// Choose Jailor target, and jail them
		JailTarget = validSelection(Jailor);
		player = Players.get(Jailor);
		player.Action = String.valueOf(Jailor) + " has decided to jail " + String.valueOf(JailTarget);
		player.Result = String.valueOf(Jailor) + " had jailed " + String.valueOf(JailTarget);
		Players.get(JailTarget).Jailed = true;
		Players.get(JailTarget).Roleblocked.add(Jailor);
		Players.get(JailTarget).Visited.add(Jailor);
		// Processing Transports
		int target1;
		int target2;
		for (int Transporter: Transporters) {
			player = Players.get(Transporter);
			if (!player.Jailed) {
				target1 = validSelection(Transporter);
				target2 = randomizer.nextInt(15) + 1; //  Can trans himself
				player.Action = String.valueOf(Transporter) + " has decided to transport "
				+ String.valueOf(target1) + " and " + String.valueOf(target2);
				if (!(Players.get(target1).Jailed) && !(Players.get(target2).Jailed)) {
					if (!(Switches.containsKey(target1)) && !(Switches.containsKey(target2))) {
						Switches.put(target1, target2);
						Switches.put(target2, target1);
						player.Result = String.valueOf(Transporter) + " had successfully transported his " +
								"targets, " + String.valueOf(target1) + " and " + String.valueOf(target2);
					} else {
						player.Result = String.valueOf(Transporter) + " unknowingly had no effect with his " +
								"transport because another transporter had already chosen one of his targets.";
					}
					Players.get(target1).Visited.add(Transporter);
					Players.get(target2).Visited.add(Transporter);
				} else {
					player.Result = String.valueOf(Transporter) + " could not transport his targets because " +
							"one of them was in jail that night.";
				}
			}
		}
		// Choosing Mafia target
		MafTarget = validMafSelection();
		System.out.println("Initial mafia target: " + MafTarget);
		// Processing Witch controls
		for (int Witch: Witches) {
			player = Players.get(Witch);
			if (!player.Jailed) {
				target1 = validSelection(Witch);
				target2 = validSelection(Witch);
				player.Action = String.valueOf(Witch) + " has decided to control " +
						String.valueOf(target1) + " to " + String.valueOf(target2);
				if (Switches.containsKey(target1)) {
					target1 = Switches.get(target1);
				}
				if (Switches.containsKey(target2)) {
					target2 = Switches.get(target2);
				}
				player.Visiting = target1;
				Players.get(target1).Visited.add(Witch);
				Players.get(target1).Controlled = 1;
				if (!Players.get(target1).Jailed) {
					if (!(Players.get(target1).Role.equals("Witch")) &&
							!(Players.get(target1).Role.equals("Transporter"))) {
						if (Players.get(target1).Role.equals("Mafioso") ||
								Players.get(target1).Role.equals("Godfather")) {
							MafTarget = target2;
						} else {
							Players.get(target1).Visiting = target2;
						}
						player.Result = String.valueOf(Witch) + " had successfully controlled " +
								String.valueOf(target1) + " to " + String.valueOf(target2);
					} else {
						player.Result = String.valueOf(Witch) + " did not successfully control " +
								String.valueOf(target1) + " because the target was immune to control!";
					}
				} else {
					player.Result = String.valueOf(Witch) + " could not control " +
							String.valueOf(target1) + " because the target was jailed.";
				}
			}
		}
		// Process transport for mafia target
		if (Switches.containsKey(MafTarget)) {
			MafTarget = Switches.get(MafTarget);
		}
		// Processing role blockers
		for (int Roleblocker: Roleblockers) {
			player = Players.get(Roleblocker);
			if (!player.Jailed) {
				if (player.Controlled == 1) {
					target1 = player.Visiting;
					player.Action = String.valueOf(Roleblocker) + " was forced to roleblock "
							+ String.valueOf(target1);
				} else if (player.Role.equals("Escort")) {
					target1 = validSelection(Roleblocker);
					player.Action = String.valueOf(Roleblocker) + " has decided to roleblock "
							+ String.valueOf(target1);
				} else { // Consort in last else statement
					target1 = validMafSelection();
					player.Action = String.valueOf(Roleblocker) + " has decided to roleblock "
							+ String.valueOf(target1);
				}
				if (Switches.containsKey(target1)) {
					target1 = Switches.get(target1);
				}
				player.Result = String.valueOf(Roleblocker) + " had roleblocked " +
						String.valueOf(target1);
				player = Players.get(target1);
				if (player.Role.equals("Transporter") || player.Role.equals("Witch") ||
						player.Role.equals("Escort") || player.Role.equals("Consort")) {
					Players.get(Roleblocker).Result +=
							", but unknowingly, they had no effect as their target was immune!";
				} else if (player.Jailed) {
					Players.get(Roleblocker).Result +=
							", but unknowingly, they had no effect as their target was jailed!";
				}
				Players.get(target1).Roleblocked.add(Roleblocker);
				Players.get(target1).Roleblocked.add(Roleblocker);
			}
		}
		// Process chosen Mafia Killing
		if (Players.get(Mafioso).Roleblocked.size() == 0) {
			MafKiller = Mafioso;
		} else if (Players.get(Godfather).Roleblocked.size() == 0) {
			MafKiller = Godfather;
		}
		// Debug
		System.out.println("Final mafia target: " + MafTarget);
		for (int i = 1; i < 16; i++) {
			player = Players.get(i);
			System.out.println(String.valueOf(i) + ": " + player.Role);
			if (player.Visiting != 0) {
				System.out.println("Visiting: " + player.Visiting);
			}
			if (player.Controlled == 1) {
				System.out.println("This player was controlled!");
			}
			for (int visit: player.Visited) {
				System.out.println("Visited by: " + visit);
			}
		}
		generateActivity();
		/**
		 * TODO:
		 * - Begin generation of the non-special roles
		 * 		- All investigative roles visit their chosen targets
		 * 		- All protective roles visit their chosen targets
		 * 		- Process witch special cases
		 * 			- Only certain non-visiting roles can be forced to visit
		 * 			- Survivor is forced to vest if controlled
		 * 			- Vigilante is forced to shoot
		 * 		- Process Neutral Killing targets
		 * 		- Process Immunities
		 * 		- Process Veteran
		 * 			- If alerting or not(50/50)
		 * 			- Appropriate immunity assigned if so
		 * 			- Register death of all visitors
		 * 		- Process Survivor
		 * 			- If to vest or not(80/20)
		 *      - Force witch targets to show up in visited of targeted player
		 * - Process each desired visit or action
		 * 		- Print them
		 * - Process the results of each attempted visit or action
		 * 		- Print them
		 * - Process all deaths
		 * 		- Print them
		 */
		
	}

	private void generateActivity() {
		int target1;
		for (int i = 1; i < 16; i++) {
			RoleData player = Players.get(i);
			switch (player.Role) {
				case "Jailor":
					System.out.println(player.Action);
					System.out.println(player.Result);
					break;
				case "Investigator":
					if (!player.Jailed) {
						target1 = validSelection(i);
						player.Action = String.valueOf(i) + " has decided to investigate "
								+ String.valueOf(target1);
						if (player.Roleblocked.size() != 0) {
							player.Result = String.valueOf(i) + " was roleblocked and could not perform" +
									" his duty!";
						} else {
							player.Result = String.valueOf(i) + " knows that " + String.valueOf(target1) +
									" is a ";
							if (Switches.containsKey(target1)) {
								target1 = Switches.get(target1);
							}
							if (player.Controlled == 1) {
								target1 = player.Visiting;
								player.Result = String.valueOf(i) + " was controlled!";
								if (player.Roleblocked.size() == 0) {
									player.Result += " He now knows that someone in the town is a " +
											Players.get(target1).InvestResult;
								} else {
									player.Result += " He was also roleblocked, unable to perform his duty.";
								}
							} else {
								player.Result += Players.get(target1).InvestResult;
							}
							Players.get(target1).Visited.add(i);
						}
						System.out.println(player.Action);
						System.out.println(player.Result);
					}
					break;
				case "Spy":
					break; // TODO: Add mafia visits ArrayList so that the spy can see it
				case "Sheriff":
					if (!player.Jailed) {
						target1 = validSelection(i);
						player.Action = String.valueOf(i) + " has decided to interrogate "
								+ String.valueOf(target1);
						if (player.Roleblocked.size() != 0) {
							player.Result = String.valueOf(i) + " was roleblocked and could not perform" +
									" his duty!";
						} else {
							player.Result = String.valueOf(i) + " knows that " + String.valueOf(target1) +
									" is";
							if (Switches.containsKey(target1)) {
								target1 = Switches.get(target1);
							}
							if (player.Controlled == 1) {
								target1 = player.Visiting;
								player.Result = String.valueOf(i) + " was controlled!";
								if (player.Roleblocked.size() == 0) {
									player.Result += " He now knows that someone in the town is" +
											Players.get(target1).SheriffResult;
								} else {
									player.Result += " He was also roleblocked, unable to perform his duty.";
								}
							} else {
								player.Result += Players.get(target1).SheriffResult;
							}
							Players.get(target1).Visited.add(i);
						}
						System.out.println(player.Action);
						System.out.println(player.Result);
					}
					break;
				case "Lookout":
					if (!player.Jailed) {
						target1 = validSelection(i);
						player.Action = String.valueOf(i) + " has decided to watch "
								+ String.valueOf(target1);
						if (player.Roleblocked.size() != 0) {
							player.Result = String.valueOf(i) + " was roleblocked and could not perform" +
									" his duty!";
						} else {
							player.Result = String.valueOf(i) + " watched " + String.valueOf(target1) +
									"and saw ";
							if (Switches.containsKey(target1)) {
								target1 = Switches.get(target1);
							}
							if (player.Controlled == 1) {
								target1 = player.Visiting;
								player.Result = String.valueOf(i) + " was controlled!";
								if (player.Roleblocked.size() == 0) {
									player.Result += " He now knows that someone in the town was visited by ";
								} else {
									player.Result += " He was also roleblocked, unable to perform his duty.";
								}
							} else {
								player.Result += Players.get(target1).SheriffResult;
							}
							Players.get(target1).Visited.add(i);
						}
						System.out.println(player.Action);
						System.out.println(player.Result);
					}
					break;
				case "Escort":
					if (!player.Jailed) {
						System.out.println(player.Action);
						System.out.println(player.Result);
					}
					break;
				case "Medium":
					break;
				case "Transporter":
					if (!player.Jailed) {
						System.out.println(player.Action);
						System.out.println(player.Result);
					}
					break;
				case "Mayor":
					break;
				case "Retributionist":
					break;
				case "Vigilante":
					break;
				case "Veteran":
					break;
				case "Vampire Hunter":
					break;
				case "Doctor":
					break;
				case "Bodyguard":
					break;
				case "Godfather":
					break;
				case "Mafioso":
					break;
				case "Disguisor":
					break;
				case "Janitor":
					break;
				case "Framer":
					break;
				case "Forger":
					break;
				case "Consort":
					if (!player.Jailed) {
						System.out.println(player.Action);
						System.out.println(player.Result);
					}
					break;
				case "Consigliere":
					if (!player.Jailed) {
						target1 = validMafSelection();
						player.Action = String.valueOf(i) + " has decided to investigate "
								+ String.valueOf(target1);
						if (player.Roleblocked.size() != 0) {
							player.Result = String.valueOf(i) + " was roleblocked and could not perform" +
									" his duty!";
						} else {
							player.Result = String.valueOf(i) + " knows that " + String.valueOf(target1) +
									" is the ";
							if (Switches.containsKey(target1)) {
								target1 = Switches.get(target1);
							}
							if (player.Controlled == 1) {
								target1 = player.Visiting;
								player.Result = String.valueOf(i) + " was controlled!";
								if (player.Roleblocked.size() == 0) {
									player.Result += " He now knows that someone in the town is the " +
											Players.get(target1).Role;
								} else {
									player.Result += " He was also roleblocked, unable to perform his duty.";
								}
							} else {
								player.Result += Players.get(target1).Role;
							}
							Players.get(target1).Visited.add(i);
						}
						System.out.println(player.Action);
						System.out.println(player.Result);
					}
					break;
				case "Serial Killer":
					break;
				case "Arsonist":
					break;
				case "Werewolf":
					break;
				case "Jester":
					break;
				case "Executioner":
					break;
				case "Witch":
					if (!player.Jailed) {
						System.out.println(player.Action);
						System.out.println(player.Result);
					}
					break;
				case "Survivor":
					break;
				case "Amnesiac":
					break;
				case "Vampire":
					break;
				default:
					System.out.println("Error 97A1: You have seen this message");
					System.out.println("Offender: " + player.Role + " , number: " + String.valueOf(i));
					break;
			}
		}
	}
	
	/**
	 * Only for mafia use. Picks any non mafia target
	 * @return
	 */
	public int validMafSelection() {
		int result = randomizer.nextInt(15) + 1;
		while (Mafia.contains(result)) {
			result = randomizer.nextInt(15) + 1;
		}
		return result;
	}
	
	/**
	 * Only for town/neutral use. Picks any target that isn't themselves
	 * @param curRole
	 * @return
	 */
	public int validSelection(int curRole) {
		int result = randomizer.nextInt(15) + 1;
		while (curRole == result) {
			result = randomizer.nextInt(15) + 1;
		}
		return result;
	}

}
