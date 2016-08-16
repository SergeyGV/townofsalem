package roles;

import static actions.Actions.AllVisits;
import static actions.Actions.MafiaVisits;
import static actions.Actions.Players;

public class Framer extends RoleControl {

    public Framer(String name, int num) {
        super(name, num);
    }

    public void Process(int Framer) {

        player = Players.get(Framer);
        target = validMafTarget();
        while (target == MafTarget) {
            target = validMafTarget();
        }
        if (!player.jailed) {
            player.NightAction = "You have decided to frame " + String.valueOf(target) +
                    "(" + Players.get(target).name + ") tonight.";
            target = checkTargetSwitch(target);
            MafiaVisits.add(target);
            AllVisits.get(target).add(Framer);
            if (!player.blocked) {
                checkVetVisit(target);
                Players.get(target).ShrResult = " a member of the Mafia!";
                Players.get(target).InvResult = "Framer/Forger";
            }

        }
    }

}
