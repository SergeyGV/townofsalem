package roles;

import static actions.Actions.AllVisits;
import static actions.Actions.Players;

public class Jailor extends RoleControl {

    public Jailor(String name, int num) {
        super(name, num);
    }

    public void Process(int Jailor) { /*

        player = Players.get(Jailor); // Get jailor profile
        target = validTownTarget(Jailor);
        AllVisits.get(target).add(Jailor);
        player.NightAction = "You hauled player " + String.valueOf(target) + " off to jail!";
        Players.get(target).NightAction = "You were hauled off to jail!";
        if (Players.get(target).name.equals("Serial Killer")) {
            player.attackers.add("JailedSK");
            Players.get(target).activity.add("SKJail");
        } else {
            Players.get(target).NightResult = "You did not perform any possible action due to jail.";
        }
        Players.get(target).jailed = true;
        Players.get(target).blocked = true; // For mafia killing if statement simplification
        */

    }

}
