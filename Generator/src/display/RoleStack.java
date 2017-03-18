package display;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RoleStack {

    private ArrayList<JLabel> roles;
    private int currentBox = 0;
    // Filler text to ensure fitting label size
    private String buttFillerText = "             filler                      ";

    public RoleStack(JPanel origin) {

        roles = new ArrayList<>();

        JLabel filler = new JLabel(buttFillerText);
        filler.setVisible(false);
        origin.add(filler);

        for (int i = 0; i < 15; i++) {
            JLabel roleBox = new JLabel(" ");
            roleBox.setBackground(Color.LIGHT_GRAY);
            roleBox.setFont(new Font(roleBox.getFont().getFontName(), Font.PLAIN, 14));
            roleBox.setOpaque(true);
            origin.add(roleBox);
            roles.add(roleBox);
        }

    }

    public void pushRole(String newRole) {
        if (currentBox < 15) {
            roles.get(currentBox).setText(newRole);
            currentBox++;
        }
    }

    public void popRole() {
        if (currentBox != 0) {
            currentBox--;
            roles.get(currentBox).setText(" ");
        }
    }

}
