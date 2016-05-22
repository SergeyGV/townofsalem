package gui;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

/**
 * Display - The main menu of the GUI, in charge of saying what gets
 * displayed, and when
 */
public class Display {

    private Frame mainFrame; // Overarching Frame
    private Panel mainWindow; // First menu
    private RoleStack selectedRoles;
    private int FrameLength = 700;
    private int FrameWidth = 1000;
    private String BGpath = "Generator/pictures/TOSSimBG.png";

    public Display() {

        mainFrame = new Frame("Town Of Salem Simulator");
        mainFrame.setSize(FrameWidth, FrameLength);
        mainFrame.setResizable(false);
        mainFrame.setLayout(null); // Locations will be done manually
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        mainWindow = new Window();
        mainWindow.setLayout(null);
        mainWindow.setBounds(0, 0, FrameWidth, FrameLength);
        NonRoleListener.categorySorter = new RoleSelect(mainWindow);
        new ImageMapper();
        new CategorySelect(mainWindow);
        Button AddRole = new Button("Add role");
        Button RemoveRole = new Button("Remove role");
        Button Start = new Button("Start");
        AddRole.setBounds(500, 618, 200, 60);
        RemoveRole.setBounds(750, 517, 200, 60);
        Start.setBounds(750, 618, 200, 60);
        AddRole.setActionCommand("Add");
        RemoveRole.setActionCommand("Remove");
        Start.setActionCommand("Start");
        selectedRoles = new RoleStack(mainWindow);
        AddRole.addActionListener(new RoleListener(selectedRoles));
        RemoveRole.addActionListener(new RoleListener(selectedRoles));
        Start.addActionListener(new NonRoleListener());
        mainWindow.add(AddRole);
        mainWindow.add(RemoveRole);
        mainWindow.add(Start);
        mainFrame.add(mainWindow);
        mainFrame.setVisible(true); // Should be done as the very last step

    }

    class Window extends Panel {

        Image background;
        public Window() {
            try {
                background = ImageIO.read(new File(BGpath));
            } catch (Exception e) {
                System.out.println("Couldn't add the background");
            }
        }

        public void paint(Graphics g) {
            g.drawImage(background, 0, 0, null);
        }

    }

}
