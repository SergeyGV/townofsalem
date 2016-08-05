package validator;

import generation.RoleStorage;

import java.util.ArrayList;

public class MainValidator {

    int mafiaCase;
    boolean vampPresent;
    boolean vampHunterPresent;
    ArrayList<String> factionsPresent;
    private ArrayList<String> infractions;

    RoleStorage storage;
    ArrayList<String> roles;

    public MainValidator(RoleStorage data, ArrayList<String> roleList) {
        storage = data;
        roles = roleList;
    }

    public ArrayList<String> validate() {
        // Reset from previous runs
        mafiaCase = 0;
        vampPresent = false;
        vampHunterPresent = false;
        factionsPresent = new ArrayList<String>();
        infractions = new ArrayList<String>();
        // Step 1 - Scan
        ListScanner roleScan = new ListScanner(this);
        for (String inf: roleScan.scan()) {
            infractions.add(inf);
        }
        return infractions;
    }

}
