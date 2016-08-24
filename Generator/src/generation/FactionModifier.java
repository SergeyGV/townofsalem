package generation;

import java.util.ArrayList;

public class FactionModifier {

    public static void modify(Generator gen) {

        ArrayList<String> factions = gen.validator.getFactions();
        int toGen;
        String toReplace;
        String newFaction;
        if (factions.size() < 2) {
            if (factions.size() == 1) {
                toGen = 1;
            } else {
                toGen = 2;
            }
            for (int i = 0; i < toGen; i++) {
                if (gen.roleList.contains("Any")) {
                    toReplace = "Any";
                    newFaction = gen.storage.getRandomFaction(gen.roleList);
                    while (factions.contains(newFaction)) {
                        newFaction = gen.storage.getRandomFaction(gen.roleList);
                    }
                } else if (gen.roleList.contains("Neutral Killing")) {
                    toReplace = "Neutral Killing";
                    newFaction = gen.storage.getRandomFaction(gen.roleList);
                    // Logic: Belongs to the faction list OR is NOT a Neutral Killing
                    while (factions.contains(newFaction) ||
                            !gen.storage.doesBelongGeneralCategory("Neutral Killing", newFaction)) {
                        newFaction = gen.storage.getRandomFaction(gen.roleList);
                    }
                } else {
                    toReplace = "Random Neutral";
                    newFaction = gen.storage.getRandomFaction(gen.roleList);
                    // Logic: Belongs to the faction list OR (is NOT a Vampire AND is NOT a Neutral Killing)
                    while (factions.contains(newFaction) || (!newFaction.equals("Vampire")
                            && !gen.storage.doesBelongGeneralCategory("Neutral Killing", newFaction))) {
                        newFaction = gen.storage.getRandomFaction(gen.roleList);
                    }
                }
                factions.add(newFaction);
                if (newFaction.equals("Mafia")) {
                    newFaction = "Mafia Killing";
                } else if (newFaction.equals("Town")) {
                    newFaction = "Random Town";
                }
                gen.roleList.remove(toReplace);
                gen.roleList.add(newFaction);
            }
        }

    }

}
