package doors;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Manager {

    private List<Door> doors = new ArrayList<>();

    Manager(int allDoors) {
        // give the manager a number of initially closed doors
        IntStream.range(0, allDoors).forEach(i -> doors.add(new Door(true)));
    }

    private Door door(int nr) {
        return doors.get(nr);
    }

    private int alldoors() {
        return doors.size();
    }

    void work() {
        // increase the distance between doors
        for (int distance = 0; distance < alldoors(); distance++) {

            // jump to doors of this distance
            for (int nr = distance; nr < alldoors(); nr = nr + 1 + distance) {

                if (door(nr).isClosed()) {
                    door(nr).open();
                } else door(nr).close();
            }
        }
    }

    void doorsStatus() {
        System.out.println("Doors still open: ");

        // print each open door number (not the index)
        doors.stream().filter(door -> !door.isClosed())
                .forEach(door -> System.out.print(
                doors.indexOf(door) + 1 + ". "));
    }
}