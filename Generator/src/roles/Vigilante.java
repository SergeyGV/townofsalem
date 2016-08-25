package roles;

public class Vigilante extends RoleControl {

    public Vigilante(String name, int num) {
        super(name, num);
    }

    public void Process() {

        if (!jailed) {
            nightAction = "You have decided to wait a day before using your gun.";
            if (!blocked && witched != 0) {
                target = checkTargetSwitch(0); // Target will switch, the 0 represents nothing
                lethalAttack(target, "Vigilante");
                players.get(target).visits.add(playerNum);
            }
        }

    }

}
