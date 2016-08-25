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
                checkVetVisit(target);
                players.get(target).visits.add(playerNum);
                if (target == playerNum) {
                    immune = true;
                }
                players.get(target).subscribeDoctor(playerNum);
                // Processing special cases that happened before the Doctor
                while (players.get(target).attackers.size() != 0) {
                    activity.add("DocAtt");
                    players.get(target).activity.add("DocSave");
                    players.get(target).attackers.remove(0);
                }
            }
        }

    }

}
