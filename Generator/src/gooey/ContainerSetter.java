package gooey;

import java.awt.*;

public class ContainerSetter {

    public static GridBagConstraints setUpLeftPanel() {

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        //constraints.ipadx = 200;
        //constraints.ipady = 550;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.insets = new Insets(20, 20, 20, 20);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        return (constraints);

    }

    public static GridBagConstraints setUpCenterPanel() {

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.ipadx = 200;
        constraints.ipady = 550;
        constraints.insets = new Insets(20, 20, 20, 20);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        return (constraints);

    }

    public static GridBagConstraints setUpRightPanel() {

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.ipadx = 500;
        constraints.ipady = 550;
        constraints.insets = new Insets(20, 20, 20, 20);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        return (constraints);

    }

    public static GridBagConstraints setUpCategoryPanel() {

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.ipadx = 200;
        constraints.ipady = 140;
        constraints.insets = new Insets(0, 0, 10, 0);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        return (constraints);

    }

    public static GridBagConstraints setUpRolePanel() {

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.ipadx = 200;
        constraints.ipady = 400;
        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        return (constraints);

    }

    public static GridBagConstraints setUpGenerateButton() {

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 1;
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
        constraints.gridx = 1;
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
        constraints.gridx = 1;
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
        constraints.gridx = 2;
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
