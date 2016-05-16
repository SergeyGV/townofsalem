package roles;

import static actions.Actions.AllVisits;
import static actions.Actions.Players;

public class VampireHunter extends Data{

    public void Process(int VampireHunter) {

        player = Players.get(VampireHunter);
        if (!player.jailed) {
            target = validTownTarget(VampireHunter);
            player.NightAction = "You have decided to check " + String.valueOf(target) + "(" +
                    Players.get(target).name + ") tonight.";
            target = checkTargetSwitch(target);
            if (!player.blocked) {
                AllVisits.get(target).add(VampireHunter);
                if (Players.get(target).name.equals("Vampire")) {
                    lethalAttack(target, "Vampire Hunter");
               }
            }
        }

    }

}
