package generation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Generator {

    RoleStorage storage;
    ArrayList<String> roleList;
    boolean VampPresent;
    int AnySize;
    int TownSize;
    int MafiaSize;
    int NeutralSize;
    Random randomizer;

    public Generator(RoleStorage info, ArrayList<String> roles) {

        storage = info;
        roleList = roles;
        Collections.sort(roleList);
        randomizer = new Random();
        VampPresent = false;
        TownSize = storage.TI.size() + storage.TP.size() + storage.TK.size() + storage.TS.size();
        NeutralSize = storage.NB.size() + storage.NE.size() + storage.NK.size();
        MafiaSize = storage.MK.size() + storage.MS.size() + storage.MD.size();
        AnySize = TownSize + NeutralSize + MafiaSize;

    }

    /**
     * Processes and returns the final role list
     *
     * @return The processed role list
     */
    public ArrayList<String> Generate() {

        ArrayList<String> FinalList = new ArrayList<>();
        ArrayList<String> GeneralRoles = new ArrayList<>();
        Modifier.VampireChecker(this);
        Modifier.MafiaChecker(this);
        for (String role : roleList) {
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
        for (String genRole : GeneralRoles) {
            switch (genRole) {
                case "Random Town":
                    //FinalList.add(getRandomTown());
                    break;
                case "Random Mafia":
                    //FinalList.add(getRandomMafia());
                    break;
                case "Random Neutral":
                    //FinalList.add(getRandomNeutral());
                    break;
                case "Any":
                    //FinalList.add(getAny());
                    break;
                default:
                    FinalList.add(getRoleCategory(storage.director.get(genRole)));
                    break;
            }
        }
        Collections.shuffle(FinalList);
        return FinalList;

    }

    private String getRoleCategory(ArrayList<String> category) {
        String result = category.get(randomizer.nextInt(category.size()));
        if (storage.Unique.contains(result)) {
            storage.Unique.remove(result);
        }
        return result;
    }

}
