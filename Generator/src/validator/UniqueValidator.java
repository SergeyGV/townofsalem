package validator;

import generation.RoleStorage;

import java.util.ArrayList;
import java.util.Collections;

public class UniqueValidator {

    /**
     *
     * @param infractions The list that will contain any found errors in the role list
     * @param roles The role list that is being validated
     * @param storage The RoleStorage classed used by the program
     * @return A list that contains any found Unique roles that appear more than once in the role list
     */
    public static ArrayList<String> validate(ArrayList<String> infractions, ArrayList<String> roles, RoleStorage storage) {

        ArrayList<String> duplicates = new ArrayList<>();
        for (String role: roles) {
            if (storage.isUnique(role) && Collections.frequency(roles, role) > 1 && !duplicates.contains(role)) {
                duplicates.add(role);
            }
        }
        if (duplicates.size() != 0) {
            infractions.add("Duplicates of Unique roles found");
        }
        return duplicates;

    }

}
