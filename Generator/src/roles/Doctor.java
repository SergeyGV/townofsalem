package roles;

import static actions.Actions.AllVisits;
import static actions.Actions.PlayerData;
import static actions.Actions.Players;

public class Doctor extends RoleControl {

    public Doctor(String name, int num) {
        super(name, num);
    }

    public void Process(int Doctor) {

        player = Players.get(Doctor);
        if (!player.jailed) {
            target = validTownTarget(-1); // Pick anything
            if (target != Doctor) {
                player.NightAction = "You have decided to heal " + String.valueOf(target) +
                        "(" + Players.get(target).name + ") tonight.";
            } else {
                player.NightAction = "You have decided to heal yourself this night.";
            }
            target = checkTargetSwitch(target);
            if (!player.blocked) {
                checkVetVisit(target);
                AllVisits.get(target).add(Doctor);
                if (target == Doctor) {
                    immune = true;
                }
                PlayerData.get(target).subscribeDoctor(Doctor);
                // Processing special cases that happened before the Doctor
                while (Players.get(target).attackers.size() != 0) {
                    player.activity.add("DocAtt");
                    Players.get(target).activity.add("DocSave");
                    Players.get(target).attackers.remove(0);
                }
            }
        }

    }

}
