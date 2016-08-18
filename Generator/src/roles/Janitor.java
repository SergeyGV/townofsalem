package roles;

public class Janitor extends RoleControl {

    public Janitor(String name, int num) {
        super(name, num);
    }

    public void Process() { /*

        player = Players.get(Janitor);
        if (!player.jailed) {
            player.NightAction = "You have decided to clean " + String.valueOf(MafTarget) + "(" +
                    Players.get(MafTarget).name + ") tonight.";
            target = checkTargetSwitch(MafTarget);
            if (!player.blocked) {
                Players.get(target).cleaned = true;
                checkLateVetVisit(target);
                MafiaVisits.add(target);
                AllVisits.get(target).add(Janitor);
            }
        } */

    }

}
