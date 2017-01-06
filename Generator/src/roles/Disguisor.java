package roles;

public class Disguisor extends RoleControl {

    public Disguisor(String name, int num) {
        super(name, num);
    }

    public void Process() {

        if (!jailed) {
            // Always visits, add user set odds of visiting later
            // Do disguisors visit marked targets? Assume not for now, but ask later
            target = validNonDeathMafTarget();
            nightAction = "You have decided to disguise as " + String.valueOf(target) + "(" +
                    players.get(target).roleName + ") tonight.";
            target = checkTargetSwitch(target);
            // Allow him to disguise as himself due to Witch(does nothing anyway)
            if (!blocked) {
                mafVisits.add(target);
                players.get(target).visits.add(playerNum);
                checkVetVisit(target);
                // Allow a disguise to occur even if killed that night
                // Also that's really it. For the purpose of this sim it's a plain visit
                nightResult = "You have successfully disguised yourself(as a " +
                        players.get(target).roleName + ")!";
            }

        }

    }

}
