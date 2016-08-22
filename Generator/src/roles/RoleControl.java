package roles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public abstract class RoleControl {

    public String roleName; // The player's role name
    public String nightAction; // What the player chooses to be their night action
    public String nightResult; // What the player sees as the result for their night action(if it worked)
    static String mafKiller = "No one"; // The name of the Mafia Killer that will go out to kill
    static int mafTarget; // The target of the Mafia that is marked for death
    int playerNum; // The number of the player
    int target; // Used to keep track of player targets
    int target2; // Used for multi target roles
    int witched = 0; // Indicator for which target is the player forced to visit(if Witched)
    boolean jailed = false; // If the player is Jailed
    boolean blocked = false; // If the player is roleblocked
    boolean immune; // Used to keep track of if people vested/self-healed
    public ArrayList<String> activity; // Influence from other roles that they are notified of(non-lethal)
    ArrayList<Integer> DocSubs = new ArrayList<>(); // Tracks Doctor subscribers
    ArrayList<Integer> BGSubs = new ArrayList<>(); // Tracks Bodyguard subscribers
    public static ArrayList<Integer> mafia; // Indicator for all the mafia in the role list
    Random randomizer = new Random(); // Used for random generation of numbers
    static HashMap<Integer, Integer> switches; // Tracks which targets were transported
    public static HashMap<Integer, RoleControl> players; // Tracker for all the players
    //static boolean alert = false; // Indication if the Veteran has gone on alert

    /**
     * Used only by MafiaKillers
     */
    public RoleControl(String name) {
        roleName = name;
    }

    public RoleControl(String name, int num) {
        roleName = name;
        playerNum = num;
        nightAction = "";
        nightResult = "";
        activity = new ArrayList<>();
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

        int target = randomizer.nextInt(players.size()) + 1;
        while (player == target) {
            target = randomizer.nextInt(players.size()) + 1;
        }
        return(target);

    }

    /**
     * Returns a valid target for the mafia. A valid mafia target is everyone
     * in the town that does not happen to be a member of the mafia.
     *
     * @return The target number
     */
    public int validMafTarget() {

        int target = randomizer.nextInt(players.size()) + 1;
        while (mafia.contains(target)) {
            target = randomizer.nextInt(players.size()) + 1;
        }
        return(target);

    }

    /**
     * Returns a valid target for the mafia that is not marked for death by the mafia.
     * A valid mafia target is everyone in the town that does not happen to be a member of the mafia.
     * This method should only be called once MafiaKillers has been processed
     *
     * @return The target number
     */
    public int validNonDeathMafTarget() {
        target = validMafTarget();
        /*
         * Special case: Role list is only 6 players, with 5 mafia. Attempting to run the while loop
         * at the bottom of the function will cause an infinite loop. Following if prevents this,
         * and forces the role to simply visit the target marked for death instead.
         */
        if (mafia.size() == 5 && players.size() == 6) {
            return target;
        }
        while (target == mafTarget) {
            target = validMafTarget();
        }
        return target;
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
    public int checkTargetSwitch(int num) {

        int target = num;
        if (witched != 0) {
            target = witched;
        }
        if (switches.containsKey(target)) {
            return (switches.get(target));
        }
        return(target);

    }


    /**
     * Subscribe a player(who is a Doctor) to the player of this class
     *
     * @param Doctor The Doctor's player number
     */
    public void subscribeDoctor(int Doctor) {
        DocSubs.add(Doctor);
    }

    /**
     * Subscribe a player(who is a Bodyguard) to the player of this class
     *
     * @param Bodyguard The Bodyguard's player number
     */
    public void subscribeBG(int Bodyguard) {
        BGSubs.add(Bodyguard);
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
