package display;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * CategoryListener - Handles the category selection buttons
 */

public class CategoryListener implements MouseListener {

    public static RoleSelect categorySorter;
    private String action;
    private JButton listener;
    private static JButton activeButton;


    public CategoryListener(String category, JButton button) {
        action = category;
        listener = button;
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
        if (activeButton != null) {
            activeButton.setBackground(Color.LIGHT_GRAY);
        }
        activeButton = listener;
        listener.setBackground(Color.CYAN);
        categorySorter.updateRoleList(action);
    }

}
