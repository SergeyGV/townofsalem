package generation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Generator {

    RoleStorage storage;
    ArrayList<String> roleList;
    ArrayList<String> FinalList;
    boolean VampPresent;
    int AnySize;
    int TownSize;
    int MafiaSize;
    int NeutralSize;
    Random randomizer;

    public Generator(RoleStorage info, ArrayList<String> roles) {

        storage = info;
        roleList = roles;
        FinalList = new ArrayList<>();
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

        ArrayList<String> GeneralRoles = new ArrayList<>();
        Modifier.VampireChecker(this);
        Modifier.MafiaChecker(this);
        for (String role : roleList) {
            if (storage.director.containsKey(role) || role.equals("Random Town")
                    || role.equals("Random Mafia") || role.equals("Random Neutral")
                    || role.equals("Any")) {
                GeneralRoles.add(role);
            } else {
                getRole(role);
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
                    getRoleCategory(genRole);
                    break;
            }
        }
        Collections.shuffle(FinalList);
        return FinalList;

    }

    private String getTownRole() {
        int totalSize = TownSize;
        int chosen = randomizer.nextInt(totalSize);
        System.out.println(chosen);
        /*
        if (totalSize < chosen) {
            return(getRole(TP));
        }
        totalSize -= TS.size();
        if (totalSize < chosen) {
            return(getRole(TS));
        }
        totalSize -= TI.size();
        if (totalSize < chosen) {
            return(getRole(TI));
        }
        return(getRole(TK));*/
        return "ayy";
    }

    private void getRole(String role) {
        if (!role.equals("Vampire") && storage.Unique.contains(role)) {
            ArrayList<String> category = storage.findCategory(role);
            category.remove(role);
        }
        FinalList.add(role);
    }

    private void getRoleCategory(String category) {
        ArrayList<String> catRoles = storage.director.get(category);
        String result = catRoles.get(randomizer.nextInt(catRoles.size()));
        if (storage.Unique.contains(result)) {
            catRoles.remove(result);
        }
        FinalList.add(result);
    }

}
