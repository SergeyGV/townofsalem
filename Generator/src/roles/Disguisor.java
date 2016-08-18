package roles;

public class Disguisor extends RoleControl {

    public Disguisor(String name, int num) {
        super(name, num);
    }

    public void Process() { /*

        player = Players.get(Disguisor);
        if (!player.jailed && !player.blocked) {
            if (player.witched == 0) {
                player.NightResult = "You did not perform your night ability";
            } else {
                if (!player.blocked) {
                    target = checkTargetSwitch(0);
                    AllVisits.get(target).add(Disguisor);
                    Players.get(target).disguised = true;
                    checkLateVetVisit(target);
                    MafiaVisits.add(target);
                }
            }
        } */

    }

}
