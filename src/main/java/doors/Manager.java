package doors;

import java.util.ArrayList;
import java.util.List;

class Manager {

    private List<Door> doors = new ArrayList<>();

    Manager(int doors) {
        for (int i = 0; i < doors; i++) {
            this.doors.add(new Door(true));
        }
    }

    void work() {
        int distance = 0;
        for (int i = 0; i < doors.size(); i++) {
            for (int j = distance; j < doors.size(); j = j + 1 + distance) {
                if (doors.get(j).isClosed()) {
                    doors.get(j).open();
                } else doors.get(j).close();
            }
            distance++;
        }
    }

    void doorsStatus() {
        System.out.println("Doors left open: ");
        for (int i = 0; i < doors.size(); i++) {
            if (!doors.get(i).isClosed()) {
                System.out.print(i+1 + " ");
            }
        }
    }
}