package printer;

import roles.RoleControl;

import java.util.HashMap;

public class ActivityPrint {

    public ActivityPrint(HashMap<Integer, RoleControl> PlayerData) {

        RoleControl player;
        for (int i = 1; i < PlayerData.size() + 1; i++) {
            player = PlayerData.get(i);
            System.out.println(String.valueOf(i) + "(" + player.roleName + ")");
            // Night action printing
            if (!player.nightAction.equals("")) {
                System.out.println(player.nightAction);
            }
            // Night result printing
            if (!player.nightResult.equals("")) {
                System.out.println(player.nightResult);
            }
            for (String action: player.activity) {
                switch(action) {
                    case "Transported":
                        System.out.println("You were transported to another location");
                        break;
                    case "VetShot":
                        System.out.println("You shot someone who visited you last night!");
                        break;
                    case "VetAtt":
                        System.out.println("Someone tried to attack you but you cannot be killed while on alert!");
                        break;
                    case "Witched":
                        System.out.println("You felt a mystical power dominating you. You were controlled by a witch!");
                        break;
                    case "WitchJail":
                        System.out.println("Someone tried to control you but you were in jail!");
                        break;
                    case "WitchImmune":
                        System.out.println("Someone tried to control you but you are immune!");
                        break;
                    case "RBImmune":
                        System.out.println("Someone tried to roleblock you but you are immune!");
                        break;
                    case "RBJail":
                        System.out.println("Someone tried to roleblock you but you were in jail!");
                        break;
                    case "RB":
                        System.out.println("Someone occupied your night. You were roleblocked!");
                        break;
                    case "SKBlock":
                        System.out.println("Someone roleblocked you, so you attacked them!");
                        break;
                    case "SKJail":
                        System.out.println("You attacked the jailor!");
                        break;
                    case "BMJail":
                        System.out.println("Someone tried to blackmail you but you were in jail!");
                        break;
                    case "BM":
                        System.out.println("Someone threatened to reveal your secrets. You are blackmailed!");
                        break;
                    case "DocSave":
                        System.out.println("You were attacked but someone nursed you back to health!");
                        break;
                    case "DocAtt":
                        System.out.println("Your target was attacked!");
                        break;
                    case "DocvsBG":
                        System.out.println("You were attacked by a Bodyguard but someone nursed you back to health!");
                        break;
                    case "BGSave":
                        System.out.println("You were attacked but someone fended off your attacker!");
                        break;
                    case "VestSave":
                        System.out.println("You were attacked but your bulletproof vest saved you!");
                        break;
                    case "JailSave":
                        System.out.println("Someone tried to attack you but you were in jail!");
                        break;
                    case "ImmuneSave":
                        System.out.println("You were attacked but you are immune at night!");
                        break;
                    case "NightImmune":
                        System.out.println("Your target was immune!");
                        break;
                    case "VHStake":
                        System.out.println("You were visited by a Vampire, so you staked him!");
                        break;
                    case "DousedJail":
                        System.out.println("Someone tried to douse you but you were in jail!");
                        break;
                    case "BGArsoSave":
                        System.out.println("Someone tried to douse you but a Bodyguard fended them off!");
                        break;
                    case "Doused":
                        System.out.println("You were doused in gas!");
                        break;
                    case "SpyVisits":
                        for (int Visit: RoleControl.mafVisits) {
                            System.out.println("A member of the mafia had visited " +
                                    String.valueOf(Visit) + "(" + player.getPlayerName(Visit) + ") last night!");
                        }
                        break;
                    case "LKVisits":
                        for (int Visit: player.getLookoutVisits()) {
                            System.out.println("Player " + String.valueOf(Visit) + "(" +
                                    player.getPlayerName(Visit) + ") visited your target last night!");
                        }
                        break;
                    case "VampJail":
                        System.out.println("The youngest Vampire was jailed, no one can be bit tonight!");
                        break;
                    case "VampSize":
                        System.out.println("The Vampires have reached their size limit, no one can be bit!");
                        break;
                    default:
                        System.out.println("You shouldn't be here. Offender:" + action);
                        break;
                }
            }
            if (player.attackers.size() != 0) {
                for (String attack: player.attackers) {
                    switch (attack) {
                        case "Veteran":
                            System.out.println("You were shot by the Veteran you visited!");
                            break;
                        case "Vigilante":
                            System.out.println("You were shot by a Vigilante!");
                            break;
                        case "Vampire Hunter":
                            System.out.println("You were staked by a Vampire Hunter!");
                            break;
                        case "VHVisit":
                            System.out.println("You were staked by the Vampire Hunter you visited!");
                            break;
                        case "SKVisit":
                            System.out.println("You were stabbed by the Serial Killer you visited!");
                            break;
                        case "JailedSK":
                            System.out.println("You were attacked by the Serial Killer you jailed!");
                            break;
                        case "Mafia":
                            System.out.println("You were attacked by a member of the Mafia!");
                            break;
                        case "Serial Killer":
                            System.out.println("You were stabbed by a Serial Killer!");
                            break;
                        case "Bodyguard":
                            System.out.println("You were killed by a BodyGuard!");
                            break;
                        case "BGAttack":
                            System.out.println("You were killed protecting your target!");
                            break;
                        case "Vampire":
                            System.out.println("You were attacked by a Vampire!");
                            break;
                        case "DisgTaken":
                            System.out.println("Another disguisor got to your target first, so you did nothing!");
                            break;
                        default:
                            System.out.println("You shouldn't be here. Offender:" + attack);
                            break;
                    }
                }
                System.out.println("You have died!");
                if (player.disguised) {
                    System.out.println("Someone stole your identity!");
                }
                if (player.forged) {
                    System.out.println("Someone forged your will!");
                }
                if (player.cleaned) {
                    System.out.println("You were cleaned by a janitor!");
                }
            } else {
                if (player.bitten) {
                    System.out.println("You were bit by a Vampire!");
                }
            }
        }

    }

}
