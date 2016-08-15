package roles;

import static actions.Actions.AllVisits;
import static actions.Actions.PlayerData;
import static actions.Actions.Players;

public class Bodyguard extends RoleControl {

    public void Process(int Bodyguard) {

        player = Players.get(Bodyguard);
        if (!player.jailed) {
            target = validTownTarget(-1); // Pick anything
            if (target != Bodyguard) {
                player.NightAction = "You have decided to protect " + String.valueOf(target) +
                        "(" + Players.get(target).name + ") tonight.";
            } else {
                player.NightAction = "You have decided to use a vest this night.";
            }
            target = checkTargetSwitch(target);
            if (!player.blocked) {
                AllVisits.get(target).add(Bodyguard);
                if (!checkVetVisit(target)) {
                    if (target == Bodyguard) {
                        immune = true;
                    } else {
                        PlayerData.get(target).subscribeBG(Bodyguard);
                    }
                }
            }
        }

    }

}
