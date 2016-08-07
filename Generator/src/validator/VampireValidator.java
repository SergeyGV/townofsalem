package validator;

import java.util.ArrayList;
import java.util.Collections;

public class VampireValidator {

    public static void validate(ArrayList<String> infractions, ArrayList<String> roles) {

        int vampCount = Collections.frequency(roles, "Vampire");
        if (vampCount > 5) {
            infractions.add("Vampire Size Limit exceeded");
        }
        if (vampCount == 0 && roles.contains("Vampire Hunter")) {
            infractions.add("Vampire Hunter present without Vampire");
        }
    }

}
