package generation;

import java.util.ArrayList;

public class FactionModifier {

    public static void modify(Generator gen) {

        ArrayList<String> factions = gen.validator.getFactions();
        int toGen;
        if (factions.size() < 2) {
            if (factions.size() == 1) {
                toGen = 1;
            } else {
                toGen = 2;
            }
            for (int i = 0; i < toGen; i++) {
                
            }
        }

    }

}
