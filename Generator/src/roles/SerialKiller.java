package roles;

public class SerialKiller extends RoleControl {

    public SerialKiller(String name, int num) {
        super(name, num);
    }

    public void Process() {

        target = validTownTarget(playerNum);
        if (!jailed) {
            nightAction = "You have decided to kill " + String.valueOf(target) + "(" +
                    players.get(target).roleName + ") tonight.";
            if (!blocked) {
                target = checkTargetSwitch(target);
                lethalAttack(target, "Serial Killer");
            }
        }

    }

}
