package validator;

import generation.RoleStorage;

import java.util.ArrayList;

public class MainValidator {

    // Returns from the sub validators
    private String mafiaCase;
    private ArrayList<String> factions;
    private ArrayList<String> infractions;
    private ArrayList<String> uniqueDuplicates;

    private RoleStorage storage;
    private ArrayList<String> roles;

    /**
     * @param data The RoleStorage class that is being used by the program(pre Generation)
     * @param roleList The role list that is desired to be validated
     */
    public MainValidator(RoleStorage data, ArrayList<String> roleList) {
        storage = data;
        roles = roleList;
    }

    /**
     * Validates the role list that was passed in via the constructor.
     *
     * @return The list containing all the infractions(if any) found within the role list
     */
    public ArrayList<String> validate() {
        infractions = new ArrayList<>();
        mafiaCase = MafiaValidator.validate(infractions, roles, storage);
        factions = FactionValidator.validate(infractions, roles, storage);
        uniqueDuplicates = UniqueValidator.validate(infractions, roles, storage);
        VampireValidator.validate(infractions, roles);
        return infractions;
    }

    /**
     * Gets and returns what the MafiaValidator has said about the mafia in the role list
     *
     * validate() must have been run prior to this method call
     *
     * @return The note of what to do with the Mafia
     */
    public String getMafiaCase() {
        return mafiaCase;
    }

    /**
     * Gets and returns all the factions detected by FactionValidator
     *
     * validate() must have been run prior to this method call
     *
     * @return The list of all unique factions
     */
    public ArrayList<String> getFactions() {
        return factions;
    }

    /**
     * Gets and returns all the infractions as detected by all the sub validator classes
     *
     * validate() must have been run prior to this method call
     *
     * @return The list of all the infractions detected during the validation process
     */
    public ArrayList<String> getInfractions() {
        return infractions;
    }

    /**
     * Gets and returns the list of all the Unique roles that appear more than once.
     * For use in reporting specific offenders to the GUI
     *
     * validate() must have been run prior to this method call
     *
     * @return The list of all the Unique roles that appear more than once in the role list
     */
    public ArrayList<String> getUniqueDuplicates() {
        return uniqueDuplicates;
    }

}
