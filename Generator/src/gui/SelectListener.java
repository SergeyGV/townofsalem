package gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SelectListener implements MouseListener {

    String roleName;

    public SelectListener(String name) {
        roleName = name;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        AddListener.selected = roleName;
    }
}
