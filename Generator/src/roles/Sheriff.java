package roles;

import static actions.Actions.AllVisits;
import static actions.Actions.Players;

public class Sheriff extends RoleControl {

    public void Process(int Sheriff) {

        player = Players.get(Sheriff);
        if (!player.jailed) {
            target = validTownTarget(Sheriff);
            player.NightAction = "You have decided to interrogate " + String.valueOf(target) +
                    "(" + Players.get(target).name + ") tonight.";
            target = checkTargetSwitch(target);
            if (!player.blocked) {
                AllVisits.get(target).add(Sheriff);
                player.NightResult = "Your target is" + Players.get(target).ShrResult;
                checkVetVisit(target);
            }
        }

    }

}
