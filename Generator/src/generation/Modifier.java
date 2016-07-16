package generation;

public class Modifier {

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
