package roles;

public class MafiaKillers extends RoleControl {

    public MafiaKillers(String name) {
        super(name);
    }

    public void Process() {

        boolean gfBlock = true;
        boolean mfBlock = true;
        mafTarget = validMafTarget();
        finMafTarget = 0;
        for (RoleControl player: players.values()) {
            if (player.roleName.equals("Mafioso")) {
                mfBlock = player.jailed || player.blocked;
            }
            if (player.roleName.equals("Godfather")) {
                gfControl = player.jailed;
                gfBlock = player.jailed || player.blocked;
            }
        }
        if (!mfBlock) {
            mafKiller = "Mafioso";
        } else if (!gfBlock) {
            mafKiller = "Godfather";
        }

    }

}
