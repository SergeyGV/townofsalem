package roles;

public class Godfather extends RoleControl {

    public Godfather(String name, int num) {
        super(name, num);
    }

    public void Process() {

        if (!jailed) {
            nightAction = "You have decided to kill " + String.valueOf(mafTarget) +
                    "(" + players.get(mafTarget).roleName + ") tonight.";
            // Also used by the Mafioso if this class doesn't kill
            if (!blocked) {
                finMafTarget = checkTargetSwitch(mafTarget);
            }
            // Don't need to check for role blocking as MafiaKillers does it
            if (mafKiller.equals("Godfather")) {
                lethalAttack(finMafTarget, "Mafia");
            }
        }

    }

}
