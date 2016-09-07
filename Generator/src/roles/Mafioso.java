package roles;

public class Mafioso extends RoleControl {

    public Mafioso(String name, int num) {
        super(name, num);
    }

    public void Process() {

        if (!jailed) {
            nightAction = "You have voted to kill " + String.valueOf(mafTarget) +
                    "(" + players.get(mafTarget).roleName + ") tonight.";
            if (mafKiller.equals("Mafioso") && !blocked) {
                if (witched != 0 || finMafTarget == 0) {
                    finMafTarget = checkTargetSwitch(mafTarget);
                }
                lethalAttack(finMafTarget, "Mafia");
                mafVisits.add(finMafTarget);
                players.get(finMafTarget).visits.add(playerNum);
                if (!gfBlock) { // If not killing on his own will, display message
                    nightResult = "The godfather has ordered you to kill his target.";
                }
            }
        }

    }

}
