package roles;

public class Lookout extends RoleControl {

    public Lookout(String name, int num) {
        super(name, num);
    }

    public void Process() {

        if (!jailed) {
            target = validTownTarget(playerNum);
            nightAction = "You have decided to watch " + String.valueOf(target) + "(" +
                    players.get(target).roleName + ") tonight.";
            target = checkTargetSwitch(target);
            if (!blocked) {
                activity.add("LKVisits");
                players.get(target).visits.add(playerNum);
                checkVetVisit(target);
            }
        }

    }

}
