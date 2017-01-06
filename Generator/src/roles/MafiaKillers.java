package roles;

import actions.Actions;

import java.util.ArrayList;
import java.util.Collections;

public class MafiaKillers extends RoleControl {

    public MafiaKillers(String name) {
        super(name);
    }

    public void Process() {

        // Killer being chosen
        mafTarget = validMafTarget();
        finMafTarget = 0;
        for (RoleControl player: players.values()) {
            if (player.roleName.equals("Mafioso")) {
                mfBlock = player.jailed || player.blocked;
                if (!player.jailed) {
                    mkJailed = false;
                }
            }
            if (player.roleName.equals("Godfather")) {
                gfBlock = player.jailed || player.blocked;
                if (!player.jailed) {
                    mkJailed = false;
                }
            }
        }
        if (!mfBlock) {
            mafKiller = "Mafioso";
        } else if (!gfBlock) {
            mafKiller = "Godfather";
        }

        // Get all non-jailed MDs & Disguisors
        ArrayList<Integer> availableMDs =  new ArrayList<>();
        for (int md: Actions.curActions.getMdRoles()) {
            if (!players.get(md).jailed) {
                availableMDs.add(md);
            }
        }

        // Assign one in each category to act(if there are any available)
        if (availableMDs.size() > 0) {
            Collections.shuffle(availableMDs);
            RoleControl.visitingMD = availableMDs.get(0);
        }

    }

}
