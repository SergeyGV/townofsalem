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
                } else {
                    toReplace = "Random Neutral";
                }
                newFaction = gen.storage.getRandomFaction();
                while (factions.contains(newFaction)) {
                    newFaction = gen.storage.getRandomFaction();
                }
                factions.add(newFaction);
                if (newFaction.equals("Mafia")) {
                    newFaction = "Mafia Killing";
                } else if (newFaction.equals("Town")) {
                    newFaction = "Random Town";
                }
                System.out.println(newFaction);
                gen.roleList.remove(toReplace);
                gen.roleList.add(newFaction);
            }
        }

    }

}
