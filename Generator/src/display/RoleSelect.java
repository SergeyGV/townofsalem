package display;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class RoleSelect {

    private ArrayList<JButton> roleButtList;
    private ArrayList<String> Town;
    private ArrayList<String> Mafia;
    private ArrayList<String> Neutral;
    private ArrayList<String> General;
    // Text that goes into the filler button. Should be bigger than every other selectable role/general role
    private String buttFillerText = "                                   ";

    public RoleSelect(JPanel origin) {

        roleButtList = new ArrayList<>();

        Town = new ArrayList<>(Arrays.asList("Investigator", "Lookout", "Sheriff", "Spy",
                "Jailor", "Vampire Hunter", "Veteran", "Vigilante", "Bodyguard", "Doctor",
                "Escort", "Medium", "Mayor", "Retributionist", "Transporter"));
        Mafia = new ArrayList<>(Arrays.asList("Godfather", "Mafioso", "Disguisor", "Forger",
                "Framer", "Janitor", "Blackmailer", "Consort", "Consigliere"));
        Neutral = new ArrayList<>(Arrays.asList("Amnesiac", "Survivor", "Vampire", "Jester",
                "Executioner", "Witch", "Arsonist", "Serial Killer", "Werewolf"));
        General = new ArrayList<>(Arrays.asList("Random Town", "Town Investigative", "Town Protective",
                "Town Killing", "Town Support", "Random Mafia", "Mafia Support", "Mafia Deception",
                "Random Neutral", "Neutral Benign", "Neutral Evil", "Neutral Killing", "Any"));

        for (int i = 0; i < 15; i++) {
            JButton roleButt = new JButton("");
            roleButt.setBackground(Color.LIGHT_GRAY);
            roleButt.addMouseListener(new AddListener(roleButt));
            roleButtList.add(roleButt);
            origin.add(roleButt);
        }

        // Filler button: Sets a consistent size for the other buttons
        JButton filler = new JButton(buttFillerText);
        filler.setVisible(false);
        origin.add(filler);

    }

    public void updateRoleList(String newCat) {
        ArrayList<String> chosen;
        if (newCat.equals("Town")) {
            chosen = Town;
        } else if (newCat.equals("Mafia")) {
            chosen = Mafia;
        } else if (newCat.equals("Neutral")) {
            chosen = Neutral;
        } else {
            chosen = General;
        }

        // Wipe the current buttons first
        for (JButton butt: roleButtList) {
            butt.setText("");
        }

        for (int i = 0; i < chosen.size(); i++) {
            roleButtList.get(i).setText(chosen.get(i));
        }

    }

}
