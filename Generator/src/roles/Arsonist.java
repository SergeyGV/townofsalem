package roles;

public class Arsonist extends RoleControl {

    public Arsonist(String name, int num) {
        super(name, num);
    }

    public void Process() {

        /*

        player = Players.get(Arsonist);
        if (!player.jailed) {
            target = validTownTarget(Arsonist);
            player.NightAction = "You have decided to douse " + String.valueOf(target) + "(" +
                    Players.get(target).name + ") tonight.";
            target = checkTargetSwitch(target);
            if (!player.blocked) {
                if (Players.get(target).jailed) {
                    Players.get(target).activity.add("DousedJail");
                } else if (PlayerData.get(target).BGSubs.size() != 0) {
                    PlayerData.get(target).notifyBG();
                    Players.get(target).activity.add("BGArsoSave");
                    if (DocSubs.size() != 0) {
                        notifyDoctors();
                        player.activity.add("DocvsBG");
                    } else {
                        player.attackers.add("Bodyguard");
                    }
                } else {
                    Players.get(target).activity.add("Doused");
                    checkLateVetVisit(target);
                }
                AllVisits.get(target).add(Arsonist);
            }
        }

        */

    }

}
