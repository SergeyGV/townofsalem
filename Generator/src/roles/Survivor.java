package roles;

public class Survivor extends RoleControl {

    public Survivor(String name, int num) {
        super(name, num);
    }

    public void Process() { /*

        player = Players.get(Survivor);
        if (!player.jailed) {
            if (randomizer.nextInt(4) != 0) { // 75% odds of Vest, 25% odds of no Vest
                player.NightAction = "You have decided to use a vest tonight.";
                if (!player.blocked) {
                    immune = true;
                }
            } else {
                player.NightAction = "You have decided to not use a vest tonight.";
                if (player.witched != 0) {
                    if (!player.blocked) {
                        immune = true;
                    }
                } else {
                    player.NightResult = "You did not perform your night action.";
                }
            }
        } */

    }

}
