package roles;

import actions.RoleInfo;

import static actions.Actions.AllVisits;
import static actions.Actions.Players;

public class Witch extends RoleControl {

    public Witch(String name, int num) {
        super(name, num);
    }

    public void Process(int Witch) { /*

        player = Players.get(Witch);
        if (!player.jailed) {
            target = validTownTarget(Witch); // Source target
            target2 = validTownTarget(Witch); // Destination target
            player.NightAction = "You have decided to control " + String.valueOf(target) + "(" +
                    Players.get(target).name + ") to " + String.valueOf(target2) + "(" +
                    Players.get(target2).name + ").";
            target = checkTransporter(target);
            target2 = checkTransporter(target2);
            if (Players.get(target).jailed) {
                Players.get(target).activity.add("WitchJail");
            } else if (RoleInfo.ControlImmune.contains(Players.get(target).name)) {
                Players.get(target).activity.add("WitchImmune");
                checkVetVisit(target); // Only check vet visits here because he is immune
            } else {
                Players.get(target).activity.add("Witched");
                if (Players.get(target).witched != 0) {
                    player.NightResult = "Another witch has controlled your target first!";
                } else {
                    Players.get(target).witched = target2;
                }
            }
            AllVisits.get(target).add(Witch);
        } */

    }

}
