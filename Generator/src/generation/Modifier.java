package generation;

public class Modifier {

    /**
     * Given a generator, will go across the raw role list, detect if it is a
     * role list with the Mafia, and will modify it(if needed) to be a valid mafia role list
     *
     * A valid role list that contains the mafia is one that contains either
     * the Mafioso or the Godfather role.
     *
     * @param gen A generator with a raw role list
     */
    public static void MafiaChecker(Generator gen) {

        if (!gen.roleList.contains("Mafioso") && !gen.roleList.contains("Godfather")) {
            if (gen.roleList.contains("Mafia Killing")) {
                gen.roleList.remove("Mafia Killing");
                gen.roleList.add(gen.storage.MK.get(gen.randomizer.nextInt(gen.storage.MK.size())));
            } else if (gen.roleList.contains("Random Mafia")) {
                gen.roleList.remove("Random Mafia");
                gen.roleList.add(gen.storage.MK.get(gen.randomizer.nextInt(gen.storage.MK.size())));
            }
            /* If both if statements fail, then it is assumed NO MAFIA are present
             * as per the validator */
        }

    }

    /**
     * Given a generator, will go along it's role list and process the vampire case.
     * If there are chances for a vampire to appear, it will roll all those chances.
     * If a chance succeeds, a vampire will replace the item from which it was
     * rolled in the role list, and the generator will be further modified to reflect
     * on it. The generator modification also happens if a vampire is already listed
     * in the role list.
     *
     * @param gen A generator with a raw role list
     */
    public static void VampireChecker(Generator gen) {

        int i = 0;
        if (gen.roleList.contains("Vampire")) {
            AddVampire(i, gen, false);
            return;
        }
        if (gen.roleList.contains("Random Neutral")) {
            i = gen.roleList.indexOf("Random Neutral");
            while (i != gen.roleList.size() && gen.roleList.get(i).equals("Random Neutral") ) {
                if (gen.randomizer.nextInt(gen.NeutralSize + 1) == gen.NeutralSize) {
                    AddVampire(i, gen, true);
                    return;
                }
                i++;
            }
        }
        if (gen.roleList.contains("Any")) {
            i = gen.roleList.indexOf("Any");
            while (i != gen.roleList.size() && gen.roleList.get(i).equals("Any") ) {
                System.out.println("Iteration");
                if (gen.randomizer.nextInt(gen.AnySize + 1) == gen.AnySize) {
                    AddVampire(i, gen, true);
                    return;
                }
                i++;
            }
        }

    }

    private static void AddVampire(int index, Generator gen, boolean Remove) {

        if (Remove) {
            gen.roleList.remove(index);
            gen.roleList.add(index, "Vampire");
        }
        gen.VampPresent = true;
        gen.TownSize++;
        gen.AnySize++;
        gen.storage.TK.add(gen.storage.TK.size(), "Vampire Hunter");

    }

}
