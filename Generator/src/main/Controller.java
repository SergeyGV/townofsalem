package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import actions.Actions;
import actions.RoleInfo;
import generation.Generator;
import generation.RoleStorage;
import validator.MainValidator;

public class Controller {


	public static void main(String[] args) {

		// new Display(); // Display the screen
		// WHILE GUI IS WORKED ON
		ArrayList<String> roles = new ArrayList();
		roles.add("Any");
		roles.add("Any");
		roles.add("Any");
		roles.add("Any");
		roles.add("Any");
		roles.add("Any");
		roles.add("Any");
		roles.add("Any");
		roles.add("Any");
		roles.add("Any");
		roles.add("Any");
		roles.add("Any");
		roles.add("Any");
		roles.add("Any");
		roles.add("Any");
		RoleStorage storage = new RoleStorage();
		Generator gen = new Generator(storage, roles);
		MainValidator val = new MainValidator(storage, roles);
		for (String inf: val.validate()) {
			System.out.println(inf);
		}
		/*
		for (String role: gen.Generate()) {
			System.out.println(role);
		} */
		//new RoleInfo(); // Generate investigative results
		//Actions test = new Actions();
		//test.generate(gen.Generate());

	}

}