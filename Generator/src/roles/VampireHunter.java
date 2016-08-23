package roles;

public class VampireHunter extends RoleControl {

    public VampireHunter(String name, int num) {
        super(name, num);
    }

    public void Process() {

        if (!jailed) {
            target = validTownTarget(playerNum);
            nightAction = "You have decided to check " + String.valueOf(target) + "(" +
                    players.get(target).roleName + ") tonight.";
            target = checkTargetSwitch(target);
            if (!blocked) {
                checkVetVisit(target);
                if (players.get(target).roleName.equals("Vampire")) {
                    lethalAttack(target, "Vampire Hunter");
               }
            }
        }

    }

}
