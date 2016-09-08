package roles;

public class Janitor extends RoleControl {

    public Janitor(String name, int num) {
        super(name, num);
    }

    public void Process() {

        if (!jailed) {
            // If 0, all present MKs are visibly blocked, and there is no point in doing anything
            if (mkJailed || visitingMD != playerNum) {
                nightAction = "You have decided to do nothing this night.";
                target = 0;
            } else {
                nightAction = "You have decided to clean " + String.valueOf(mafTarget) + "(" +
                        players.get(mafTarget).roleName + ") tonight.";
                target = mafTarget;
            }
            target = checkTargetSwitch(target);
            // Only have target == 0 be a do nothing case, the witched if is only for the message
            if (target == 0) {
                if (witched == 0) {
                    nightResult = "You did not perform your night ability.";
                }
            } else if (!blocked) {
                players.get(target).cleaned = true;
                checkVetVisit(target);
                mafVisits.add(target);
                players.get(target).visits.add(playerNum);
            }
        }

    }

}
