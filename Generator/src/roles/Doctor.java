package roles;

public class Doctor extends RoleControl {

    public Doctor(String name, int num) {
        super(name, num);
    }

    public void Process() {

        if (!jailed) {
            target = validTownTarget(-1); // Pick anything
            if (target != playerNum) {
                nightAction = "You have decided to heal " + String.valueOf(target) +
                        "(" + players.get(target).roleName + ") tonight.";
            } else {
                nightAction = "You have decided to heal yourself this night.";
            }
            target = checkTargetSwitch(target);
            if (!blocked) {
                if (target == playerNum) {
                    immune = true;
                }
                players.get(target).subscribeDoctor(playerNum);
                // Processing special cases that happened before the Doctor
                /*
                while (Players.get(target).attackers.size() != 0) {
                    n.activity.add("DocAtt");
                    Players.get(target).activity.add("DocSave");
                    Players.get(target).attackers.remove(0);
                }*/
            }
        }

    }

}
