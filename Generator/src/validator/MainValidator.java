package validator;

import generation.RoleStorage;

import java.util.ArrayList;

public class MainValidator {

    private String mafiaCase;
    private ArrayList<String> factions;
    private ArrayList<String> infractions;
    private ArrayList<String> uniqueDuplicates;

    private RoleStorage storage;
    private ArrayList<String> roles;

    public MainValidator(RoleStorage data, ArrayList<String> roleList) {
        storage = data;
        roles = roleList;
    }

    public ArrayList<String> validate() {
        infractions = new ArrayList<>();
        mafiaCase = MafiaValidator.validate(infractions, roles, storage);
        factions = FactionValidator.validate(infractions, roles, storage);
        uniqueDuplicates = UniqueValidator.validate(infractions, roles, storage);
        VampireValidator.validate(infractions, roles);
        return infractions;
    }

    public String getMafiaCase() {
        return mafiaCase;
    }

    public ArrayList<String> getFactions() {
        return factions;
    }

    public ArrayList<String> getInfractions() {
        return infractions;
    }

    public ArrayList<String> getUniqueDuplicates() {
        return uniqueDuplicates;
    }

}
