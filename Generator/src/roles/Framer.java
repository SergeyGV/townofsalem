package roles;

import actions.RoleInfo;

public class Framer extends RoleControl {

    public Framer(String name, int num) {
        super(name, num);
    }

    public void Process() {

        target = validNonDeathMafTarget();
        if (!jailed) {
            nightAction = "You have decided to frame " + String.valueOf(target) +
                    "(" + players.get(target).roleName + ") tonight.";
            target = checkTargetSwitch(target);
            if (!blocked) {
                RoleInfo.SheriffResults.add(players.get(target).roleName);
                RoleInfo.InvestResults.replace(players.get(target).roleName, "Framer/Forger");
            }

        }

    }

}
