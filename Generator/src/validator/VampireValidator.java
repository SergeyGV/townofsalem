package validator;

import java.util.ArrayList;
import java.util.Collections;

public class VampireValidator {

    /**
     * Validates the Vampire side of the role list
     *
     * @param infractions The list that will contain any found errors in the role list
     * @param roles The role list that is being validated
     */
    public static void validate(ArrayList<String> infractions, ArrayList<String> roles) {

        int vampCount = Collections.frequency(roles, "Vampire");
        if (vampCount > 5) {
            infractions.add("Vampire Size Limit exceeded");
        } // Impossible to have a Vampire Hunter present without Vampires
        if (vampCount == 0 && roles.contains("Vampire Hunter")) {
            infractions.add("Vampire Hunter present without Vampire");
        }
    }

}
