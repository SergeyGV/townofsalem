package roles;

public class ArsoIgnite extends RoleControl {

    public ArsoIgnite(String name) {
        super(name);
    }

    public void Process() {
        if (ignited) {
            for (RoleControl player: players.values()) {
                // Can't be saved by anyone at all except if they are jailed
                // However if they are jailed, they will never have the "Doused" status
                if (player.activity.contains("Doused")) {
                    player.attackers.add("Arsonist");
                }
            }
        }
    }

}
