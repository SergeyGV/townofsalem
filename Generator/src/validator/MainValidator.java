package validator;

import generation.RoleStorage;

import java.util.ArrayList;

public class MainValidator {

    String mafiaCase;
    ArrayList<String> infractions;

    RoleStorage storage;
    ArrayList<String> roles;

    public MainValidator(RoleStorage data, ArrayList<String> roleList) {
        storage = data;
        roles = roleList;
    }

    public ArrayList<String> validate() {
        infractions = new ArrayList<>();
        MafiaValidator.validate(infractions, roles);
        return infractions;
    }

}
