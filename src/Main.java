import java.util.*;

public class Main {

    // check

    public static void main(String[] args) {

    List<Vehicle> traffic = generateTraffic();

        for (Vehicle vehicle:traffic) {
            new Thread(vehicle).start();
        }

    FuelStation station = new FuelStation();
    station.tankUp(traffic);
    }

    static List<Vehicle> generateTraffic() {
        List<Vehicle> traffic = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            traffic.add(generateRandomVehicle());
          }
        return traffic;
    }

    static Vehicle generateRandomVehicle() {
        Random random = new Random();
        int choice = random.nextInt(3);
        switch (choice) {
            case 0:
                return new Car();
            case 1:
                return new Truck();
            default:
                return new Bus();
        }

    }

}
