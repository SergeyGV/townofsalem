package generation;

import java.util.ArrayList;
import java.util.Random;

public class MafiaModifier {

    public static void modify(ArrayList<String> roleList, String toDo, RoleStorage storage) {

        if (toDo.equals("Replace RM with MK")) {
            roleList.remove("Random Mafia");
            roleList.add(storage.findCategory("Mafia Killing").get(
                    new Random().nextInt(storage.director.get("Mafia Killing").size())));
        }
        while (roleList.contains("Mafia Killing")) {
            roleList.remove("Mafia Killing");
            roleList.add(storage.findCategory("Mafia Killing").get(
                    new Random().nextInt(storage.director.get("Mafia Killing").size())));
        }

    }

}
