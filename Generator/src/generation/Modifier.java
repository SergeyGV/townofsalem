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
                while (gen.roleList.contains("Mafia Killing")) {
                    gen.roleList.remove("Mafia Killing");
                    gen.roleList.add(gen.storage.MK.get(gen.randomizer.nextInt(gen.storage.MK.size())));
                }
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
            AddVampire("hello, is it me you're looking for?", gen, false);
            return;
        }
        if (gen.GeneralRoles.contains("Random Neutral")) {
            i = gen.GeneralRoles.indexOf("Random Neutral");
            while (i != gen.GeneralRoles.size() && gen.GeneralRoles.get(i).equals("Random Neutral") ) {
                if (gen.randomizer.nextInt(gen.storage.getNeutralSize()+1) == gen.storage.getNeutralSize()) {
                    AddVampire("Random Neutral", gen, true);
                    return;
                }
                i++;
            }
        }
        if (gen.GeneralRoles.contains("Any")) {
            i = gen.GeneralRoles.indexOf("Any");
            while (i != gen.GeneralRoles.size() && gen.GeneralRoles.get(i).equals("Any") ) {
                System.out.println("Iteration");
                if (gen.randomizer.nextInt(gen.storage.getAllSize() + 1) == gen.storage.getAllSize()) {
                    AddVampire("Any", gen, true);
                    return;
                }
                i++;
            }
        }

    }

    private static void AddVampire(String text, Generator gen, boolean Remove) {

        if (Remove) {
            gen.GeneralRoles.remove(text);
            gen.FinalList.add("Vampire");
        }
        gen.VampPresent = true;
        gen.storage.TK.add(gen.storage.TK.size(), "Vampire Hunter");

    }

}
