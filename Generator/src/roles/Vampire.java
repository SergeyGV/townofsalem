package roles;

public class Vampire extends RoleControl {

    public Vampire(String name, int num) {
        super(name, num);
    }

    public void Process() { /*

        player = Players.get(Vampire);
        if (!player.jailed) {
            target = validTownTarget(Vampire);
            player.NightAction = "You have voted to bite " + String.valueOf(target) + "(" +
                    Players.get(target).name + ") tonight.";
            target = checkTargetSwitch(target);
            if (!player.blocked) {
                AllVisits.get(target).add(Vampire);
                if (RoleInfo.BiteImmune.contains(Players.get(target).name)) {
                    player.activity.add("NightImmune");
                    if (Players.get(target).name.equals("Vampire Hunter")) {
                        Players.get(target).activity.add("VHStake");
                        if (DocSubs.size() != 0) {
                            notifyDoctors();
                            player.activity.add("DocSave");
                        } else {
                            player.attackers.add("VHVisit");
                        }
                    }
                } else {
                    Players.get(target).bitten = true;
                }
            }
        } */

    }

}
