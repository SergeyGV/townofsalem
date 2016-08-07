package validator;

import generation.RoleStorage;

import java.util.ArrayList;

public class FactionValidator {

    public static String validate(ArrayList<String> infractions, ArrayList<String> roles, RoleStorage storage) {

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
        return "Temp";

    }

}
