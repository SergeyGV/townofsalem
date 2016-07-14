package generation;

import java.util.ArrayList;
import java.util.HashMap;

public class RoleStorage {

    ArrayList<String> TK = new ArrayList<>();
    ArrayList<String> TS = new ArrayList<>();
    ArrayList<String> TI = new ArrayList<>();
    ArrayList<String> TP = new ArrayList<>();
    ArrayList<String> MK = new ArrayList<>();
    ArrayList<String> MD = new ArrayList<>();
    ArrayList<String> MS = new ArrayList<>();
    ArrayList<String> NK = new ArrayList<>();
    ArrayList<String> NB = new ArrayList<>();
    ArrayList<String> NE = new ArrayList<>();
    ArrayList<String> Unique = new ArrayList<>();
    HashMap<String, ArrayList> director = new HashMap<>();

    public RoleStorage() {
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

}
