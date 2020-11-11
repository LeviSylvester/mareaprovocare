package doors;

import java.util.ArrayList;
import java.util.List;

class Manager {

    private List<Door> doors = new ArrayList<>();

    Manager(int doors) {
        // giving the manager a number of initially closed doors
        for (int i = 0; i < doors; i++) {
            this.doors.add(new Door(true));
        }
    }

    void work() {
        // increasing the distance between doors
        for (int distance = 0; distance < doors.size(); distance++) {

            // jumping to doors of this distance
            for (int doorNr = distance; doorNr < doors.size(); doorNr = doorNr + 1 + distance) {

                if (doors.get(doorNr).isClosed()) {
                    doors.get(doorNr).open();
                } else doors.get(doorNr).close();
            }
        }
    }

    void doorsStatus() {
        System.out.println("Doors still open: ");
        for (int i = 0; i < doors.size(); i++) {

            // print each open door number (not the index)
            if (!doors.get(i).isClosed()) {
                System.out.print(i + 1 + ". ");
            }
        }
    }
}