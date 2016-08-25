package actions;

import roles.RoleControl;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Objects;

class RoleComparator implements Comparator<RoleControl> {

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
        tiers.put("Godfather", 4);
        tiers.put("Mafioso", 3);
        tiers.put("Serial Killer", 3);
        tiers.put("Vigilante", 3);
        tiers.put("Vampire Hunter", 3);
        tiers.put("Vampire", 3);
        tiers.put("Arsonist", 3);
        tiers.put("ArsoIgnite", 2);
        tiers.put("Forger", 2);
        tiers.put("Janitor", 2);
        tiers.put("Disguisor", 2);
        tiers.put("Spy", 1);
        tiers.put("Lookout", 1);
        tiers.put("Medium", 0);
        tiers.put("Mayor", 0);
        tiers.put("Retributionist", 0);
        tiers.put("Jester", 0);
        tiers.put("Executioner", 0);
        tiers.put("Werewolf", 0);
        tiers.put("Amnesiac", 0);

    }

    public int compare(RoleControl roleOne, RoleControl roleTwo) {

        return tiers.get(roleTwo.roleName) - tiers.get(roleOne.roleName);

    }

}
