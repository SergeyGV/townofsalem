package roles;

public class Bodyguard extends RoleControl {

    public Bodyguard(String name, int num) {
        super(name, num);
    }

    public void Process() { /*

        player = Players.get(Bodyguard);
        if (!player.jailed) {
            target = validTownTarget(-1); // Pick anything
            if (target != Bodyguard) {
                player.NightAction = "You have decided to protect " + String.valueOf(target) +
                        "(" + Players.get(target).name + ") tonight.";
            } else {
                player.NightAction = "You have decided to use a vest this night.";
            }
            target = checkTargetSwitch(target);
            if (!player.blocked) {
                AllVisits.get(target).add(Bodyguard);
                if (!checkVetVisit(target)) {
                    if (target == Bodyguard) {
                        immune = true;
                    } else {
                        PlayerData.get(target).subscribeBG(Bodyguard);
                    }
                }
            }
        } */

    }

}
