package gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AddListener implements MouseListener {

    static String selected = null;
    private RoleStack target;

    public AddListener(RoleStack origin) {
        target = origin;
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
        if (selected != null) {
            target.pushRole(selected);
        }
    }

}
