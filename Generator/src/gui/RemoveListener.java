package gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RemoveListener implements MouseListener {

    private RoleStack target;

    public RemoveListener(RoleStack origin) {
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
        target.popRole();
    }

}
