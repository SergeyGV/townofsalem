package roles;

import actions.RoleInfo;

public class Escort extends RoleControl {

    public Escort(String name, int num) {
        super(name, num);
    }

    public void Process() {

        if (!jailed) {
            target = validTownTarget(playerNum);
            nightAction = "You have decided to roleblock " + String.valueOf(target) + "(" +
                    players.get(target).roleName + ") tonight.";
            target = checkTargetSwitch(target); // Process both witching and transporting
            players.get(target).visits.add(playerNum);
            if (players.get(target).roleName.equals("Serial Killer")) {
                attackers.add("SKVisit");
                players.get(target).activity.add("SKBlock");
                players.get(target).blocked = true;
            } else {
                if (players.get(target).jailed) {
                    players.get(target).activity.add("RBJail");
                } else if (RoleInfo.RoleBlockImmune.contains(players.get(target).roleName)) {
                    players.get(target).activity.add("RBImmune");
                    checkVetVisit(target); // Only check vet visits here because he is immune
                } else {
                    players.get(target).activity.add("RB");
                    players.get(target).blocked = true;
                }
            }
        }

    }

}
