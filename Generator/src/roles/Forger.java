package roles;

import static actions.Actions.AllVisits;
import static actions.Actions.MafiaVisits;
import static actions.Actions.Players;

public class Forger extends Data {

    public void Process(int Forger) {

        player = Players.get(Forger);
        if (!player.jailed) {
            player.NightAction = "You have decided to forge " + String.valueOf(MafTarget) + "(" +
                    Players.get(MafTarget).name + ") tonight.";
            target = checkTargetSwitch(MafTarget);
            if (!player.blocked) {
                MafiaVisits.add(target);
                Players.get(target).forged = true;
                checkLateVetVisit(target);
                AllVisits.get(target).add(Forger);
            }
        }

    }

}
