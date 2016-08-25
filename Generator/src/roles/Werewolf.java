package roles;

public class Werewolf extends RoleControl {

    public Werewolf(String name, int num) {
        super(name, num);
    }

    public void Process() {

        // Doesn't do anything night 1, but if controlled, that's a different story
        if (!jailed && !blocked) {
            target = 0;
            target = checkTargetSwitch(target);
            if (target != 0) {
                // Passive. Has absolutely no effect on the target, but can get shot by Vet still
                players.get(target).visits.add(playerNum);
                checkVetVisit(target);
            }
        }

    }

}
