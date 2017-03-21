package printer;

import roles.RoleControl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

public class ActivityPrint {

    public static ArrayList<String> getActivity(HashMap<Integer, RoleControl> PlayerData) {

        ArrayList<String> nightResults = new ArrayList<>();

        RoleControl player;
        for (int i = 1; i < PlayerData.size() + 1; i++) {
            player = PlayerData.get(i);
            if (player.roleName.equals("Veteran")) {
                vetSort(player);
            }
            nightResults.add(String.valueOf(i) + "(" + player.roleName + ")");
            // Night action printing
            if (!player.nightAction.equals("")) {
                nightResults.add(player.nightAction);
            }
            // Night result printing
            if (!player.nightResult.equals("")) {
                nightResults.add(player.nightResult);
            }
            for (String action: player.activity) {
                switch(action) {
                    case "Transported":
                        nightResults.add("You were transported to another location");
                        break;
                    case "VetShot":
                        nightResults.add("You shot someone who visited you last night!");
                        break;
                    case "VetAtt":
                        nightResults.add("Someone tried to attack you but you cannot be killed while on alert!");
                        break;
                    case "Witched":
                        nightResults.add("You felt a mystical power dominating you. You were controlled by a witch!");
                        break;
                    case "WitchJail":
                        nightResults.add("Someone tried to control you but you were in jail!");
                        break;
                    case "WitchImmune":
                        nightResults.add("Someone tried to control you but you are immune!");
                        break;
                    case "RBImmune":
                        nightResults.add("Someone tried to roleblock you but you are immune!");
                        break;
                    case "RBJail":
                        nightResults.add("Someone tried to roleblock you but you were in jail!");
                        break;
                    case "RB":
                        nightResults.add("Someone occupied your night. You were roleblocked!");
                        break;
                    case "SKBlock":
                        nightResults.add("Someone roleblocked you, so you attacked them!");
                        break;
                    case "SKJail":
                        nightResults.add("You attacked the jailor!");
                        break;
                    case "BMJail":
                        nightResults.add("Someone tried to blackmail you but you were in jail!");
                        break;
                    case "BM":
                        nightResults.add("Someone threatened to reveal your secrets. You are blackmailed!");
                        break;
                    case "DocSave":
                        nightResults.add("You were attacked but someone nursed you back to health!");
                        break;
                    case "DocAtt":
                        nightResults.add("Your target was attacked!");
                        break;
                    case "DocvsBG":
                        nightResults.add("You were attacked by a Bodyguard but someone nursed you back to health!");
                        break;
                    case "BGSave":
                        nightResults.add("You were attacked but someone fended off your attacker!");
                        break;
                    case "VestSave":
                        nightResults.add("You were attacked but your bulletproof vest saved you!");
                        break;
                    case "JailSave":
                        nightResults.add("Someone tried to attack you but you were in jail!");
                        break;
                    case "ImmuneSave":
                        nightResults.add("You were attacked but you are immune at night!");
                        break;
                    case "NightImmune":
                        nightResults.add("Your target was immune!");
                        break;
                    case "VHStake":
                        nightResults.add("You were visited by a Vampire, so you staked him!");
                        break;
                    case "DousedJail":
                        nightResults.add("Someone tried to douse you but you were in jail!");
                        break;
                    case "BGArsoSave":
                        nightResults.add("Someone tried to douse you but a Bodyguard fended them off!");
                        break;
                    case "Doused":
                        nightResults.add("(Secret) You were doused in gas!");
                        break;
                    case "SpyVisits":
                        for (int Visit: RoleControl.mafVisits) {
                            nightResults.add("A member of the mafia had visited " +
                                    String.valueOf(Visit) + "(" + player.getPlayerName(Visit) + ") last night!");
                        }
                        break;
                    case "LKVisits":
                        for (int Visit: player.getLookoutVisits()) {
                            // If witched, print all. Else, only print if the visit is not himself
                            if (player.witched != 0 || i != Visit) {
                                nightResults.add("Player " + String.valueOf(Visit) + "(" +
                                        player.getPlayerName(Visit) + ") visited your target last night!");
                            }
                        }
                        break;
                    case "VampJail":
                        nightResults.add("The youngest Vampire was jailed, no one can be bit tonight!");
                        break;
                    case "VampSize":
                        nightResults.add("The Vampires have reached their size limit, no one can be bit!");
                        break;
                    default:
                        nightResults.add("You shouldn't be here. Offender:" + action);
                        break;
                }
            }
            if (player.attackers.size() != 0) {
                for (String attack: player.attackers) {
                    switch (attack) {
                        case "Veteran":
                            nightResults.add("You were shot by the Veteran you visited!");
                            break;
                        case "Vigilante":
                            nightResults.add("You were shot by a Vigilante!");
                            break;
                        case "Vampire Hunter":
                            nightResults.add("You were staked by a Vampire Hunter!");
                            break;
                        case "VHVisit":
                            nightResults.add("You were staked by the Vampire Hunter you visited!");
                            break;
                        case "SKVisit":
                            nightResults.add("You were stabbed by the Serial Killer you visited!");
                            break;
                        case "JailedSK":
                            nightResults.add("You were attacked by the Serial Killer you jailed!");
                            break;
                        case "Mafia":
                            nightResults.add("You were attacked by a member of the Mafia!");
                            break;
                        case "Serial Killer":
                            nightResults.add("You were stabbed by a Serial Killer!");
                            break;
                        case "Bodyguard":
                            nightResults.add("You were killed by a BodyGuard!");
                            break;
                        case "BGAttack":
                            nightResults.add("You were killed protecting your target!");
                            break;
                        case "Vampire":
                            nightResults.add("You were attacked by a Vampire!");
                            break;
                        case "Arsonist":
                            nightResults.add("You were incinerated by an Arsonist!");
                            break;
                        default:
                            nightResults.add("You shouldn't be here. Offender:" + attack);
                            break;
                    }
                }
                nightResults.add("You have died!");
                if (player.forged) {
                    nightResults.add("Someone forged your will!");
                }
                if (player.cleaned) {
                    nightResults.add("You were cleaned by a janitor!");
                }
            } else {
                if (player.bitten) {
                    nightResults.add("You were bit by a Vampire!");
                }
            }
        }

        return nightResults;

    }

    /**
     * Run through and sort the Vet messages
     * Namely, place attackers getting shot notifications first.
     * Then, place normal people that got shot after.
     * @param veteran The RoleControl class of the Veteran
     */
    private static void vetSort(RoleControl veteran) {
        Stack<String> toMove = new Stack<>();
        Iterator<String> vetAct;
        String event;
        for (vetAct = veteran.activity.iterator(); vetAct.hasNext();) {
            event = vetAct.next();
            if (event.equals("VetShot")) {
                toMove.push(event);
                vetAct.remove();
            } else if (event.equals("VetAtt")) {
                // Modify stack directly and put VetAtt at the back
                toMove.add(0, event);
                vetAct.remove();
            }
        }
        while (!toMove.empty()) {
            veteran.activity.add(0, toMove.pop());
        }
    }

}
