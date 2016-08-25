package roles;

public class MafiaKillers extends RoleControl {

    public MafiaKillers(String name) {
        super(name);
    }

    public void Process() {

        mafTarget = validMafTarget();
        finMafTarget = 0;
        for (RoleControl player: players.values()) {
            if (player.roleName.equals("Mafioso")) {
                mfBlock = player.jailed || player.blocked;
                if (!player.jailed) {
                    mkJailed = false;
                }
            }
            if (player.roleName.equals("Godfather")) {
                gfBlock = player.jailed || player.blocked;
                if (!player.jailed) {
                    mkJailed = false;
                }
            }
        }
        if (!mfBlock) {
            mafKiller = "Mafioso";
        } else if (!gfBlock) {
            mafKiller = "Godfather";
        }

    }

}
