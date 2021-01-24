import java.util.List;
import java.util.concurrent.Semaphore;

public class FuelStation {

    private final Semaphore fillingSemaphore;

    public FuelStation() {
        fillingSemaphore = new Semaphore(3);

    }

    public void tankUp(List<Vehicle> traffic) {

        for (Vehicle vehicle : traffic) {
            new Thread(() -> {
                try {
                    System.out.println("Транспортное средство " + vehicle.getVin() + " заехало на заправку");
                    fillingSemaphore.acquire();
                    System.out.println("Транспортное средство " + vehicle.getVin() + " у колонки");
                    vehicle.tankUp();
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("Транспортное средство " + vehicle.getVin() + " заправлено");
                    fillingSemaphore.release();
                }
            }).start();

        }
    }
}
