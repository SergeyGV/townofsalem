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
			for (String inf: val.getInfractions()) {
				System.out.println(inf);
			}
		} else {
			ArrayList<String> result = gen.Generate();
			RoleInfo.populate(); // Generate investigative results
			Actions test = new Actions();
			test.generate(result);
		}
		return new ArrayList<>();
	}

	public static void main(String[] args) {

		// TODO: GUI...
		// TODO: Update MafiaValidator to be accepting regards to the Any slots(?)
		// TODO: ActivityPrint to return an ArrayList of results, and for that to be returned from generation

		Controller simulator = new Controller();
		simulator.initializeGUI();

	}

}
