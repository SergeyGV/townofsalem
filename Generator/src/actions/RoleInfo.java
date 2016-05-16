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

	static HashMap<String, String> InvestResults = new HashMap<>();
	
	static ArrayList<String> SheriffResults;

	public static ArrayList<String> NightImmune;

	public static ArrayList<String> RoleBlockImmune;

	public static ArrayList<String> ControlImmune;

	public static ArrayList<String> BiteImmune;
	
	public RoleInfo() {
		NightImmune = new ArrayList<>(Arrays.asList(
				"Godfather", "Serial Killer", "Arsonist", "Werewolf", "Executioner"));
		RoleBlockImmune = new ArrayList<>(Arrays.asList("Transporter", "Veteran", "Witch",
				"Escort", "Consort"));
		ControlImmune = new ArrayList<>(Arrays.asList("Witch", "Transporter", "Veteran"));
		BiteImmune = new ArrayList<>(Arrays.asList("Vampire Hunter", "Godfather", "Mafioso",
				"Framer", "Forger", "Janitor", "Disguisor", "Consort", "Consigliere",
				"Serial Killer", "Arsonist", "Werewolf", "Executioner", "Witch",
				"Blackmailer"));
		SheriffResults = new ArrayList<>(Arrays.asList(
				"Mafioso", "Disguisor", "Janitor", "Framer",
				"Forger", "Consigliere", "Consort", "Blackmailer"));
		InvestResults.put("Investigator", "Investigator/Consigliere");
		InvestResults.put("Consigliere", "Investigator/Consigliere");
		InvestResults.put("Spy", "Spy/Blackmailer");
		InvestResults.put("Blackmailer", "Spy/Blackmailer");
		InvestResults.put("Lookout", "Lookout/Bodyguard/Jailor");
		InvestResults.put("Bodyguard", "Lookout/Bodyguard/Jailor");
		InvestResults.put("Jailor", "Lookout/Bodyguard/Jailor");
		InvestResults.put("Sheriff", "Sheriff/Retributionist/Executioner");
		InvestResults.put("Retributionist", "Sheriff/Retributionist/Executioner");
		InvestResults.put("Executioner", "Sheriff/Retributionist/Executioner");
		InvestResults.put("Medium", "Medium/Janitor");
		InvestResults.put("Janitor", "Medium/Janitor");
		InvestResults.put("Escort", "Escort/Consort");
		InvestResults.put("Consort", "Escort/Consort");
		InvestResults.put("Transporter", "Transporter/Arsonist");
		InvestResults.put("Arsonist", "Transporter/Arsonist");
		InvestResults.put("Mayor", "Mayor/Godfather/Vampire Hunter");
		InvestResults.put("Godfather", "Mayor/Godfather/Vampire Hunter");
		InvestResults.put("Vampire Hunter", "Mayor/Godfather/Vampire Hunter");
		InvestResults.put("Vigilante", "Vigilante/Veteran/Mafioso");
		InvestResults.put("Veteran", "Vigilante/Veteran/Mafioso");
		InvestResults.put("Mafioso", "Vigilante/Veteran/Mafioso");
		InvestResults.put("Doctor", "Doctor/Serial Killer/Vampire");
		InvestResults.put("Serial Killer", "Doctor/Serial Killer/Vampire");
		InvestResults.put("Vampire", "Doctor/Serial Killer/Vampire");
		InvestResults.put("Disguisor", "Disguisor/Jester");
		InvestResults.put("Jester", "Disguisor/Jester");
		InvestResults.put("Framer", "Framer/Forger");
		InvestResults.put("Forger", "Framer/Forger");
		InvestResults.put("Survivor", "Survivor/Witch/Werewolf");
		InvestResults.put("Witch", "Survivor/Witch/Werewolf");
		InvestResults.put("Werewolf", "Survivor/Witch/Werewolf");
		InvestResults.put("Amnesiac", "Amnesiac");
	}
	
}
