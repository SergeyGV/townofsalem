package generation;

import java.util.ArrayList;

public class Generator {

    private RoleStorage storage;
    private ArrayList<String> roleList;

    public Generator(RoleStorage info, ArrayList<String> roles) {

        storage = info;
        roleList = roles;

    }

    /**
     * Processes and returns the final role list
     *
     * @return The processed role list
     */
    public ArrayList<String> Generate() {

        ArrayList<String> RoleList = new ArrayList<>();
        VampireChecker();
        return RoleList;

    }

    private void VampireChecker() {

        if (roleList.contains("Vampire")) {
            storage.NC.add(0, "Vampire");
            storage.TK.add(storage.TK.size(), "Vampire Hunter");
        }

    }

}
