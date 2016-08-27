package roles;

public class Arsonist extends RoleControl {

    public Arsonist(String name, int num) {
        super(name, num);
    }

    public void Process() {

        if (!jailed) {
            // Select any target
            target = validTownTarget(0);
            if (target != playerNum) {
                nightAction = "You have decided to douse " + String.valueOf(target) + "(" +
                        players.get(target).roleName + ") tonight.";
            } else {
                nightAction = "You have decided to ignite all doused targets.";
            }
            target = checkTargetSwitch(target);
            if (!blocked) {
                // If the target is someone else, douse them. Else, ignite.
                if (target != playerNum) {
                    checkVetVisit(target);
                    if (players.get(target).jailed) {
                        players.get(target).activity.add("DousedJail");
                    } else if (players.get(target).BGSubs.size() != 0) {
                        // BG can save from a douse attempt, but Doctors cannot. Hence special code
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
                } else {
                    ignited = true;
                }
            }
        }

    }

}
