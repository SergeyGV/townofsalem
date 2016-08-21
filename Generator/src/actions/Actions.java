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

    private HashMap<Integer, RoleControl> PlayerData;
    private ArrayList<Integer> mafiaList;

    /**
     * The main generation method of the night activity
     * @param playerlist The rolelist
     */
    /*
     * TODO: Oh my GOD, WHAT ISN'T THERE TO DO
     * TODO: KEEP ON CHUGGING, KEEP ON GUTTING
     * TODO: GOING BACK TO THE STONE AGE TO RESTART THE NUCLEAR AGE
     * TODO: Consort(and other maf) - Update getValidMafTarget in RoleControl
     * TODO: Jailor - Jailing the Serial Killer
     * TODO: Escort, Consort - Escorting the Serial Killer
     * TODO: Veteran - Once killing stage reached: update Vet class and add Vet visit checks for visitors
     */
    public void generate(ArrayList<String> playerlist) {

        PriorityQueue<RoleControl> allRoles = new PriorityQueue<>(new RoleComparator());
        PlayerData = new HashMap<>();
        for (int i = 0; i < playerlist.size(); i++) {
            try {
                Class<?> gottenRole = Class.forName("roles." + playerlist.get(i).replaceAll(" ", ""));
                Constructor<?> cons = gottenRole.getConstructor(String.class, Integer.TYPE);
                Object ins = cons.newInstance(playerlist.get(i), i + 1);
                RoleControl theRole = (RoleControl) ins;
                PlayerData.put(i + 1, theRole);
                allRoles.add(theRole);
            } catch (Exception e) {
                System.out.println("Something broke!");
            }
        }
        RoleControl.players = PlayerData;
        while (!allRoles.isEmpty()) {
            allRoles.remove().Process();
        }

        new ActivityPrint(PlayerData); // Report results to terminal */

    }

}
