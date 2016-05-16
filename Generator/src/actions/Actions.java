package actions;

import printer.ActivityPrint;
import roles.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

/**
 * Actions - The main processor of the night activity
 */

public class Actions {

    public static HashMap<Integer, Actions.Role> Players; // Reference to all the players Role classes
    public static HashMap<Integer, Data> PlayerData; // Reference to all the players Data classes

    /**
     * Role - Data class for each individual player in the game
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

        Players = new HashMap<>();
        PlayerData = new HashMap<>();
        for (int i = 1; i < 16; i++) { // Set up a role class for each player, and the visits
            Players.put(i, new Role(playerlist.get(i-1)));
            AllVisits.put(i, new ArrayList<>());
        }
        Data temp;
        for (int i = 1; i < 16; i++) {
            if (!PlayerData.containsKey(i)) {
                temp = new ShellRoles();
                temp.Process(i);
                PlayerData.put(i, temp);
            }
        }
        new TierDistributor(playerlist); // Set up the tiers and the list of mafia
        Data dataclass;
        dataclass = new roles.Jailor();
        Data.MafTarget = dataclass.validMafTarget();
        dataclass.Process(Jailor);
        PlayerData.put(Jailor, dataclass);
        if (Veteran != 0) {
            dataclass = new roles.Veteran();
            dataclass.Process(Veteran);
            PlayerData.put(Veteran, dataclass);
        }
        for (int Transporter: Transporters) {
            dataclass = new roles.Transporter();
            dataclass.Process(Transporter);
            PlayerData.put(Transporter, dataclass);
        }
        for (int Witch: Witches) {
            dataclass = new roles.Witch();
            dataclass.Process(Witch);
            PlayerData.put(Witch, dataclass);
        }
        for (int Roleblocker: RoleBlockers) {
            switch (Players.get(Roleblocker).name) {
                case "Escort":
                    dataclass = new roles.Escort();
                    break;
                case "Consort":
                    dataclass = new roles.Consort();
                    break;
            }
            dataclass.Process(Roleblocker);
            PlayerData.put(Roleblocker, dataclass);
        }
        for (int MI: MafiaInvest) {
            switch (Players.get(MI).name) {
                case "Consigliere":
                    dataclass = new roles.Consigliere();
                    break;
                case "Framer":
                    dataclass = new roles.Framer();
                    break;
                case "Blackmailer":
                    dataclass = new roles.Blackmailer();
                    break;
            }
            dataclass.Process(MI);
            PlayerData.put(MI, dataclass);
        }
        for (int TI: TownInvest) {
            switch (Players.get(TI).name) {
                case "Investigator":
                    dataclass = new roles.Investigator();
                    break;
                case "Sheriff":
                    dataclass = new roles.Sheriff();
                    break;
            }
            dataclass.Process(TI);
            PlayerData.put(TI, dataclass);
        }
        for (int Protective: Protectives) {
            switch (Players.get(Protective).name) {
                case "Doctor":
                    dataclass = new roles.Doctor();
                    break;
                case "Bodyguard":
                    dataclass = new roles.Bodyguard();
                    break;
                case "Survivor":
                    dataclass = new roles.Survivor();
                    break;
            }
            dataclass.Process(Protective);
            PlayerData.put(Protective, dataclass);
        }
        dataclass = new MafiaKillers();
        dataclass.Process(42069);
        for (int Attacker: Attackers) {
            switch (Players.get(Attacker).name) {
                case "Mafioso":
                    dataclass = new Mafioso();
                    break;
                case "Godfather":
                    dataclass = new Godfather();
                    break;
                case "Serial Killer":
                    dataclass = new SerialKiller();
                    break;
                case "Vigilante":
                    dataclass = new Vigilante();
                    break;
                case "Vampire Hunter":
                    dataclass = new VampireHunter();
                    break;
                case "Vampire":
                    dataclass = new Vampire();
                    break;
                case "Arsonist":
                    dataclass = new Arsonist();
                    break;
            }
            dataclass.Process(Attacker);
        }
        for (int DA: DeadActors) {
            switch (Players.get(DA).name) {
                case "Forger":
                    dataclass = new Forger();
                    break;
                case "Janitor":
                    dataclass = new Janitor();
                    break;
                case "Disguisor":
                    dataclass = new Disguisor();
                    break;
            }
            dataclass.Process(DA);
        }
        for (int AI: ActivityInvest) {
            switch (Players.get(AI).name) {
                case "Spy":
                    dataclass = new Spy();
                    break;
                case "Lookout":
                    dataclass = new Lookout();
                    break;
            }
            dataclass.Process(AI);
        }
        //Collections.shuffle(Attackers);

        new ActivityPrint(Players); // Report results to terminal

    }

}
