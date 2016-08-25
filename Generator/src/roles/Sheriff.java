package roles;

import actions.RoleInfo;

public class Sheriff extends RoleControl {

    public Sheriff(String name, int num) {
        super(name, num);
    }

    public void Process() {

        if (!jailed) {
            target = validTownTarget(playerNum);
            nightAction = "You have decided to interrogate " + String.valueOf(target) +
                    "(" + players.get(target).roleName + ") tonight.";
            target = checkTargetSwitch(target);
            if (!blocked) {
                checkVetVisit(target);
                players.get(target).visits.add(playerNum);
                if (players.get(target).roleName.equals("Serial Killer")) {
                    nightResult = "Your target is a Serial Killer!";
                } else if (RoleInfo.SheriffResults.contains(players.get(target).roleName)) {
                    nightResult = "Your target is a member of the Mafia!";
                } else {
                    nightResult = "Your target is not suspicious.";
                }
            }
        }

    }

}
