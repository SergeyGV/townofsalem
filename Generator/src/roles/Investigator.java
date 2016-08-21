package roles;

import actions.RoleInfo;

public class Investigator extends RoleControl {

    public Investigator(String name, int num) {
        super(name, num);
    }

    public void Process() {

        if (!jailed) {
            target = validTownTarget(playerNum);
            nightAction = "You have decided to investigate " + String.valueOf(target) +
                    "(" + players.get(target).roleName + ") tonight.";
            target = checkTargetSwitch(target);
            if (!blocked) {
                nightResult = "Your target must be a " + RoleInfo.InvestResults.get(players.get(target).roleName);
            }
        }

    }

}
