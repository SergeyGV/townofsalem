package generation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Generator {

    private RoleStorage storage;
    private ArrayList<String> roleList;
    private Random randomizer;
    private boolean VampPresent;
    private int AnySize;
    private int TownSize;
    private int MafiaSize;
    private int NeutralSize;

    public Generator(RoleStorage info, ArrayList<String> roles) {

        storage = info;
        roleList = roles;
        Collections.sort(roleList);
        randomizer = new Random();
        VampPresent = false;

    }

    /**
     * Processes and returns the final role list
     *
     * @return The processed role list
     */
    public ArrayList<String> Generate() {

        ArrayList<String> FinalList = new ArrayList<>();
        ArrayList<String> GeneralRoles = new ArrayList<>();
        TownSize = storage.TI.size() + storage.TP.size() + storage.TK.size() + storage.TS.size();
        NeutralSize = storage.NB.size() + storage.NE.size() + storage.NK.size();
        MafiaSize = storage.MK.size() + storage.MS.size() + storage.MD.size();
        AnySize = TownSize + NeutralSize + MafiaSize;
        VampireChecker();
        for (String role: roleList) {
            if (storage.director.containsKey(role) || role.equals("Random Town")
                    || role.equals("Random Mafia") || role.equals("Random Neutral")
                    || role.equals("Any")) {
                GeneralRoles.add(role);
            } else {
                if (storage.Unique.contains(role)) {
                    storage.Unique.remove(role);
                }
                FinalList.add(role);
            }
        }
        for (String genRole: GeneralRoles) {
            switch (genRole) {
                case "Random Town":
                    //FinalList.add(getRandomTown());
                    break;
                case "Random Mafia":
                    //FinalList.add(getRandomMafia);
                    break;
                case "Random Neutral":
                    //FinalList.add(getRandomNeutral);
                    break;
                case "Any":
                    //FinalList.add(getAny());
                    break;
                default:
                    //FinalList.add(getRoleCategory());
                    break;
            }
        }
        Collections.shuffle(roleList);
        return roleList;

    }

    private void VampireChecker() {

        int i;
        if (roleList.contains("Vampire")) {
            VampPresent = true;
            storage.TK.add(storage.TK.size(), "Vampire Hunter");
            TownSize++;
            AnySize++;
            return;
        }
        if (roleList.contains("Random Neutral")) {
            i = roleList.indexOf("Random Neutral");
            while (i != roleList.size() && roleList.get(i).equals("Random Neutral") ) {
                if (randomizer.nextInt(NeutralSize + 1) == NeutralSize) {
                    AddVampire(i);
                    return;
                }
                i++;
            }
        }
        if (roleList.contains("Any")) {
            i = roleList.indexOf("Any");
            while (i != roleList.size() && roleList.get(i).equals("Any") ) {
                System.out.println("Iteration");
                if (randomizer.nextInt(AnySize + 1) == AnySize) {
                    AddVampire(i);
                    return;
                }
                i++;
            }
        }

    }

    private void AddVampire(int index) {

        roleList.remove(index);
        roleList.add(index, "Vampire");
        VampPresent = true;
        TownSize++;
        AnySize++;
        storage.TK.add(storage.TK.size(), "Vampire Hunter");

    }

}
