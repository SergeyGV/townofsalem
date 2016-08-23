package roles;

public class Jailor extends RoleControl {

    public Jailor(String name, int num) {
        super(name, num);
    }

    public void Process() {

        target = validTownTarget(playerNum);
        nightAction = "You hauled player " + String.valueOf(target) + " off to jail!";
        players.get(target).nightAction = "You were hauled off to jail!";
        if (players.get(target).roleName.equals("Serial Killer")) {
            players.get(target).activity.add("SKJail");
            attackers.add("JailedSK"); // Can be saved by Doc, situation handled in the Doctor class
        } else {
            players.get(target).nightResult = "You did not perform any possible action due to jail.";
        }
        players.get(target).jailed = true;

    }

}
