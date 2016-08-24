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
             * For the time being, this role will being doing NOTHING unless forced
             * Or unless a Janitor/Forger is present and are heading out, but even then it's debatable
             * It seriously is that bad of a role...
             */
            nightAction = "You have decided to do nothing this night. Heck, the entire game.";
            target = checkTargetSwitch(0);
            if (target == 0) {
                nightResult = "You did not perform your night ability.";
            } else if (!blocked) {
                // Oh you poor sod... hope the town has the attention span of a rock
                players.get(target).disguised = true;
                checkVetVisit(target);
            }
        }

    }

}
