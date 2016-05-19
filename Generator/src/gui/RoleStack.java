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
    public String LabelPic = "/home/sergey/workspace/townofsalem/Generator/pictures/RoleStackBG.png";
    private int currentLabel; // Tracker for which element in the stack we are on
    private int fontSize = 20;
    private int initx = 750; // X coordinate of the stack of boxes
    private int inity = 28; // Y coordinate of the corner of the top left box
    private int boxlength = 200; // Length of each box
    private int boxwidth = 30; // Height of each box

    public RoleStack(Panel target) {

        currentLabel = 0;
        mainFont = new Font(chosenFont, Font.PLAIN, fontSize);
        roleList = new ArrayList<>();
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
            roleList.get(currentLabel).setVisible(true);
            currentLabel++;
        }

    }

    /**xA
     * Removes the top role on the current panel
     */
    public void popRole() {

        if (currentLabel != 0) {
            currentLabel--;
            roleList.get(currentLabel).setVisible(false);
            roleList.get(currentLabel).setText(null);
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

    class RoleDisplay extends Label {

        Image background;
        public RoleDisplay() {
            try {
                background = ImageIO.read(new File(LabelPic));
            } catch (Exception e) {
                System.out.println("Couldn't add the background");
            }
        }

        public void paint(Graphics g) {
            g.drawImage(background, 0, 0, null);
        }

    }

}
