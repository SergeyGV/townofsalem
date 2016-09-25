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
    // Custom BG dimensions, don't change unless BG is removed!
    private int frameLength = 700;
    private int frameWidth = 1000;
    private String BGpath = "Generator/Assets/mainBG.png";

    /**
     * Launches the interface of this program
     */
    public void initDisplay() {

        // Screen set up
        mainFrame = new JFrame("Town of Salem Simulator");
        mainFrame.setLayout(new GridLayout(1, 1));
        mainFrame.setBounds(0, 0, frameWidth, frameLength);
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // Background set up
        controlPanel = new JPanel();
        controlPanel.setBounds(0, 0, frameWidth, frameLength);
        controlPanel.setLayout(new GridBagLayout());
        controlPanel.setVisible(true);
        mainFrame.add(controlPanel);

        // Category set up
        new CategorySelect(controlPanel);

        // All components should already be ready to go/added before this line
        mainFrame.setVisible(true);

        /* AWT CODE - USE ONLY AS REFERENCE
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

    class MainWindow extends JPanel {

        Image background;
        public MainWindow() {
            try {
                background = ImageIO.read(new File(BGpath));
            } catch (Exception e) {
                System.out.println("Background not added?");
            }
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(background, 0, 0, null);
        }

    }

}
