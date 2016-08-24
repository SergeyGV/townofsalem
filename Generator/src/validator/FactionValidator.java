package validator;

import generation.RoleStorage;

import java.util.ArrayList;

public class FactionValidator {

    /**
     * Validates the faction side of the role list
     *
     * @param infractions The list that will contain any found errors in the role list
     * @param roles The role list that is being validated
     * @param storage The RoleStorage classed used by the program
     * @return The list of all the unique factions in the role list
     */
    public static ArrayList<String> validate(ArrayList<String> infractions, ArrayList<String> roles, RoleStorage storage) {

        ArrayList<String> unqFactions = new ArrayList<>();
        int multiFactCats = 0;
        String faction;
        for (String role: roles) {
            faction = storage.findFaction(role);
            switch (faction) {
                case "Any":
                case "Random Neutral":
                case "Neutral Killing":
                    multiFactCats++;
                    break;
                default:
                    if (!faction.equals("No faction") && !unqFactions.contains(faction)) {
                        unqFactions.add(faction);
                    }
                    break;
            }
        }
        /* Case 1: More than two unique factions: don't even run this if else block
         * Case 2: One unique faction: Have witch&vig case or at least one Any/Random Neutral
         * Case 3: No unique faction: Have at least two Any's/Random Neutrals */
        if (unqFactions.size() == 1) {
            if (multiFactCats == 0 && !(roles.contains("Vigilante")) && roles.contains("Witch")) {
                infractions.add("Only 1 competing faction possible; Need at least 2");
            }
        } else if (unqFactions.size() == 0){
            if (multiFactCats < 2) {
                infractions.add("No competing factions possible; Need at least 2");
            }
        }
        return unqFactions;

    }

}
