package roles;

public class Lookout extends RoleControl {

    public Lookout(String name, int num) {
        super(name, num);
    }

    public void Process() { /*

        player = Players.get(Lookout);
        if (!player.jailed) {
            target = validTownTarget(Lookout);
            player.NightAction = "You have decided to watch " + String.valueOf(target) + "(" +
                    Players.get(target).name + ") tonight.";
            target = checkTargetSwitch(target);
            if (!player.blocked) {
                player.activity.add("LKVisits");
                player.watching = target;
                AllVisits.get(target).add(Lookout);
                checkLateVetVisit(target);
            }
        } */

    }

}
