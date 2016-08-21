package roles;

public class MafiaKillers extends RoleControl {

    public MafiaKillers(String name) {
        super(name);
    }

    public void Process() {

        boolean gfBlock = true;
        boolean mfBlock = true;
        mafTarget = validMafTarget();
        for (RoleControl player: players.values()) {
            if (player.roleName.equals("Mafioso")) {
                mfBlock = player.jailed || player.blocked;
            }
            if (player.roleName.equals("Godfather")) {
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
