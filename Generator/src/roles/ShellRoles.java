package roles;

import static actions.Actions.Players;

/**
 * Created by sergey on 5/5/16.
 */
public class ShellRoles extends RoleControl {

    public void Process(int Role) {

        player = Players.get(Role);

    }

}
