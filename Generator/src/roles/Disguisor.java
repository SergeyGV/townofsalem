package roles;

public class Disguisor extends RoleControl {

    public Disguisor(String name, int num) {
        super(name, num);
    }

    public void Process() {

        if (!jailed) {
            /*
             * I try to simulate the best course of action when it comes to roles
             * Nothing advanced, but nothing that is questionable
             * That said, the existence of the Disguisor is the definition of questionable
             * For the sake of the program, he will visit if a Forger or a Janitor is visiting
             * And that is the ONLY time a Disguisor can ever accomplish his job properly
             * Outside of the town being blind as a bat that is
             * And even then, he would get severe flak from his team for this action
             */
            if (visitingMD == 0 || visitingDisg != playerNum) {
                nightAction = "You have decided to do nothing this night.";
                target = 0;
            } else {
                nightAction = "You have decided to disguise as " + String.valueOf(mafTarget) + "(" +
                        players.get(mafTarget).roleName + ") tonight.";
                target = mafTarget;
            }
            target = checkTargetSwitch(target);
            if (target == 0) {
                nightResult = "You did not perform your night ability.";
            } else if (!blocked && !checkVetVisit(target)) {
                // Oh you poor sod... hope the town has the attention span of a rock
                if (players.get(target).disguised) {
                    activity.add("DisgTaken");
                } else {
                    players.get(target).disguised = true;
                }
            }
        }

    }

}
