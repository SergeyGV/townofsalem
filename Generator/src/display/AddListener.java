package display;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AddListener implements MouseListener {

    public static RoleStack target;
    private JButton source;

    public AddListener(JButton origin) {
        source = origin;
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {
        if (!source.getText().equals("")) {
            target.pushRole(source.getText());
        }
    }

}
