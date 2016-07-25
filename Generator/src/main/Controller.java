package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import actions.Actions;
import actions.RoleInfo;
import generation.Generator;
import generation.RoleStorage;

public class Controller {
	
	/*

	private String getTownRole() {
		int totalSize = TK.size() + TI.size() + TS.size();
		int chosen = randomizer.nextInt(totalSize + TP.size());
		if (totalSize < chosen) {
			return(getRole(TP));
		}
		totalSize -= TS.size();
		if (totalSize < chosen) {
			return(getRole(TS));
		}
		totalSize -= TI.size();
		if (totalSize < chosen) {
			return(getRole(TI));
		}
		return(getRole(TK));
	}

	private String getAnyRole() {
		int totalSize = TK.size() + TI.size() + TS.size() + TP.size()
		+ Mafia.size() + NK.size() + NE.size() + NB.size();
		int chosen = randomizer.nextInt(totalSize + 1);
		if (chosen == totalSize) { // Vampire special case
			TK.add(TK.size(), "Vampire Hunter");
			return("Vampire");
		}
		totalSize -= NB.size();
		if (totalSize < chosen) {
			return(getRole(NB));
		}
		totalSize -= NE.size();
		if (totalSize < chosen) {
			return(getRole(NE));
		}
		totalSize -= NK.size();
		if (totalSize < chosen) {
			return(getRole(NK));
		}
		totalSize -= Mafia.size();
		if (totalSize < chosen) {
			return(getRole(Mafia));
		}
		totalSize -= TP.size();
		if (totalSize < chosen) {
			return(getRole(TP));
		}		
		totalSize -= TS.size();
		if (totalSize < chosen) {
			return(getRole(TS));
		}		
		totalSize -= TK.size();
		if (totalSize < chosen) {
			return(getRole(TK));
		}		
		return(getRole(TI));
	}

	private String getRole(ArrayList<String> RoleList) {
		int chosenRole = randomizer.nextInt(RoleList.size());
		String roleName = RoleList.get(chosenRole);
		if (Unique.contains(roleName)) {
			Unique.remove(roleName);
			RoleList.remove(roleName);
		}
		return (roleName);
	}

	*/

	public static void main(String[] args) {

		// new Display(); // Display the screen
		// WHILE GUI IS WORKED ON
		ArrayList<String> roles = new ArrayList();
		roles.add("Lookout");
		roles.add("Lookout");
		roles.add("Mafia Support");
		roles.add("Mafia Killing");
		roles.add("Random Town");
		roles.add("Random Town");
		roles.add("Lookout");
		roles.add("Lookout");
		roles.add("Random Neutral");
		roles.add("Random Neutral");
		roles.add("Random Neutral");
		roles.add("Any");
		roles.add("Any");
		roles.add("Lookout");
		roles.add("Lookout");
		Generator gen = new Generator(new RoleStorage(), roles);
		for (String role: gen.Generate()) {
			System.out.println(role);
		}
		//new RoleInfo(); // Generate investigative results
		//Actions test = new Actions();
		//test.generate(gen.Generate());

	}

}
