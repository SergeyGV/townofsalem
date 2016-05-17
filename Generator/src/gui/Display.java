package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        Panel thing = new Panel();
        thing.setLayout(null);
        thing.setBounds(0,0,1000,1000);
        mainFrame = new Frame("Town Of Salem Simulator");
        mainFrame.setSize(FrameWidth, FrameLength);
        mainFrame.setResizable(false);
        mainFrame.setLayout(null); // Locations will be done manually
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        roleList = new RoleStack();
        mainFrame.add(roleList.returnPanel());
        Button butt = new Button("Add role");
        Button butter = new Button("Remove role");
        butt.setBounds(400, 400, 130, 50);
        butter.setBounds(400, 450, 130, 50);
        butt.setActionCommand("Add");
        butter.setActionCommand("Remove");
        butt.addActionListener(new ButtonListener());
        butter.addActionListener(new ButtonListener());
        thing.add(butt);
        thing.add(butter);
        mainFrame.add(thing);
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

}
