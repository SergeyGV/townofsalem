package roles;

public class Jailor extends RoleControl {

    public Jailor(String name, int num) {
        super(name, num);
    }

    public void Process() {

        target = validTownTarget(playerNum);
        nightAction = "You hauled player " + String.valueOf(target) + " off to jail!";
        players.get(target).nightAction = "You were hauled off to jail!"; /*
        if (players.get(target).name.equals("Serial Killer")) {
            players.attackers.add("JailedSK");
            players.get(target).activity.add("SKJail");
        } else { */
            players.get(target).nightResult = "You did not perform any possible action due to jail.";
        //}
        players.get(target).jailed = true;
        players.get(target).blocked = true; // For mafia killing if statement simplification

    }

}
