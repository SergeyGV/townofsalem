package generation;

public class VampireModifier {

    public static void modify(Generator gen) {

        int i;
        if (gen.roleList.contains("Vampire")) {
            AddVampire("hello, is it me you're looking for?", gen, false);
            return;
        }
        if (gen.roleList.contains("Random Neutral")) {
            i = gen.roleList.indexOf("Random Neutral");
            while (i != gen.roleList.size() && gen.roleList.get(i).equals("Random Neutral")) {
                if (gen.randomizer.nextInt(gen.storage.getNeutralSize()+1) == gen.storage.getNeutralSize()) {
                    AddVampire("Random Neutral", gen, true);
                    return;
                }
                i++;
            }
        }
        if (gen.roleList.contains("Any")) {
            i = gen.roleList.indexOf("Any");
            while (i != gen.roleList.size() && gen.roleList.get(i).equals("Any")) {
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
            gen.roleList.remove(text);
            gen.roleList.add("Vampire");
        }
        gen.VampPresent = true;
        gen.storage.TK.add(gen.storage.TK.size(), "Vampire Hunter");

    }

}
