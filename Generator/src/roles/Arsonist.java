package roles;

public class Arsonist extends RoleControl {

    public Arsonist(String name, int num) {
        super(name, num);
    }

    public void Process() {

        if (!jailed) {
            target = validTownTarget(playerNum);
            nightAction = "You have decided to douse " + String.valueOf(target) + "(" +
                    players.get(target).roleName + ") tonight.";
            target = checkTargetSwitch(target);
            if (!blocked) {
                if (players.get(target).jailed) {
                    players.get(target).activity.add("DousedJail");
                } else if (players.get(target).BGSubs.size() != 0) {
                    players.get(target).notifyBG();
                    players.get(target).activity.add("BGArsoSave");
                    if (DocSubs.size() != 0) {
                        notifyDoctors();
                        activity.add("DocvsBG");
                    } else {
                        attackers.add("Bodyguard");
                    }
                } else {
                    players.get(target).activity.add("Doused");
                }
            }
        }

    }

}
