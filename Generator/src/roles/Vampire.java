package roles;

import actions.RoleInfo;

public class Vampire extends RoleControl {

    public Vampire(String name, int num) {
        super(name, num);
    }

    public void Process() {

        // Global vampire notifications
        if (vampires.size() == 4) {
            activity.add(0, "VampSize");
        } else if (players.get(visitingVamp).jailed) {
            activity.add(0, "VampJail");
        }

        if (!jailed) {
            if (playerNum == visitingVamp && vampires.size() != 4) {
                // Only one Vampire is going to be in this block
                target = validVampTarget();
                nightAction = "You'll be visiting tonight! You have voted to bite " + String.valueOf(target)
                        + "(" + players.get(target).roleName + ") tonight.";
                // Simulate activity for other vampires for voting on the target
                for (int vampire: vampires) {
                    if (!players.get(vampire).jailed && vampire != playerNum) {
                        players.get(vampire).nightAction = "You have voted to bite " + String.valueOf(target)
                                + "(" + players.get(target).roleName + ") tonight.";
                    }
                }
                target = checkTargetSwitch(target);
                players.get(target).visits.add(playerNum);
                if (!blocked) {
                    if (RoleInfo.BiteImmune.contains(players.get(target).roleName)) {
                        // Mafia targeted by Vampires is attacked by them instead of being bit by them
                        if (RoleInfo.allMafia.contains(players.get(target).roleName)) {
                            lethalAttack(target, "Vampire");
                        } else {
                            activity.add("NightImmune");
                            if (players.get(target).roleName.equals("Vampire Hunter")) {
                                players.get(target).activity.add("VHStake");
                                if (DocSubs.size() != 0) {
                                    notifyDoctors();
                                    activity.add("DocSave");
                                } else {
                                    attackers.add("VHVisit");
                                }
                            }
                        }
                    } else if (!checkVetVisit(target)) {
                        // If jailed treat it as a regular attack
                        if (players.get(target).jailed) {
                            lethalAttack(target, "Vampire");
                        } else {
                            players.get(target).bitten = true;
                        }
                    }
                }
            } else {
                // This is for if a Vampire that isn't biting happens to be witched
                target = 0;
                target = checkTargetSwitch(target);
                checkVetVisit(target);
                if (target != 0) {
                    players.get(target).visits.add(playerNum);
                }
            }
        }

    }

}
