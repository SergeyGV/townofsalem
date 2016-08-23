package roles;

public class Consigliere extends RoleControl {

    public Consigliere(String name, int num) {
        super(name, num);
    }

    public void Process() {

        target = validNonDeathMafTarget();
        if (!jailed) {
            nightAction = "You have decided to investigate " + String.valueOf(target) +
                    "(" + players.get(target).roleName + ") tonight.";
            target = checkTargetSwitch(target);
            if (!blocked) {
                nightResult = "Your target is a " + players.get(target).roleName + "!";
                checkVetVisit(target);
            }

        }

    }

}
