package roles;

public class Forger extends RoleControl {

    public Forger(String name, int num) {
        super(name, num);
    }

    public void Process() {

        if (!jailed) {
            // If 0, all present MKs are visibly blocked, and there is no point in doing anything
            if (finMafTarget == 0) {
                nightAction = "You have decided to do nothing this night.";
                target = 0;
            } else {
                nightAction = "You have decided to forge " + String.valueOf(mafTarget) + "(" +
                        players.get(mafTarget).roleName + ") tonight.";
                target = mafTarget;
            }
            target = checkTargetSwitch(target);
            if (target == 0) {
                nightResult = "You did not perform your night ability.";
            } else if (!blocked) {
                players.get(target).forged = true;
                checkVetVisit(target);
            }
        }

    }

}
