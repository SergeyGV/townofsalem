package main;

import java.util.ArrayList;

import actions.Actions;
import actions.RoleInfo;
import display.ScreenControl;
import generation.Generator;
import generation.RoleStorage;
import validator.MainValidator;

public class Controller {

	private ScreenControl screen;

	private void initializeGUI() {
		screen = new ScreenControl(this);
		screen.showGUI();
	}


	public ArrayList<String> simulate(ArrayList<String> roles) {
		RoleStorage storage = new RoleStorage();
		MainValidator val = new MainValidator(storage, roles);
		Generator gen = new Generator(storage, roles, val);
		val.validate();
		if (val.getInfractions().size() != 0) {
			val.getInfractions().add(0, "Violations:");
			return val.getInfractions();
		} else {
			ArrayList<String> result = gen.Generate();
			RoleInfo.populate(); // Generate investigative results
			Actions test = new Actions();
			return test.generate(result);
		}

	}

	public static void main(String[] args) {

		// TODO: Update Docs for GUI
		// TODO: Make errors more specific
		// TODO: Update MafiaValidator to be accepting regards to the Any slots(?)
		// TODO: Reset variables after simulations

		Controller simulator = new Controller();
		simulator.initializeGUI();

	}

}
