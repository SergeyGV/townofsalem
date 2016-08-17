package roles;

import static actions.Actions.Players;

public class Spy extends RoleControl {

    public Spy(String name, int num) {
        super(name, num);
    }

    public void Process(int Spy) { /*

        player = Players.get(Spy);
        if (!player.jailed && !player.blocked) {
            player.activity.add("SpyVisits");
        }
        */
    }

}
