package roles;

public class Survivor extends RoleControl {

    private int VestChance = 75; // 1 - 100

    public Survivor(String name, int num) {
        super(name, num);
    }

    public void Process() {

        if (!jailed) {
            if (randomizer.nextInt(100) + 1 <= VestChance) {
                nightAction = "You have decided to use a vest tonight.";
                if (!blocked) {
                    immune = true;
                }
            } else {
                nightAction = "You have decided to not use a vest tonight.";
                if (witched != 0 && !blocked) {
                    immune = true;
                } else {
                    nightResult = "You did not perform your night action.";
                }
            }
        }

    }

}
