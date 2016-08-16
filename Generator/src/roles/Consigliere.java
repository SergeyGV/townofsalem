package roles;

import static actions.Actions.AllVisits;
import static actions.Actions.MafiaVisits;
import static actions.Actions.Players;

public class Consigliere extends RoleControl {

    public Consigliere(String name, int num) {
        super(name, num);
    }

    public void Process(int Consigliere) {

        player = Players.get(Consigliere);
        target = validMafTarget();
        while (target == MafTarget) {
            target = validMafTarget();
        }
        if (!player.jailed) {
            player.NightAction = "You have decided to investigate " + String.valueOf(target) +
                    "(" + Players.get(target).name + ") tonight.";
            target = checkTargetSwitch(target);
            MafiaVisits.add(target);
            if (!player.blocked) {
                player.NightResult = "Your target is a " + Players.get(target).name + "!";
                checkVetVisit(target);
                AllVisits.get(target).add(Consigliere);
            }

        }
        // TODO: Spy visits here

    }

}
