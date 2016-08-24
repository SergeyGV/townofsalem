package actions;

import generation.RoleStorage;
import printer.ActivityPrint;
import roles.*;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Actions - The main processor of the night activity
 */

public class Actions {

    private HashMap<Integer, RoleControl> PlayerData;
    private ArrayList<Integer> mafiaList;
    private ArrayList<Integer> vampList;

    /**
     * The main generation method of the night activity
     * @param playerlist The rolelist
     */
    /*
     * TODO: RoleControl - Refactor Notify/Update methods into one method
     * TODO: RoleControl - Refactor the mess of the attacking method
     * TODO: ActivityPrint - Sort messages before print so it's not a mess(for attacks, like SKs hitting each other)
     *
     * Note: Arsonist dousing himself via transport/witch while the BG is on him will cause
     * the BG to "save" him and then kill him. Intended behavior? Arsonist can't really douse
     * himself, doing so just ignites, so he shouldn't really harm himself if forced on himself.
     * Keep it for now... TODO: if changed, add ignition code
     *
     * Note: Immune players protected by BG show their immunity or no if saved?
     * Note: If Doc is shot and killed by Vet, no point in saving? Add return?
     */
    public void generate(ArrayList<String> playerlist) {

        PriorityQueue<RoleControl> allRoles = new PriorityQueue<>(new RoleComparator());
        PlayerData = new HashMap<>();
        mafiaList = new ArrayList<>();
        vampList = new ArrayList<>();
        for (int i = 0; i < playerlist.size(); i++) {
            try {
                Class<?> gottenRole = Class.forName("roles." + playerlist.get(i).replaceAll(" ", ""));
                Constructor<?> cons = gottenRole.getConstructor(String.class, Integer.TYPE);
                Object ins = cons.newInstance(playerlist.get(i), i + 1);
                RoleControl theRole = (RoleControl) ins;
                PlayerData.put(i + 1, theRole);
                allRoles.add(theRole);
                if (RoleInfo.allMafia.contains(playerlist.get(i))) {
                    mafiaList.add(i+1);
                } else if (playerlist.get(i).equals("Vampire")) {
                    vampList.add(i+1);
                }
            } catch (Exception e) {
                System.out.println("Something broke!");
            }
        }
        allRoles.add(new MafiaKillers("MafTarget"));
        RoleControl.players = PlayerData;
        RoleControl.mafia = mafiaList;
        RoleControl.vampires = vampList;
        if (vampList.size() > 0) {
            Collections.shuffle(vampList);
            RoleControl.visitingVamp = vampList.get(0);
        }
        while (!allRoles.isEmpty()) {
            allRoles.remove().Process();
        }

        new ActivityPrint(PlayerData); // Report results to terminal

    }

}
