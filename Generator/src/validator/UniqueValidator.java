package validator;

import generation.RoleStorage;

import java.util.ArrayList;
import java.util.Collections;

public class UniqueValidator {

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
