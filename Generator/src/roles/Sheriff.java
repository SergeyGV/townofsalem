package roles;

public class Sheriff extends RoleControl {

    public Sheriff(String name, int num) {
        super(name, num);
    }

    public void Process() { /*

        player = Players.get(Sheriff);
        if (!player.jailed) {
            target = validTownTarget(Sheriff);
            player.NightAction = "You have decided to interrogate " + String.valueOf(target) +
                    "(" + Players.get(target).name + ") tonight.";
            target = checkTargetSwitch(target);
            if (!player.blocked) {
                AllVisits.get(target).add(Sheriff);
                player.NightResult = "Your target is" + Players.get(target).ShrResult;
                checkVetVisit(target);
            }
        } */

    }

}
