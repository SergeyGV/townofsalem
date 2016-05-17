package gui;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Display - The main menu of the GUI, in charge of saying what gets
 * displayed, and when
 */
public class Display {

    private Frame mainFrame; // Overarching Frame
    private int FrameLength = 700;
    private int FrameWidth = 1000;
    private RoleStack roleList;

    public Display() {

        mainFrame = new Frame("Town Of Salem Simulator");
        mainFrame.setSize(FrameWidth, FrameLength);
        mainFrame.setLayout(null); // Locations will be done manually
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        roleList = new RoleStack();
        mainFrame.add(roleList.returnPanel());
        mainFrame.setVisible(true); // Should be done as the very last step

    }

}
