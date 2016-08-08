package generation;

import java.util.ArrayList;
import java.util.Random;

public class MafiaModifier {

    public static void modify(ArrayList<String> roleList, String toDo, RoleStorage storage) {

        if (toDo.equals("Replace RM with MK")) {
            roleList.remove("Random Mafia");
            addRole(roleList, storage);

        }
        while (roleList.contains("Mafia Killing")) {
            roleList.remove("Mafia Killing");
            addRole(roleList, storage);
        }

    }

    private static void addRole(ArrayList<String> roleList, RoleStorage storage) {

        ArrayList<String> MafKill = storage.director.get("Mafia Killing");
        String chosenRole = MafKill.get(new Random().nextInt(MafKill.size()));
        roleList.add(chosenRole);
        MafKill.remove(chosenRole);

    }

}
