package validator;


import generation.RoleStorage;

import java.util.ArrayList;

public class MafiaValidator {

    public static String validate(ArrayList<String> infractions, ArrayList<String> roles, RoleStorage storage) {

        int numMafia = 0;
        int mafKillCat = 0;
        int mafKillRole = 0;
        for (String role: roles) {
            if (storage.findFaction(role).equals("Mafia")) {
                numMafia++;
            }
            if (role.equals("Mafia Killing")) {
                mafKillCat++;
            } else if (storage.doesBelongGeneralCategory("Mafia Killing", role)) {
                mafKillRole++;
            }
        }
        if (numMafia > 5) {
            infractions.add("Mafia Size Limit Exceeded");
        }
        if (numMafia != 0) {
            if (mafKillCat + mafKillRole > 2) {
                infractions.add("Mafia Killing amount Exceeded");
            } else if (mafKillCat + mafKillRole == 0) {
                if (roles.contains("Random Mafia")) {
                    return "Replace RM with MK";
                } else {
                    infractions.add("No Mafia Killing but Mafia is present");
                }
            }
        }
        return "Nothing special";

    }


}
