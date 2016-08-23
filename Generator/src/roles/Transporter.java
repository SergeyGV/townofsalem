package roles;

public class Transporter extends RoleControl {

    public Transporter(String name, int num) {
        super(name, num);
    }

    public void Process() {

        if (!jailed) {
            target = validTownTarget(playerNum);
            target2 = validTownTarget(playerNum);
            nightAction = "You have decided to swap " + String.valueOf(target) + "(" +
                    players.get(target).roleName + ") with " + String.valueOf(target2) + "(" +
                    players.get(target2).roleName + ") tonight.";
            // Cannot transport if one of the targets is jailed
            if (!players.get(target).jailed && !players.get(target2).jailed) {
                // If one target has already been transported then the current transporter has no effect
                if (!switches.containsKey(target) && !switches.containsKey(target2)) {
                    switches.put(target, target2);
                    switches.put(target2, target);
                } else {
                    nightResult = "Another transporter chose your target first, so you had no effect!";
                }
                players.get(target).activity.add("Transported");
                players.get(target2).activity.add("Transported");
                checkVetVisit(target);
                if (target != target2) {
                    checkVetVisit(target2);
                }
            } else {
                nightResult = "You could not transport as one of your targets was jailed!";
            }
        }

    }


}
