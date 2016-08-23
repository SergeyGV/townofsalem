package roles;

public class Veteran extends RoleControl {

    private int alertChance = 100; // Chance of alerting

    public Veteran(String name, int num) {
        super(name, num);
    }

    public void Process() {
        vetNum = playerNum;
        if (!jailed) {
            if (randomizer.nextInt(100) + 1 <= alertChance) {
                nightAction = "You have decided to go on alert.";
                alert = true;
            } else {
                nightAction = "You have not went on alert this night.";
                // Vet cannot be forced to alert if he doesn't choose to do it
                nightResult = "You did not perform your night ability.";
            }
        }

    }

}
