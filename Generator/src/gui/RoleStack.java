package gui;

import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

/**
 * RoleStack - In charge of controlling the display for the chosen
 * roles on the GUI
 */
public class RoleStack {

    private Stack dataStack = new Stack();
    private Panel rolePanel;
    private Font mainFont;
    private String chosenFont = "Calibra";
    private int fontSize = 20;
    private int initx = 30;
    private int inity = 30;
    private int boxlength = 200;
    private int boxwidth = 30;

    public RoleStack() {

        rolePanel = new Panel();
        rolePanel.setLayout(null);
        rolePanel.setBounds(initx, inity, 1000, 1000);
        mainFont = new Font(chosenFont, Font.PLAIN, fontSize);
        Label chosenRole;
        for (int i = 0; i < 15; i++) {
            chosenRole = new Label();
            chosenRole.setAlignment(Label.LEFT);
            chosenRole.setText("Town Investigative");
            chosenRole.setFont(mainFont);
            chosenRole.setBounds(initx, inity + boxwidth*i, boxlength, boxwidth);
            rolePanel.add(chosenRole);
        }

    }

    /**
     * Returns the Panel used by this instance of the RoleStack class
     * @return The panel worked upon by this class
     */
    public Panel returnPanel() {
        return (rolePanel);
    }

}
