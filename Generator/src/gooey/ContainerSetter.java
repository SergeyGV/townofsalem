package gooey;

import java.awt.*;

public class ContainerSetter {

    public static GridBagConstraints setUpGenerateButton() {

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.ipadx = 100;
        constraints.ipady = 65;
        constraints.insets = new Insets(0, 5, 5, 5);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        return (constraints);

    }

    public static GridBagConstraints setUpRemoveButton() {

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.ipadx = 100;
        constraints.ipady = 65;
        constraints.insets = new Insets(0, 5, 5, 5);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        return (constraints);

    }

    public static GridBagConstraints setUpStackPanel() {

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 3;
        constraints.ipadx = 100;
        constraints.ipady = 350;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        return (constraints);

    }

    public static GridBagConstraints setUpPrinterPanel() {

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 5;
        constraints.gridheight = 5;
        constraints.ipadx = 500;
        constraints.ipady = 539;
        constraints.insets = new Insets(5, 20, 5, 5);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        return (constraints);

    }

}
