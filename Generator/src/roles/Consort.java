package roles;

import actions.RoleInfo;

public class Consort extends RoleControl {

    public Consort(String name, int num) {
        super(name, num);
    }

    public void Process() {

        if (!jailed) {
            target = validTownTarget(playerNum);
            target = validMafTarget();
            nightAction = "You have decided to roleblock " + String.valueOf(target) + "(" +
                    players.get(target).roleName + ") tonight.";
            target = checkTargetSwitch(target); // Process both witching and transporting
            /*if (players.get(target).name.equals("Serial Killer")) {
                player.attackers.add("SKVisit");
                players.get(target).activity.add("SKBlock");
                players.get(target).blocked = true;
            } else <-- Cut off from below statement */
            if (players.get(target).jailed) {
                players.get(target).activity.add("RBJail");
            } else if (RoleInfo.RoleBlockImmune.contains(players.get(target).roleName)) {
                players.get(target).activity.add("RBImmune");
                checkVetVisit(target);
            } else {
                players.get(target).activity.add("RB");
                players.get(target).blocked = true;
            }
        }

    }

}
