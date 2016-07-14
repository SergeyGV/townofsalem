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

        ArrayList<String> RoleList = new ArrayList<>();
        VampireChecker();
        TownSize = storage.TI.size() + storage.TP.size() + storage.TK.size() + storage.TS.size();
        NeutralSize = storage.NB.size() + storage.NE.size() + storage.NK.size();
        MafiaSize = storage.MK.size() + storage.MS.size() + storage.MD.size();
        AnySize = TownSize + NeutralSize + MafiaSize;
        return RoleList;

    }

    private void VampireChecker() {

        int i;
        if (roleList.contains("Vampire")) {
            VampPresent = true;
            storage.TK.add(storage.TK.size(), "Vampire Hunter");
            return;
        }
        if (roleList.contains("Random Neutral")) {
            i = roleList.indexOf("Random Neutral");
            while (i != roleList.size() && roleList.get(i).equals("Random Neutral") ) {
                if (randomizer.nextInt(NeutralSize + 1) == NeutralSize) {
                    roleList.remove(i);
                    roleList.add(i, "Vampire");
                    VampPresent = true;
                    storage.TK.add(storage.TK.size(), "Vampire Hunter");
                    return;
                }
            }
        }
        if (roleList.contains("Any")) {
            i = roleList.indexOf("Any");
            while (i != roleList.size() && roleList.get(i).equals("Any") ) {
                if (randomizer.nextInt(AnySize + 1) == AnySize) {
                    roleList.remove(i);
                    roleList.add(i, "Vampire");
                    VampPresent = true;
                    storage.TK.add(storage.TK.size(), "Vampire Hunter");
                    return;
                }
            }
        }

    }

}
