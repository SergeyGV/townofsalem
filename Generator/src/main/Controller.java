package main;

import java.util.ArrayList;

import actions.Actions;
import actions.RoleInfo;
import generation.Generator;
import generation.RoleStorage;
import validator.MainValidator;

public class Controller {


	public static void main(String[] args) {

		// TODO: GUI...
		// TODO: Update MafiaValidator to be accepting regards to the Any slots(?)

		ArrayList<String> roles = new ArrayList<>();
		roles.add("Witch");
		roles.add("Neutral Killing");
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

	}

}
