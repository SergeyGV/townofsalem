package generation;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class RoleStorage {

    ArrayList<String> TK = new ArrayList<>();
    ArrayList<String> TS = new ArrayList<>();
    ArrayList<String> TI = new ArrayList<>();
    ArrayList<String> TP = new ArrayList<>();
    public ArrayList<String> MK = new ArrayList<>(); // Accessed by MafiaValidator
    ArrayList<String> MD = new ArrayList<>();
    ArrayList<String> MS = new ArrayList<>();
    ArrayList<String> NK = new ArrayList<>();
    ArrayList<String> NB = new ArrayList<>();
    ArrayList<String> NE = new ArrayList<>();
    ArrayList<String> Unique = new ArrayList<>();
    ArrayList<String> TownCats = new ArrayList<>();
    ArrayList<String> MafCats = new ArrayList<>();
    ArrayList<String> NeutCats = new ArrayList<>();
    HashMap<String, ArrayList<String>> director = new HashMap<>();

    public RoleStorage() {
        TownCats = new ArrayList<>(Arrays.asList("Random Town", "Town Investigative", "Town Support",
                "Town Killing", "Town Protective"));
        MafCats = new ArrayList<>(Arrays.asList("Random Mafia", "Mafia Killing", "Mafia Deception", "Mafia Support"));
        NeutCats = new ArrayList<>(Arrays.asList("Random Neutral", "Neutral Killing", "Neutral Evil",
                "Neutral Benign"));
        /*
         * Special note: The role of Vampire Hunter and Vampire are not
         * included here by default. Rather, they will be added to the
         * appropriate locations if during generation it is deemed fit to do so
         */
        // GENERATION OF ROLES INTO CATEGORIES
        // TOWN GENERATION
        // Town Killing
        TK.add(0, "Vigilante");
        TK.add(1, "Veteran"); // Unique
        TK.add(2, "Jailor"); // Unique
        Unique.add("Veteran");
        Unique.add("Jailor");
        // Town Investigative
        TI.add(0, "Investigator");
        TI.add(1, "Lookout");
        TI.add(2, "Sheriff");
        TI.add(3, "Spy");
        // Town Support
        TS.add(0, "Transporter");
        TS.add(1, "Medium");
        TS.add(2, "Escort");
        TS.add(3, "Mayor"); // Unique
        TS.add(4, "Retributionist"); // Unique
        Unique.add("Mayor");
        Unique.add("Retributionist");
        // Town Protective
        TP.add(0, "Doctor");
        TP.add(1, "Bodyguard");
        // MAFIA GENERATION
        // Mafia Killing
        MK.add(0, "Mafioso");
        MK.add(1, "Godfather");
        Unique.add("Mafioso");
        Unique.add("Godfather");
        // Mafia Deception
        MD.add(0, "Disguisor");
        MD.add(1, "Janitor");
        MD.add(2, "Framer");
        MD.add(3, "Forger");
        // Mafia Support
        MS.add(0, "Consort");
        MS.add(1, "Consigliere");
        MS.add(2, "Blackmailer");
        // NEUTRAL GENERATION
        // Neutral Killings
        NK.add(0, "Serial Killer");
        NK.add(1, "Arsonist");
        NK.add(2, "Werewolf"); // Unique
        Unique.add("Werewolf");
        // Neutral Benign
        NB.add(0, "Survivor");
        NB.add(1, "Amnesiac");
        // Neutral Evil
        NE.add(0, "Witch");
        NE.add(1, "Jester");
        NE.add(2, "Executioner");
        // Setting up the access towards the ArrayLists
        director.put("Town Killing", TK);
        director.put("Town Support", TS);
        director.put("Town Investigative", TI);
        director.put("Town Protective", TP);
        director.put("Mafia Killing", MK);
        director.put("Mafia Deception", MD);
        director.put("Mafia Support", MS);
        director.put("Neutral Killing", NK);
        director.put("Neutral Benign", NB);
        director.put("Neutral Evil", NE);
    }

    public int getTownSize() {
        return TP.size() + TI.size() + TS.size() + TK.size();
    }

    public int getMafiaSize() {
        return MK.size() + MS.size() + MD.size();
    }

    public int getNeutralSize() {
        return NK.size() + NE.size() + NB.size();
    }

    public int getAllSize() {
        return getMafiaSize() + getNeutralSize() + getTownSize();
    }

    public ArrayList<String> findCategory(String role) {
        if (TK.contains(role)) {
            return TK;
        } else if (TS.contains(role)) {
            return TS;
        } else if (TI.contains(role)) {
            return TI;
        } else if (TP.contains(role)) {
            return TP;
        } else if (MK.contains(role)) {
            return MK;
        } else if (MS.contains(role)) {
            return MS;
        } else if (MD.contains(role)) {
            return MD;
        } else if (NK.contains(role)) {
            return NK;
        } else if (NB.contains(role)) {
            return NB;
        }
        return NE;
    }

    public String findFaction(String role) {
        if (TK.contains(role) || TS.contains(role) || TI.contains(role) || TP.contains(role)
                || TownCats.contains(role)) {
            return "Town";
        } else if (MK.contains(role) || MS.contains(role) || MD.contains(role) || MafCats.contains(role)) {
            return "Mafia";
        } else if (role.equals("Vampire") || role.equals("Any") || role.equals("Random Neutral")) {
            return role;
        } else if (NK.contains(role)) {
            return "Neutral Killing";
        }
        return "No faction";
    }

}
