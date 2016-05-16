package roles;

import static actions.Actions.AllVisits;
import static actions.Actions.MafiaVisits;
import static actions.Actions.Players;

public class Disguisor extends Data {

    public void Process(int Disguisor) {

        player = Players.get(Disguisor);
        if (!player.jailed && !player.blocked) {
            if (player.witched == 0) {
                player.NightResult = "You did not perform your night ability";
            } else {
                if (!player.blocked) {
                    target = checkTargetSwitch(0);
                    AllVisits.get(target).add(Disguisor);
                    Players.get(target).disguised = true;
                    checkLateVetVisit(target);
                    MafiaVisits.add(target);
                }
            }
        }

    }

}
