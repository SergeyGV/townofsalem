package display;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class InfoDisplay {

    JFrame displayBox;
    private static InfoDisplay currentDisplay = null;

    public InfoDisplay(ArrayList<String> results) {

        if (currentDisplay == null) {
            currentDisplay = this;
        }

        displayBox = new JFrame();
        displayBox.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        Container pane = displayBox.getContentPane();
        pane.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        constraints.gridheight = 3;

        JLabel resultsBox = new JLabel("");
        resultsBox.setFont(new Font(resultsBox.getFont().getFontName(), Font.PLAIN, 10));

        String toPrint = "<html>";
        for (String result: results) {
            toPrint += result + "<br>";
        }
        toPrint += "<html>";
        resultsBox.setText(toPrint);
        pane.add(resultsBox, constraints);

        displayBox.pack();
        displayBox.setVisible(true);

    }

}
