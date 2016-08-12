package validator;

import generation.RoleStorage;

import java.util.ArrayList;

public class FactionValidator {

    public static ArrayList<String> validate(ArrayList<String> infractions, ArrayList<String> roles, RoleStorage storage) {

        ArrayList<String> unqFactions = new ArrayList<>();
        int multiFactCats = 0;
        String faction;
        for (String role: roles) {
            faction = storage.findFaction(role);
            switch (faction) {
                case "Any":
                    multiFactCats++;
                    break;
                case "Random Neutral":
                    multiFactCats++;
                    break;
                default:
                    if (!faction.equals("No faction") && !unqFactions.contains(faction)) {
                        unqFactions.add(faction);
                    }
                    break;
            }
        }
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
