package roles;

import static actions.Actions.AllVisits;
import static actions.Actions.MafiaVisits;
import static actions.Actions.Players;

public class Blackmailer extends RoleControl {

    public Blackmailer(String name, int num) {
        super(name, num);
    }

    public void Process(int Blackmailer) {

        player = Players.get(Blackmailer);
        target = validMafTarget();
        while (target == MafTarget) {
            target = validMafTarget();
        }
        if (!player.jailed) {
            player.NightAction = "You have decided to blackmail " + String.valueOf(target) +
                    "(" + Players.get(target).name + ") tonight.";
            target = checkTargetSwitch(target);
            if (!player.blocked) {
                checkVetVisit(target);
                MafiaVisits.add(target);
                AllVisits.get(target).add(Blackmailer);
                if (Players.get(target).jailed) {
                    Players.get(target).activity.add("BMJail");
                } else {
                    Players.get(target).activity.add("BM");
                }
            }

        }
    }

}
