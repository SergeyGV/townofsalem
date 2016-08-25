package roles;

public class Spy extends RoleControl {

    public Spy(String name, int num) {
        super(name, num);
    }

    public void Process() {

        if (!jailed && !blocked) {
            activity.add("SpyVisits");
        }

    }

}
