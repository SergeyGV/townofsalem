package roles;

import actions.Actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public abstract class RoleControl {

    public String roleName;
    public String nightAction;
    public String nightResult;
    int playerNum;
    int target; // Used to keep track of player targets
    int target2; // Used for the transporters second target
    boolean jailed = false;
    public ArrayList<String> activity;
    private Random randomizer = new Random(); // Used for random generation of numbers
    static HashMap<Integer, Integer> switches; // Tracks which targets were transported
    HashMap<Integer, RoleControl> players;
    //boolean immune; // Used to keep track of if people vested/self-healed
    //boolean blocked = false;
    //static public int MafTarget; // Mafia initial killing target
    //static int FinMafTarget; // Mafia final killing target
    //static public ArrayList<Integer> Mafia = new ArrayList<>(); // Used to keep track of mafia members
    //static boolean alert = false; // Indication if the Veteran has gone on alert
    //ArrayList<Integer> DocSubs = new ArrayList<>(); // Tracks Doctor subscribers
    //ArrayList<Integer> BGSubs = new ArrayList<>(); // Tracks Bodyguard subscribers

    public RoleControl(String name, int num) {
        roleName = name;
        playerNum = num;
        nightAction = "";
        nightResult = "";
        activity = new ArrayList<>();
        players = Actions.PlayerData;
        switches = new HashMap<>();
    }

    /**
     * Returns a valid target for a town member. A valid target is everyone in the town
     * excluding the number of the player, as they cannot target themselves unless the
     * role allows it. In those cases, the number -1 is passed in.
     *
     * @param player The player number
     * @return The target number
     */
    public int validTownTarget(int player) {

        int target = randomizer.nextInt(15) + 1;
        while (player == target) {
            target = randomizer.nextInt(15) + 1;
        }
        return(target);

    }

    /**
     * Returns a valid target for the mafia. A valid mafia target is everyone
     * in the town that does not happen to be a member of the mafia.
     *
     * @return The target number
     */
    public int validMafTarget() { /*

        int target = randomizer.nextInt(15) + 1;
        while (Mafia.contains(target)) {
            target = randomizer.nextInt(15) + 1;
        }
        return(target); */
        return 1337;

    }

    /**
     * Process if the player being visited is a Veteran on alert.
     * If it is, send the appropriate data to the visitor and the Veteran.
     * The function assumes that the role class currently in the player variable
     * is the visiting player
     *
     * @param num The number of the person being visited
     */
    public boolean checkVetVisit(int num) {

        /*
        if (num == Actions.Veteran && alert) {
            player.attackers.add("Veteran");
            Actions.Players.get(Actions.Veteran).activity.add("VetShot");
            return true;
        }
        return false; */
        return true;
    }

    /**
     * Same as checkVetVisit, but is only used AFTER attackers have done their moves
     * @param num The visited player's number
     */
    public void checkLateVetVisit(int num) { /*

        if (checkVetVisit(num)) {
            if (DocSubs.size() != 0) {
                notifyDoctors();
                player.activity.add("DocSave");
                player.attackers.remove("Veteran");
            }
        } */

    }

    /**
     * Given a number representing the player number that the current player wishes
     * to visit, this function will return back the number of the player that will
     * actually be visited.
     *
     * It is assumed that the player variable stores the visitor's player profile.
     *
     * @param num The target that the visitor wants to visit
     * @return The actual target that will be visited
     */
    public int checkTargetSwitch(int num) { /*

        int target = num;
        if (player.witched != 0) {
            target = player.witched;
        }
        if (switches.containsKey(target)) {
            return (switches.get(target));
        }
        return(target); */
        return 1337;

    }

    /**
     * Given a number, it will check if that target was transported or not.
     * If it was, we will return the number that it was transported with,
     * otherwise, we'll return the same number that was passed in.
     *
     * Used by the Witch.
     *
     * @param num The player number
     * @return Either the player that num was transported with, or num
     */
    public int checkTransporter(int num) { /*

        if (switches.containsKey(num)) {
            return(switches.get(num));
        }
        return(num); */
        return 1337;

    }

    /**
     * Subscribe a player(who is a Doctor) to the player of this class
     *
     * @param Doctor The Doctor's player number
     */
    public void subscribeDoctor(int Doctor) {
        //DocSubs.add(Doctor);
    }

    /**
     * Subscribe a player(who is a Bodyguard) to the player of this class
     *
     * @param Bodyguard The Bodyguard's player number
     */
    public void subscribeBG(int Bodyguard) {
        //BGSubs.add(Bodyguard);
    }

    /**
     * Notify all Doctors subscribed to this player that he was attacked
     */
    public void notifyDoctors() { /*
        for (int Doctor: DocSubs) {
            Players.get(Doctor).activity.add("DocAtt");
            //PlayerData.get(Doctor).updateDoctor();
        } */
    }

    /**
     * Notify one of the Bodyguards subscribed to this player that he is being attacked,
     * and then remove that Bodyguard from the subscribers list as he had fulfilled his duty
     */
    public void notifyBG() { /*
        if (BGSubs.size() != 0) {
            PlayerData.get(BGSubs.get(0)).updateBG();
            BGSubs.remove(0);
        } */
    }

    /**
     * Update the Doctor that his target was attacked
     */
    public void updateDoctor() {
        //player.activity.add("DocAtt");
    }

    /**
     * Update the Bodyguard that his target was targeted, and process his fate
     * accordingly
     */
    public void updateBG() { /*
        if (this.DocSubs.size() != 0) {
            notifyDoctors();
            player.activity.add("DocSave");
        } else {
            player.attackers.add("BGAttack");
        } */
    }

    /**
     * General attack method for killing roles.
     */
    public void lethalAttack(int num, String AttackerName) { /*

        boolean dead = true;
        if (Players.get(num).jailed) {
            Players.get(num).activity.add("JailSave");
            player.activity.add("NightImmune");
            return;
        }
        if (RoleInfo.NightImmune.contains(Players.get(num).name)) {
            Players.get(num).activity.add("ImmuneSave");
            player.activity.add("NightImmune");
            dead = false;
        }
        if (PlayerData.get(num).immune) {
            if (Players.get(num).name.equals("Doctor")) {
                Players.get(num).activity.add("DocSave");
                Players.get(num).activity.add("ImmuneSave");
            } else {
                Players.get(num).activity.add("VestSave");
            }
            player.activity.add("NightImmune");
            return;
        }
        if (Players.get(num).name.equals("Veteran") && alert) {
            Players.get(num).activity.add("VetAtt");
            if (DocSubs.size() != 0) {
                notifyDoctors();
                player.activity.add("DocSave");
            } else {
                player.attackers.add("Veteran");
            }
            return;
        }
        if (PlayerData.get(num).DocSubs.size() != 0) {
            dead = false;
            Players.get(num).activity.add("DocSave");
            PlayerData.get(num).notifyDoctors();
        }
        if (PlayerData.get(num).BGSubs.size() != 0) {
            dead = false;
            Players.get(num).activity.add("BGSave");
            PlayerData.get(num).notifyBG();
            if (DocSubs.size() != 0) {
                player.activity.add("DocvsBG");
                notifyDoctors();
            } else {
                player.attackers.add("Bodyguard");
            }
        }
        if (dead) {
            Players.get(num).attackers.add(AttackerName);
        } */

    }

    /**
     * Processes the main function of the role
     *
     */
    abstract public void Process();

}
