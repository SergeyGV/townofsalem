package roles;

import static actions.Actions.AllVisits;
import static actions.Actions.MafiaVisits;
import static actions.Actions.Players;

public class Mafioso extends RoleControl {

    public void Process(int Mafioso) {

        player = Players.get(Mafioso);
        lethalAttack(FinMafTarget, "Mafia");
        MafiaVisits.add(FinMafTarget);
        AllVisits.get(FinMafTarget).add(Mafioso);

    }

}
