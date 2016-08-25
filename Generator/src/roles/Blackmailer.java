package roles;

public class Blackmailer extends RoleControl {

    public Blackmailer(String name, int num) {
        super(name, num);
    }

    public void Process() {

        target = validNonDeathMafTarget();
        if (!jailed) {
            nightAction = "You have decided to blackmail " + String.valueOf(target) +
                    "(" + players.get(target).roleName + ") tonight.";
            target = checkTargetSwitch(target);
            if (!blocked) {
                mafVisits.add(target);
                players.get(target).visits.add(playerNum);
                if (players.get(target).jailed) {
                    players.get(target).activity.add("BMJail");
                } else {
                    checkVetVisit(target);
                    players.get(target).activity.add("BM");
                }
            }

        }
    }

}
