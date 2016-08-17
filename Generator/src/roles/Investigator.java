package roles;

import static actions.Actions.AllVisits;
import static actions.Actions.Players;

public class Investigator extends RoleControl {

    public Investigator(String name, int num) {
        super(name, num);
    }

    public void Process(int Investigator) { /*

        player = Players.get(Investigator);
        if (!player.jailed) {
            target = validTownTarget(Investigator);
            player.NightAction = "You have decided to investigate " + String.valueOf(target) +
                    "(" + Players.get(target).name + ") tonight.";
            target = checkTargetSwitch(target);
            if (!player.blocked) {
                AllVisits.get(target).add(Investigator);
                checkVetVisit(target);
                player.NightResult = "Your target must be a " + Players.get(target).InvResult;
            }
        }
        */
    }

}
