package roles;

import static actions.Actions.AllVisits;
import static actions.Actions.MafiaVisits;
import static actions.Actions.Players;

public class Janitor extends Data {

    public void Process(int Janitor) {

        player = Players.get(Janitor);
        if (!player.jailed) {
            player.NightAction = "You have decided to clean " + String.valueOf(MafTarget) + "(" +
                    Players.get(MafTarget).name + ") tonight.";
            target = checkTargetSwitch(MafTarget);
            if (!player.blocked) {
                Players.get(target).cleaned = true;
                checkLateVetVisit(target);
                MafiaVisits.add(target);
                AllVisits.get(target).add(Janitor);
            }
        }

    }

}
