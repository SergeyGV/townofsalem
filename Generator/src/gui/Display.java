package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

/**
 * Display - The main menu of the GUI, in charge of saying what gets
 * displayed, and when
 */
public class Display {

    private JFrame mainFrame; // Overarching Frame
    private JPanel controlPanel; // Controlling Panel
    private int frameLength = 700;
    private int frameWidth = 1000;
    private String BGpath = "Generator/pictures/TOSSimBG.png";

    /**
     * Launches the interface of this program
     */
    public void initDisplay() {

        // Screen set up
        mainFrame = new JFrame("Town of Salem Simulator");
        mainFrame.setLayout(null);
        mainFrame.setBounds(0, 0, frameWidth, frameLength);
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // Background set up
        controlPanel = new Window();
        controlPanel.setBounds(0, 0, frameWidth, frameLength);
        controlPanel.setVisible(true);
        mainFrame.add(controlPanel);

        // All components should already be ready to go/added before this line
        mainFrame.setVisible(true);

        /* AWT CODE - USE ONLY AS REFERENCE
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
        CategoryListener.categorySorter = new RoleSelect(mainWindow);
        new ImageMapper();
        new CategorySelect(mainWindow);
        Label AddRole = new Label("Add role");
        Label RemoveRole = new Label("Remove role");
        Label Start = new Label("Start");
        AddRole.setBounds(500, 618, 200, 60);
        RemoveRole.setBounds(750, 517, 200, 60);
        Start.setBounds(750, 618, 200, 60);
        selectedRoles = new RoleStack(mainWindow);
        AddRole.addMouseListener(new AddListener(selectedRoles));
        RemoveRole.addMouseListener(new RemoveListener(selectedRoles));
        Start.addMouseListener(new StartListener());
        mainWindow.add(AddRole);
        mainWindow.add(RemoveRole);
        mainWindow.add(Start);
        mainFrame.add(mainWindow);
        mainFrame.setVisible(true); // Should be done as the very last step
        */

    }

    class Window extends JPanel {

        Image background;
        public Window() {
            try {
                background = ImageIO.read(new File(BGpath));
            } catch (Exception e) {
                System.out.println("Background not added?");
            }
        }

        public void paint(Graphics g) {
            g.drawImage(background, 0, 0, null);
        }

    }

}
