package roles;

import static actions.Actions.AllVisits;
import static actions.Actions.Players;

public class Lookout extends RoleControl {

    public void Process(int Lookout) {

        player = Players.get(Lookout);
        if (!player.jailed) {
            target = validTownTarget(Lookout);
            player.NightAction = "You have decided to watch " + String.valueOf(target) + "(" +
                    Players.get(target).name + ") tonight.";
            target = checkTargetSwitch(target);
            if (!player.blocked) {
                player.activity.add("LKVisits");
                player.watching = target;
                AllVisits.get(target).add(Lookout);
                checkLateVetVisit(target);
            }
        }

    }

}
