package actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * All the investigative results for each role in the game
 * Also contains all the detectable mafia roles
 * @author sergey
 *
 */

public class RoleInfo {

	public static HashMap<String, String> InvestResults;
	
	public static ArrayList<String> SheriffResults;

	public static ArrayList<String> NightImmune;

	public static ArrayList<String> RoleBlockImmune;

	public static ArrayList<String> ControlImmune;

	public static ArrayList<String> BiteImmune;

	public static ArrayList<String> allMafia;
	
	public static void populate() {
		NightImmune = new ArrayList<>(Arrays.asList(
				"Godfather", "Serial Killer", "Arsonist", "Werewolf", "Executioner"));
		RoleBlockImmune = new ArrayList<>(Arrays.asList("Transporter", "Veteran", "Witch",
				"Escort", "Consort"));
		ControlImmune = new ArrayList<>(Arrays.asList("Witch", "Transporter", "Veteran"));
		BiteImmune = new ArrayList<>(Arrays.asList("Vampire Hunter", "Godfather", "Mafioso",
				"Framer", "Forger", "Janitor", "Disguisor", "Consort", "Consigliere",
				"Serial Killer", "Arsonist", "Werewolf", "Executioner", "Witch",
				"Blackmailer", "Vampire"));
		SheriffResults = new ArrayList<>(Arrays.asList(
				"Mafioso", "Disguisor", "Janitor", "Framer",
				"Forger", "Consigliere", "Consort", "Blackmailer"));
		allMafia = new ArrayList<>(Arrays.asList("Mafioso", "Godfather", "Disguisor", "Janitor",
				"Framer", "Forger", "Consigliere", "Consort", "Blackmailer"));
		InvestResults = new HashMap<>();
		InvestResults.put("Investigator", "an Investigator/Consigliere/Mayor!");
		InvestResults.put("Consigliere", "an Investigator/Consigliere/Mayor!");
		InvestResults.put("Mayor", "an Investigator/Consigliere/Mayor!");
		InvestResults.put("Spy", "a Spy/Blackmailer/Jailor!");
		InvestResults.put("Blackmailer", "a Spy/Blackmailer/Jailor!");
		InvestResults.put("Jailor", "a Spy/Blackmailer/Jailor!");
		InvestResults.put("Lookout", "a Lookout/Forger/Amnesiac!");
		InvestResults.put("Forger", "a Lookout/Forger/Amnesiac!");
		InvestResults.put("Amnesiac", "a Lookout/Forger/Amnesiac!");
		InvestResults.put("Sheriff", "a Sheriff/Executioner/Werewolf!");
		InvestResults.put("Executioner", "a Sheriff/Executioner/Werewolf!");
		InvestResults.put("Werewolf", "a Sheriff/Executioner/Werewolf!");
		InvestResults.put("Medium", "a Medium/Janitor/Retributionist!");
		InvestResults.put("Janitor", "a Medium/Janitor/Retributionist!");
		InvestResults.put("Retributionist", "a Medium/Janitor/Retributionist!");
		InvestResults.put("Escort", "an Escort/Consort/Transporter!");
		InvestResults.put("Consort", "an Escort/Consort/Transporter!");
		InvestResults.put("Transporter", "an Escort/Consort/Transporter!");
		InvestResults.put("Bodyguard", "a Bodyguard/Godfather/Arsonist!");
		InvestResults.put("Godfather", "a Bodyguard/Godfather/Arsonist!");
		InvestResults.put("Arsonist", "a Bodyguard/Godfather/Arsonist!");
		InvestResults.put("Vigilante", "a Vigilante/Veteran/Mafioso!");
		InvestResults.put("Veteran", "a Vigilante/Veteran/Mafioso!");
		InvestResults.put("Mafioso", "a Vigilante/Veteran/Mafioso!");
		InvestResults.put("Doctor", "a Doctor/Disguisor/Serial Killer!");
		InvestResults.put("Disguisor", "a Doctor/Disguisor/Serial Killer!");
		InvestResults.put("Serial Killer", "a Doctor/Disguisor/Serial Killer!");
		InvestResults.put("Framer", "a Framer/Vampire/Jester!");
		InvestResults.put("Vampire", "a Framer/Vampire/Jester!");
		InvestResults.put("Jester", "a Framer/Vampire/Jester!");
		InvestResults.put("Survivor", "a Survivor/Vampire Hunter/Witch!");
		InvestResults.put("Vampire Hunter", "a Survivor/Vampire Hunter/Witch!");
		InvestResults.put("Witch", "a Survivor/Vampire Hunter/Witch!");
	}
	
}
