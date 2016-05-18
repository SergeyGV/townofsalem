package gui;

import javafx.scene.layout.Pane;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private int FrameLength = 700;
    private int FrameWidth = 1000;
    private RoleStack roleList;
    private String BGpath = "/home/sergey/workspace/townofsalem/Generator/pictures/TOSSimBG.png";

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
        roleList = new RoleStack(mainWindow);
        Button butt = new Button("Add role");
        Button butter = new Button("Remove role");
        butt.setBounds(400, 400, 130, 50);
        butter.setBounds(400, 450, 130, 50);
        butt.setActionCommand("Add");
        butter.setActionCommand("Remove");
        butt.addActionListener(new ButtonListener());
        butter.addActionListener(new ButtonListener());
        mainWindow.add(butt);
        mainWindow.add(butter);
        mainFrame.add(mainWindow);
        mainFrame.setVisible(true); // Should be done as the very last step

    }

    public class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("Add")) {
                roleList.pushRole("Town Investigative");
            } else {
                roleList.popRole();
            }
        }
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
