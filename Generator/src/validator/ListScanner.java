package validator;

import java.util.ArrayList;
import java.util.jar.Pack200;

public class ListScanner {

    private MainValidator central;

    public ListScanner(MainValidator source) {
        central = source;
    }

    public ArrayList<String> scan() {

        ArrayList<String> uniqueInfractions = new ArrayList<String>();
        central.vampPresent = central.roles.contains("Vampire");
        central.vampHunterPresent = central.roles.contains("Vampire Hunter");
        for (String role: central.roles) {
            if (central.storage.findFaction(role).equals("Mafia")) {

            }
        }
        return uniqueInfractions;

    }

}
