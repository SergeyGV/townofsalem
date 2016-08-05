package validator;

import generation.RoleStorage;

import java.util.ArrayList;

public class MainValidator {

    private int mafiaCase;
    private boolean vampPresent;
    private ArrayList<String> factionsPresent;
    private ArrayList<String> infractions;

    private RoleStorage storage;

    public MainValidator(RoleStorage data) {
        storage = data;
    }

    public ArrayList<String> validate(ArrayList<String> roleList) {
        // Reset from previous runs
        mafiaCase = 0;
        vampPresent = false;
        factionsPresent = new ArrayList<String>();
        infractions = new ArrayList<String>();

        return infractions;
    }

}
