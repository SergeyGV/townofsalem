package actions;

import roles.Data;

import java.util.ArrayList;

/**
 * TierDistributor - Distributes the given players to the appropriate tiers
 * Also is responsible of labeling members of the mafia
 */

public class TierDistributor {

    public TierDistributor(ArrayList<String> players) {

        for (int i = 1; i < 16; i++) {
            switch (players.get(i-1)) {
                case "Jailor":
                    Actions.Jailor = i;
                    break;
                case "Veteran":
                    Actions.Veteran = i;
                    break;
                case "Transporter":
                    Actions.Transporters.add(i);
                    break;
                case "Witch":
                    Actions.Witches.add(i);
                    break;
                case "Consort":
                    Actions.RoleBlockers.add(i);
                    Data.Mafia.add(i);
                    break;
                case "Escort":
                    Actions.RoleBlockers.add(i);
                    break;
                case "Consigliere":
                    Actions.MafiaInvest.add(i);
                    Data.Mafia.add(i);
                    break;
                case "Framer":
                    Actions.MafiaInvest.add(i);
                    Data.Mafia.add(i);
                    break;
                case "Blackmailer":
                    Actions.MafiaInvest.add(i);
                    Data.Mafia.add(i);
                    break;
                case "Investigator":
                    Actions.TownInvest.add(i);
                    break;
                case "Sheriff":
                    Actions.TownInvest.add(i);
                    break;
                case "Doctor":
                    Actions.Protectives.add(i);
                    break;
                case "Bodyguard":
                    Actions.Protectives.add(i);
                    break;
                case "Survivor":
                    Actions.Protectives.add(i);
                    break;
                case "Mafioso":
                    Actions.Mafioso = i;
                    Data.Mafia.add(i);
                    break;
                case "Godfather":
                    Actions.Godfather = i;
                    Data.Mafia.add(i);
                    break;
                case "Vampire Hunter":
                    Actions.Attackers.add(i);
                    break;
                case "Vigilante":
                    Actions.Attackers.add(i);
                    break;
                case "Serial Killer":
                    Actions.Attackers.add(i);
                    break;
                case "Arsonist":
                    Actions.Attackers.add(i);
                    break;
                case "Vampire":
                    Actions.Attackers.add(i);
                    break;
                case "Disguisor":
                    Actions.DeadActors.add(i);
                    Data.Mafia.add(i);
                    break;
                case "Forger":
                    Actions.DeadActors.add(i);
                    Data.Mafia.add(i);
                    break;
                case "Janitor":
                    Actions.DeadActors.add(i);
                    Data.Mafia.add(i);
                    break;
                case "Spy":
                    Actions.ActivityInvest.add(i);
                    break;
                case "Lookout":
                    Actions.ActivityInvest.add(i);
                    break;
                default:
                    Actions.NoImpact.add(i);
                    break;
            }
        }

    }

}
