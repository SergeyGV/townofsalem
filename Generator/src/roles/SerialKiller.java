package roles;

import static actions.Actions.AllVisits;
import static actions.Actions.Players;

public class SerialKiller extends Data {

    public void Process(int SK) {

        player = Players.get(SK);
        target = validTownTarget(SK);
        if (!player.jailed) {
            player.NightAction = "You have decided to kill " + String.valueOf(target) + "(" +
                    Players.get(target).name + ") tonight.";
        }
        if (!player.blocked) {
            target = checkTargetSwitch(target);
            AllVisits.get(target).add(SK);
            lethalAttack(target, "Serial Killer");
        }

    }

}
