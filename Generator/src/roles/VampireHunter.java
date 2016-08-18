package roles;

public class VampireHunter extends RoleControl {

    public VampireHunter(String name, int num) {
        super(name, num);
    }

    public void Process() { /*

        player = Players.get(VampireHunter);
        if (!player.jailed) {
            target = validTownTarget(VampireHunter);
            player.NightAction = "You have decided to check " + String.valueOf(target) + "(" +
                    Players.get(target).name + ") tonight.";
            target = checkTargetSwitch(target);
            if (!player.blocked) {
                AllVisits.get(target).add(VampireHunter);
                if (Players.get(target).name.equals("Vampire")) {
                    lethalAttack(target, "Vampire Hunter");
               }
            }
        } */

    }

}
