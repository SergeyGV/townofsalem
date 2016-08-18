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
