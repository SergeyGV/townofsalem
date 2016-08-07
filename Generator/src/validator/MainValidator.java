package validator;

import generation.RoleStorage;

import java.util.ArrayList;

public class MainValidator {

    String mafiaCase;
    ArrayList<String> factions;
    ArrayList<String> infractions;

    RoleStorage storage;
    ArrayList<String> roles;

    public MainValidator(RoleStorage data, ArrayList<String> roleList) {
        storage = data;
        roles = roleList;
    }

    public ArrayList<String> validate() {
        infractions = new ArrayList<>();
        mafiaCase = MafiaValidator.validate(infractions, roles, storage);
        factions = FactionValidator.validate(infractions, roles, storage);
        return infractions;
    }

}
