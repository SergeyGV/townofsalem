package roles;

public class Bodyguard extends RoleControl {

    public Bodyguard(String name, int num) {
        super(name, num);
    }

    public void Process() {

        if (!jailed) {
            target = validTownTarget(-1); // Pick anything
            if (target != playerNum) {
                nightAction = "You have decided to protect " + String.valueOf(target) +
                        "(" + players.get(target).roleName + ") tonight.";
            } else {
                nightAction = "You have decided to use a vest this night.";
            }
            target = checkTargetSwitch(target);
            // If dead to Veteran, he does not protect him
            if (!blocked) {
                players.get(target).visits.add(playerNum);
                if (!checkVetVisit(target)) {
                    if (target == playerNum) {
                        immune = true;
                    } else {
                        players.get(target).subscribeBG(playerNum);
                    }
                }
            }
        }

    }

}
