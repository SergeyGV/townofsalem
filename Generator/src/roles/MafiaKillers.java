package roles;

import actions.Actions;

import static actions.Actions.Godfather;
import static actions.Actions.Mafioso;
import static actions.Actions.Players;

public class MafiaKillers extends RoleControl {

    public void Process(int INeedMyOwnMethodInActionsPlease) {

        if (Players.get(Godfather).witched != 0) {
            player = Players.get(Godfather);
            FinMafTarget = checkTargetSwitch(MafTarget);
        } else {
            player = Players.get(Mafioso);
            FinMafTarget = checkTargetSwitch(MafTarget);
        }
        if (!Players.get(Godfather).jailed) {
            Players.get(Godfather).NightAction = "You have decided to kill " + String.valueOf(MafTarget) + "(" +
                    Players.get(MafTarget).name + ") tonight.";
        }
        if (!Players.get(Mafioso).jailed) {
            Players.get(Mafioso).NightAction = "You have voted to kill " + String.valueOf(MafTarget) + "(" +
                    Players.get(MafTarget).name + ") tonight.";
        }
        if (!Players.get(Mafioso).blocked) {
            player = Players.get(Mafioso);
            if (player.witched == 0 && !Players.get(Godfather).jailed) {
                player.NightResult = "The godfather has ordered you to kill his target.";
            }
            Actions.Attackers.add(Mafioso);
        } else if (!Players.get(Godfather).blocked) {
            player = Players.get(Godfather);
            Actions.Attackers.add(Godfather);
        }

    }

}
