package validator;

import java.util.ArrayList;

public class ListScanner {

    private MainValidator central;

    public ListScanner(MainValidator source) {
        central = source;
    }

    public ArrayList<String> scan() {

        ArrayList<String> uniqueInfractions = new ArrayList<String>();
        central.vampPresent = central.roles.contains("Vampire");
        central.vampHunterPresent = central.roles.contains("Vampire Hunter");
        return uniqueInfractions;

    }

}
