package actions;

import java.util.HashMap;

class RoleComparator {

    private HashMap<String, Integer> tiers;

    RoleComparator() {

        tiers = new HashMap<>();
        tiers.put("Jailor", 12);
        tiers.put("Veteran", 11);
        tiers.put("Transporter", 10);
        tiers.put("Witch", 9);
        tiers.put("Escort", 8);
        tiers.put("Consort", 8);
        tiers.put("MafTarget", 7);
        tiers.put("Framer", 6);
        tiers.put("Consigliere", 5);
        tiers.put("Blackmailer", 5);
        tiers.put("Investigator", 5);
        tiers.put("Sheriff", 5);
        tiers.put("Doctor", 5);
        tiers.put("Bodyguard", 5);
        tiers.put("Survivor", 5);
        tiers.put("Mafioso", 4);
        tiers.put("Godfather", 4);
        tiers.put("Serial Killer", 4);
        tiers.put("Vigilante", 4);
        tiers.put("Vampire Hunter", 4);
        tiers.put("Vampire", 4);
        tiers.put("Arsonist", 4);
        tiers.put("Forger", 3);
        tiers.put("Janitor", 3);
        tiers.put("Disguisor", 3);
        tiers.put("Spy", 2);
        tiers.put("Lookout", 2);
        tiers.put("Medium", 1);
        tiers.put("Mayor", 1);
        tiers.put("Retributionist", 1);
        tiers.put("Jester", 1);
        tiers.put("Executioner", 1);
        tiers.put("Werewolf", 1);
        tiers.put("Amnesiac", 1);

    }

}
