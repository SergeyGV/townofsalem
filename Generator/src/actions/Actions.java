package actions;

import printer.ActivityPrint;
import roles.*;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Actions - The main processor of the night activity
 */

public class Actions {

    public static HashMap<Integer, Actions.Role> Players; // Reference to all the players Role classes
    public static HashMap<Integer, RoleControl> PlayerData; // Reference to all the players RoleControl classes

    /**
     * Role - RoleControl class for each individual player in the game
     */

    public class Role {

        public String name; // The name of their role
        public String InvResult; // Investigator results
        public String ShrResult; // Sheriff results
        public String NightAction = ""; // What the player has decided to do
        public String NightResult = ""; // What the player has obtained as their result
        public boolean jailed = false; // Indication if the player has been jailed or not
        public int witched = 0; // Indication if the player was witched or not(and on who)
        public int watching = 0; // Indication as to who the Lookout is watching
        public boolean blocked = false; // Indication if the player was roleblocked or not
        public boolean bitten = false; // Indication if the player was bitten by a vampire or not
        public boolean disguised = false; // Indication if the player was disguised or not
        public boolean forged = false; // Indication if the player was forged or not
        public boolean cleaned = false; // Indication if the player was cleaned or not
        public ArrayList<String> activity = new ArrayList<>(); // Other players influences on this player
        public ArrayList<String> attackers = new ArrayList<>(); // Which attackers are targeting the player

        public Role(String role) {

            name = role;
            InvResult = RoleInfo.InvestResults.get(role);
            if (role.equals("Serial Killer")) {
                ShrResult = " a Serial Killer!";
            } else if (RoleInfo.SheriffResults.contains(role)) {
                ShrResult = " a member of the Mafia!";
            } else {
                ShrResult = " not suspicious";
            }
        }

    }

    // Tiers are discussed in the text file Role Tiers
    public static int Jailor; // Tier 1
    public static int Veteran = 0; // Tier 2(initialized because may not exist)
    public static ArrayList<Integer> Transporters = new ArrayList<>(); // Tier 3
    public static ArrayList<Integer> Witches = new ArrayList<>(); // Tier 4
    public static ArrayList<Integer> RoleBlockers = new ArrayList<>(); // Tier 5
    public static ArrayList<Integer> MafiaInvest = new ArrayList<>(); // Tier 6
    public static ArrayList<Integer> TownInvest = new ArrayList<>(); // Tier 7
    public static ArrayList<Integer> Protectives = new ArrayList<>(); // Tier 8
    public static int Mafioso; // Tier 9a
    public static int Godfather; // Tier 9b
    public static ArrayList<Integer> Attackers = new ArrayList<>(); // Tier 9c
    public static ArrayList<Integer> DeadActors = new ArrayList<>(); // Tier 10
    public static ArrayList<Integer> ActivityInvest = new ArrayList<>(); // Tier 11
    public static ArrayList<Integer> NoImpact = new ArrayList<>(); // Tier 12
    public static ArrayList<Integer> MafiaVisits = new ArrayList<>(); // Targets of the Mafia
    public static HashMap<Integer, ArrayList<Integer>> AllVisits = new HashMap<>(); // ALL visits in the game

    /**
     * The main generation method of the night activity
     * @param playerlist The rolelist
     */
    /*
     * TODO:
     * Account for Multi arsos and possible targeting of oneself
     * Account for Multi forgers/janitors and stop them from targeting the same target
     * Stop vampires from biting targets protected
     * Begin preparations for any role list generation?
     */
    public void generate(ArrayList<String> playerlist) {

        PriorityQueue<RoleControl> allRoles = new PriorityQueue<>(new RoleComparator());
        for (int i = 0; i < 15; i++) {
            try {
                Class<?> gottenRole = Class.forName("roles." + playerlist.get(i).replaceAll(" ", ""));
                Constructor<?> cons = gottenRole.getConstructor(String.class, Integer.TYPE);
                Object ins = cons.newInstance(playerlist.get(i), i + 1);
                RoleControl theRole = (RoleControl) ins;
                allRoles.add(theRole);
            } catch (Exception e) {
                System.out.println("Something broke!");
            }
        }

        while (!allRoles.isEmpty()) {
            System.out.println(allRoles.remove().roleName);
        }

        /*
        Players = new HashMap<>();
        PlayerData = new HashMap<>();
        for (int i = 1; i < 16; i++) { // Set up a role class for each player, and the visits
            Players.put(i, new Role(playerlist.get(i-1)));
            AllVisits.put(i, new ArrayList<>());
        }
        RoleControl temp;
        for (int i = 1; i < 16; i++) {
            if (!PlayerData.containsKey(i)) {
                temp = new ShellRoles();
                temp.Process(i);
                PlayerData.put(i, temp);
            }
        }
        new TierDistributor(playerlist); // Set up the tiers and the list of mafia

        new ActivityPrint(Players); // Report results to terminal */

    }

}
