package gui;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

/**
 * RoleStack - In charge of controlling the display for the chosen
 * roles on the GUI
 */
public class RoleStack {

    private ArrayList<Label> roleList;
    private Font mainFont;
    private String chosenFont = "Calibra";
    private Panel origin;
    private int fontSize = 20;
    private int initx = 750; // X coordinate of the stack of boxes
    private int inity = 28; // Y coordinate of the corner of the top left box
    private int boxlength = 200; // Length of each box
    private int boxwidth = 30; // Height of each box

    public RoleStack(Panel target) {

        mainFont = new Font(chosenFont, Font.PLAIN, fontSize);
        roleList = new ArrayList<>();
        origin = target;
        /*
        Label role;
        for (int i = 0; i < 15; i++) {
            role = new RoleDisplay();
            role.setAlignment(Label.LEFT);
            role.setFont(mainFont);
            role.setBounds(initx, inity + boxwidth*i, boxlength, boxwidth);
            role.setVisible(false);
            roleList.add(role);
            target.add(role);
        }
        */

    }

    /**
     * "Pushes" a new role to the top of the displayed stack, as long as the
     * size limit hasn't been exceeded
     *
     * @param role The role that is desired to be added
     */
    public void pushRole(String role) {

        if (roleList.size() < 15) {
            Label newRole = new RoleDisplay(role);
            newRole.setText(role);
            newRole.setBounds(initx, inity + roleList.size()*boxwidth, boxlength, boxwidth);
            roleList.add(newRole);
            origin.add(newRole);
        }

    }

    /**
     * Removes the top role on the current panel
     */
    public void popRole() {

        if (roleList.size() != 0) {
            origin.remove(roleList.remove(roleList.size() - 1));
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
        for (int i = 0; i < roleList.size(); i++) {
            result.add(roleList.get(i).getText());
        }
        return (result);

    }

    class RoleDisplay extends Label {

        Image background;
        public RoleDisplay(String role) {
            try {
                background = ImageMapper.roleImages.get(role);
            } catch (Exception e) {
                System.out.println("Couldn't add the background");
            }
        }

        public void paint(Graphics g) {
            g.drawImage(background, 0, 0, null);
        }

    }

}
