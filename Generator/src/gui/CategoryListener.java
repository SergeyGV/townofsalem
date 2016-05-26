package gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * CategoryListener - Handles the category selection buttons
 */

public class CategoryListener implements MouseListener {

    public static RoleSelect categorySorter;
    private String action;

    public CategoryListener(String category) {
        action = category;
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
        categorySorter.showNewPanel(action);
    }

}
