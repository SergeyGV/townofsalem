package roles;

import static actions.Actions.AllVisits;
import static actions.Actions.MafiaVisits;
import static actions.Actions.Players;

public class Godfather extends RoleControl {

    public Godfather(String name, int num) {
        super(name, num);
    }

    public void Process(int Godfather) {

        player = Players.get(Godfather);
        lethalAttack(FinMafTarget, "Mafia");
        MafiaVisits.add(FinMafTarget);
        AllVisits.get(FinMafTarget).add(Godfather);

    }

}
