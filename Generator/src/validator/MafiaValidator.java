package validator;


import generation.RoleStorage;

import java.util.ArrayList;

public class MafiaValidator {

    /**
     * Validates the mafia side of the role list
     *
     * @param infractions The list that will contain any found errors in the role list
     * @param roles The role list that is being validated
     * @param storage The RoleStorage classed used by the program
     * @return Indicator for, if the validate passses, what needs to be done with the Mafia
     */
    public static String validate(ArrayList<String> infractions, ArrayList<String> roles, RoleStorage storage) {

        int numMafia = 0; // Total number of mafia present
        int mafKillCat = 0; // Total number of Mafia Killing category slots present
        int mafKillRole = 0; // Total number of roles from Mafia Killing present
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
        if (numMafia != 0) { // No mafia means no killers, no checks needed
            if (mafKillCat + mafKillRole > 2) { // Impossible to have more than two killers
                infractions.add("Mafia Killing amount Exceeded");
            } else if (mafKillCat + mafKillRole == 0) { // Need at least one killer at this stage
                if (roles.contains("Random Mafia")) {
                    return "Replace RM with MK"; // Indicator for MafiaModifier for what to do
                } else {
                    infractions.add("No Mafia Killing but Mafia is present");
                }
            }
        }
        return "Nothing special";

    }


}
