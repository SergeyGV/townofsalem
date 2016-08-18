package roles;

public class SerialKiller extends RoleControl {

    public SerialKiller(String name, int num) {
        super(name, num);
    }

    public void Process() { /*

        player = Players.get(SK);
        target = validTownTarget(SK);
        if (!player.jailed) {
            player.NightAction = "You have decided to kill " + String.valueOf(target) + "(" +
                    Players.get(target).name + ") tonight.";
        }
        if (!player.blocked) {
            target = checkTargetSwitch(target);
            AllVisits.get(target).add(SK);
            lethalAttack(target, "Serial Killer");
        } */

    }

}
