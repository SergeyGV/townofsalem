package roles;

public class ArsoIgnite extends RoleControl {

    public ArsoIgnite(String name) {
        super(name);
    }

    public void Process() {
        if (ignited) {
            for (RoleControl player: players.values()) {
                if (player.activity.contains("Doused")) {
                    player.attackers.add("Arsonist");
                }
            }
        }
    }

}
