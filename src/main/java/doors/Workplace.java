package doors;

public class Workplace {

    public static void main(String[] args) {

        Manager doorManager = new Manager(100);
        doorManager.work();

        doorManager.doorsStatus();
    }
}