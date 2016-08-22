package roles;

public class Mafioso extends RoleControl {

    public Mafioso(String name, int num) {
        super(name, num);
    }

    public void Process() {

        if (!jailed) {
            nightAction = "You have voted to kill " + String.valueOf(mafTarget) +
                    "(" + players.get(mafTarget).roleName + ") tonight.";
            if (mafKiller.equals("Mafioso")) {
                if (witched != 0 || finMafTarget == 0) {
                    finMafTarget = checkTargetSwitch(mafTarget);
                }
                lethalAttack(finMafTarget, "Mafia");
                if (players.get(finMafTarget).attackers.contains("Mafia") && gfControl) {
                    nightResult = "The godfather has ordered you to kill his target.";
                }
            }
        }

    }

}
