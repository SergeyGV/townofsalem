package roles;

import static actions.Actions.AllVisits;
import static actions.Actions.Players;

public class Vigilante extends RoleControl {

    public Vigilante(String name, int num) {
        super(name, num);
    }

    public void Process(int Vigilante) {

        player = Players.get(Vigilante);
        if (!player.jailed) {
            player.NightAction = "You have decided to wait a day before using your gun.";
            if (!player.blocked && player.witched != 0) {
                target = checkTargetSwitch(0); // Target will switch, the 0 represents nothing
                lethalAttack(target, "Vigilante");
                AllVisits.get(target).add(Vigilante);
            }
        }

    }

}
