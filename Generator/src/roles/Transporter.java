package roles;


import static actions.Actions.AllVisits;
import static actions.Actions.Players;


public class Transporter extends RoleControl {

    public void Process(int Transporter) {

        player = Players.get(Transporter);
        if (!player.jailed) {
            target = validTownTarget(Transporter);
            target2 = validTownTarget(Transporter);
            AllVisits.get(target).add(Transporter);
            AllVisits.get(target2).add(Transporter);
            player.NightAction = "You have decided to swap " + String.valueOf(target) + "(" +
                    Players.get(target).name + ") with " + String.valueOf(target2) + "(" +
                    Players.get(target2).name + ") tonight.";
            // Cannot transport if one of the targets is jailed
            if (!Players.get(target).jailed && !Players.get(target2).jailed) {
                // If one target has already been transported then the current transporter has no effect
                if (!switches.containsKey(target) && !switches.containsKey(target2)) {
                    switches.put(target, target2);
                    switches.put(target2, target);
                } else {
                    player.NightResult = "Another transporter chose your target first, so you had no effect!";
                }
                Players.get(target).activity.add("Transported");
                Players.get(target2).activity.add("Transported");
                checkVetVisit(target);
                if (target != target2) {
                    checkVetVisit(target2);
                }
            } else {
                player.NightResult = "You could not transport as one of your targets was jailed!";
            }
        }

    }


}
