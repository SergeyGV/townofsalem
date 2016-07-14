package gui;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.util.HashMap;

/**
 * ImageMapper - Class used to store the reference points to images, via
 * data structures such as HashMaps
 */
public class ImageMapper {

    public static HashMap<String, Image> roleImages;

    public ImageMapper() {

        roleImages = new HashMap<>();
        try {
            // MAFIA
            roleImages.put("godfather", ImageIO.read(new File("Controller/pictures/mafia/godfather.jpg")));
            roleImages.put("mafioso", ImageIO.read(new File("Controller/pictures/mafia/mafioso.jpg")));
            roleImages.put("disguisor", ImageIO.read(new File("Controller/pictures/mafia/disguisor.jpg")));
            roleImages.put("forger", ImageIO.read(new File("Controller/pictures/mafia/forger.jpg")));
            roleImages.put("framer", ImageIO.read(new File("Controller/pictures/mafia/framer.jpg")));
            roleImages.put("janitor", ImageIO.read(new File("Controller/pictures/mafia/janitor.jpg")));
            roleImages.put("blackmailer", ImageIO.read(new File("Controller/pictures/mafia/blackmailer.jpg")));
            roleImages.put("consigliere", ImageIO.read(new File("Controller/pictures/mafia/consigliere.jpg")));
            roleImages.put("consort", ImageIO.read(new File("Controller/pictures/mafia/consort.jpg")));
            // TOWN
            roleImages.put("jailor", ImageIO.read(new File("Controller/pictures/town/jailor.png")));
            roleImages.put("vampire hunter", ImageIO.read(new File("Controller/pictures/town/vampire hunter.jpg")));
            roleImages.put("veteran", ImageIO.read(new File("Controller/pictures/town/veteran.jpg")));
            roleImages.put("vigilante", ImageIO.read(new File("Controller/pictures/town/vigilante.jpg")));
            roleImages.put("bodyguard", ImageIO.read(new File("Controller/pictures/town/bodyguard.jpg")));
            roleImages.put("doctor", ImageIO.read(new File("Controller/pictures/town/doctor.jpg")));
            roleImages.put("escort", ImageIO.read(new File("Controller/pictures/town/escort.jpg")));
            roleImages.put("medium", ImageIO.read(new File("Controller/pictures/town/medium.jpg")));
            roleImages.put("mayor", ImageIO.read(new File("Controller/pictures/town/mayor.jpg")));
            roleImages.put("retributionist", ImageIO.read(new File("Controller/pictures/town/retributionist.jpg")));
            roleImages.put("transporter", ImageIO.read(new File("Controller/pictures/town/transporter.jpg")));
            roleImages.put("investigator", ImageIO.read(new File("Controller/pictures/town/investigator.jpg")));
            roleImages.put("lookout", ImageIO.read(new File("Controller/pictures/town/lookout.jpg")));
            roleImages.put("sheriff", ImageIO.read(new File("Controller/pictures/town/sheriff.jpg")));
            roleImages.put("spy", ImageIO.read(new File("Controller/pictures/town/spy.jpg")));
            // NEUTRAL
            roleImages.put("survivor", ImageIO.read(new File("Controller/pictures/neutral/survivor.jpg")));
            roleImages.put("amnesiac", ImageIO.read(new File("Controller/pictures/neutral/amnesiac.jpg")));
            roleImages.put("vampire", ImageIO.read(new File("Controller/pictures/neutral/vampire.jpg")));
            roleImages.put("jester", ImageIO.read(new File("Controller/pictures/neutral/jester.jpg")));
            roleImages.put("executioner", ImageIO.read(new File("Controller/pictures/neutral/executioner.jpg")));
            roleImages.put("witch", ImageIO.read(new File("Controller/pictures/neutral/witch.jpg")));
            roleImages.put("arsonist", ImageIO.read(new File("Controller/pictures/neutral/arsonist.jpg")));
            roleImages.put("serial killer", ImageIO.read(new File("Controller/pictures/neutral/serial killer.jpg")));
            roleImages.put("werewolf", ImageIO.read(new File("Controller/pictures/neutral/werewolf.jpg")));
            // RANDOM
            roleImages.put("any", ImageIO.read(new File("Controller/pictures/random/any.jpg")));
            roleImages.put("mafia deception", ImageIO.read(new File("Controller/pictures/random/mafia deception.jpg")));
            roleImages.put("mafia support", ImageIO.read(new File("Controller/pictures/random/mafia support.jpg")));
            roleImages.put("neutral benign", ImageIO.read(new File("Controller/pictures/random/neutral benign.jpg")));
            roleImages.put("neutral evil", ImageIO.read(new File("Controller/pictures/random/neutral evil.jpg")));
            roleImages.put("neutral killing", ImageIO.read(new File("Controller/pictures/random/neutral killing.jpg")));
            roleImages.put("random mafia", ImageIO.read(new File("Controller/pictures/random/random mafia.jpg")));
            roleImages.put("random neutral", ImageIO.read(new File("Controller/pictures/random/random neutral.jpg")));
            roleImages.put("random town", ImageIO.read(new File("Controller/pictures/random/random town.jpg")));
            roleImages.put("town investigative", ImageIO.read(new File("Controller/pictures/random/town investigative.jpg")));
            roleImages.put("town killing", ImageIO.read(new File("Controller/pictures/random/town killing.jpg")));
            roleImages.put("town protective", ImageIO.read(new File("Controller/pictures/random/town protective.jpg")));
            roleImages.put("town support", ImageIO.read(new File("Controller/pictures/random/town support.jpg")));
        } catch (Exception e) {
            System.out.println("You shouldn't be seeing this.");
        }

    }

}
