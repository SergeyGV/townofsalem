package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import actions.Actions;
import actions.RoleInfo;
import actions.RoleProcessor;
import gui.Display;

public class Generator {
	
	private ArrayList<String> TK = new ArrayList<>();
	private ArrayList<String> TS = new ArrayList<>();
	private ArrayList<String> TI = new ArrayList<>();
	private ArrayList<String> TP = new ArrayList<>();
	private ArrayList<String> Mafia = new ArrayList<>();
	private ArrayList<String> NK = new ArrayList<>();
	private ArrayList<String> NB = new ArrayList<>();
	private ArrayList<String> NE = new ArrayList<>();
	private ArrayList<String> Unique = new ArrayList<>();
	private ArrayList<String> FinalList = new ArrayList<>();
	private Random randomizer = new Random();
	
	private void Create() {
		/*
		 * Generation notes:
		 * Jailor added manually as he is always in the role list
		 * Mafia list only covers Random Mafia, as Mafioso and Godfather
		 * are always present in the role list
		 * Any generated first, with the special case of the Vampire
		 * If Vampire is present, add Vampire Hunter to TK(iff relationship)
		 */
		// GENERATION OF ROLES INTO CATEGORIES
		// TOWN GENERATION
		// Town Killing
		TK.add(0, "Vigilante");
		TK.add(1, "Veteran"); // Unique
		Unique.add("Veteran");
		// Town Investigative
		TI.add(0, "Investigator");
		TI.add(1, "Lookout");
		TI.add(2, "Sheriff");
		TI.add(3, "Spy");
		// Town Support
		TS.add(0, "Transporter");
		TS.add(1, "Medium");
		TS.add(2, "Escort");
		TS.add(3, "Mayor"); // Unique
		TS.add(4, "Retributionist"); // Unique
		Unique.add("Mayor");
		Unique.add("Retributionist");
		// Town Protective
		TP.add(0, "Doctor");
		TP.add(1, "Bodyguard");
		// MAFIA GENERATION
		Mafia.add(0, "Disguisor");
		Mafia.add(1, "Janitor");
		Mafia.add(2, "Framer");
		Mafia.add(3, "Forger");
		Mafia.add(4, "Consort");
		Mafia.add(5, "Consigliere");
		Mafia.add(6, "Blackmailer");
		// NEUTRAL GENERATION
		// Neutral Killings
		NK.add(0, "Serial Killer");
		NK.add(1, "Arsonist");
		NK.add(2, "Werewolf"); // Unique
		Unique.add("Werewolf");
		// Neutral Benign
		NB.add(0, "Survivor");
		NB.add(1, "Amnesiac");
		// Neutral Evil
		NE.add(0, "Witch");
		NE.add(1, "Jester");
		NE.add(2, "Executioner");
		roleGen();
	}
	
	private void roleGen() {
		/* 
		 * ROLE LIST
		 * 1: Jailor
		 * 2-3: Town Investigative
		 * 4-5: Town Support
		 * 6: Town Protective
		 * 7: Town Killing
		 * 8: Random Town
		 * 9: Godfather
		 * 10: Mafioso
		 * 11: Random Mafia
		 * 12: Neutral Killing
		 * 13: Neutral Evil
		 * 14: Neutral Benign
		 * 15: Any
		 */
		String Any = getAnyRole(); // Any done first but added last
		FinalList.add("Jailor");
		FinalList.add(getRole(TI));
		FinalList.add(getRole(TI));
		FinalList.add(getRole(TS));
		FinalList.add(getRole(TS));
		FinalList.add(getRole(TP));
		FinalList.add(getRole(TK));
		FinalList.add(getTownRole());
		FinalList.add("Godfather");
		FinalList.add("Mafioso");
		FinalList.add(getRole(Mafia));
		FinalList.add(getRole(NK));
		FinalList.add(getRole(NE));
		FinalList.add(getRole(NB));
		FinalList.add(Any);
		Collections.shuffle(FinalList);
	}
	
	/**
	 * Get and return any random town role in the game
	 * @return The town role
	 */
	private String getTownRole() {
		int totalSize = TK.size() + TI.size() + TS.size();
		int chosen = randomizer.nextInt(totalSize + TP.size());
		if (totalSize < chosen) {
			return(getRole(TP));
		}
		totalSize -= TS.size();
		if (totalSize < chosen) {
			return(getRole(TS));
		}
		totalSize -= TI.size();
		if (totalSize < chosen) {
			return(getRole(TI));
		}
		return(getRole(TK));
	}
	
	/**
	 * Get and return any role in the game
	 * @return Any role in the game
	 */
	private String getAnyRole() {
		int totalSize = TK.size() + TI.size() + TS.size() + TP.size()
		+ Mafia.size() + NK.size() + NE.size() + NB.size();
		int chosen = randomizer.nextInt(totalSize + 1);
		if (chosen == totalSize) { // Vampire special case
			TK.add(TK.size(), "Vampire Hunter");
			return("Vampire");
		}
		totalSize -= NB.size();
		if (totalSize < chosen) {
			return(getRole(NB));
		}
		totalSize -= NE.size();
		if (totalSize < chosen) {
			return(getRole(NE));
		}
		totalSize -= NK.size();
		if (totalSize < chosen) {
			return(getRole(NK));
		}
		totalSize -= Mafia.size();
		if (totalSize < chosen) {
			return(getRole(Mafia));
		}
		totalSize -= TP.size();
		if (totalSize < chosen) {
			return(getRole(TP));
		}		
		totalSize -= TS.size();
		if (totalSize < chosen) {
			return(getRole(TS));
		}		
		totalSize -= TK.size();
		if (totalSize < chosen) {
			return(getRole(TK));
		}		
		return(getRole(TI));
	}

	/**
	 * Generate a role from the given category
	 * @param RoleList The given category from which we get the role from
	 * @return A role from the RoleList list
	 */
	private String getRole(ArrayList<String> RoleList) {
		int chosenRole = randomizer.nextInt(RoleList.size());
		String roleName = RoleList.get(chosenRole);
		if (Unique.contains(roleName)) {
			Unique.remove(roleName);
			RoleList.remove(roleName);
		}
		return (roleName);
	}

	public static void main(String[] args) {
		
		new RoleInfo(); // Generate investigative results
		//new Display(); // Display the screen
		// WHILE GUI IS WORKED ON
		Generator gen = new Generator();
		gen.Create();
		Actions test = new Actions();
		test.generate(gen.FinalList);

	}

}
