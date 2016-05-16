package roles;

import actions.RoleInfo;

import static actions.Actions.AllVisits;
import static actions.Actions.Players;
import static roles.Data.*;

public class Escort extends Data {

    public void Process(int Escort) {

        player = Players.get(Escort);
        if (!player.jailed) {
            target = validTownTarget(Escort);
            player.NightAction = "You have decided to roleblock " + String.valueOf(target) + "(" +
                    Players.get(target).name + ") tonight.";
            target = checkTargetSwitch(target); // Process both witching and transporting
            if (Players.get(target).name.equals("Serial Killer")) {
                player.attackers.add("SKVisit");
                Players.get(target).activity.add("SKBlock");
                Players.get(target).blocked = true;
            } else if (Players.get(target).jailed) {
                Players.get(target).activity.add("RBJail");
            } else if (RoleInfo.RoleBlockImmune.contains(Players.get(target).name)) {
                Players.get(target).activity.add("RBImmune");
                checkVetVisit(target);
            } else {
                Players.get(target).activity.add("RB");
                Players.get(target).blocked = true;
            }
            AllVisits.get(target).add(Escort);
        }

    }

}
