package gui;

import java.awt.*;
import java.util.ArrayList;

/**
 * RoleStack - In charge of controlling the display for the chosen
 * roles on the GUI
 */
public class RoleStack {

    private ArrayList<Label> roleList;
    private Panel rolePanel;
    private Font mainFont;
    private String chosenFont = "Calibra";
    private int currentLabel; // Tracker for which element in the stack we are on
    private int fontSize = 20;
    private int initx = 60; // X coordinate of the stack of boxes
    private int inity = 60; // Y coordinate of the corner of the top left box
    private int boxlength = 200; // Length of each box
    private int boxwidth = 30; // Height of each box

    public RoleStack() {

        currentLabel = 0;
        rolePanel = new Panel();
        rolePanel.setLayout(null);
        rolePanel.setBounds(initx, inity, boxlength, boxwidth*15);
        mainFont = new Font(chosenFont, Font.PLAIN, fontSize);
        roleList = new ArrayList<>();
        Label role;
        for (int i = 0; i < 15; i++) {
            role = new Label("");
            role.setAlignment(Label.LEFT);
            role.setFont(mainFont);
            role.setBounds(0, boxwidth*i, boxlength, boxwidth);
            roleList.add(role);
            rolePanel.add(role);
        }

    }

    /**
     * "Pushes" a new role to the top of the displayed stack, as long as the
     * size limit hasn't been exceeded
     *
     * @param role The role that is desired to be added
     */
    public void pushRole(String role) {

        if (currentLabel < 15) {
            roleList.get(currentLabel).setText(role);
            currentLabel++;
        }

    }

    /**
     * Removes the top role on the current panel
     */
    public void popRole() {

        if (currentLabel != 0) {
            currentLabel--;
            roleList.get(currentLabel).setText("");
        }

    }

    /**
     * Returns the entire role list that is in the displayed stack, formatted
     * for processing and generating the role list.
     *
     * @return The role list
     */
    public ArrayList<String> returnRoleList() {

        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < currentLabel; i++) {
            result.add(roleList.get(i).getText());
        }
        return (result);

    }

    /**
     * Returns the Panel used by this instance of the RoleStack class
     *
     * @return The panel worked upon by this class
     */
    public Panel returnPanel() {
        return (rolePanel);
    }

}
