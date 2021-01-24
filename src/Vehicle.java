import java.util.Random;

public class Vehicle implements Runnable {

    private String category;
    private float tankCapacity;
    private float consumptionRate;
    private String vin;
    private float fuel;

    public Vehicle() {
    }

    public Vehicle(String category, float tankCapacity, float consumptionRate) {
        this.category = category;
        this.tankCapacity = tankCapacity;
        this.consumptionRate = consumptionRate;
        this.vin = generate_vin();
        this.fuel = this.tankCapacity / 2;
    }

    private String generate_vin() {
        int max = 999999999;
        int min = 100000000;
        Random random = new Random();
        return String.valueOf(random.nextInt(max - min) + min);
    }

    public void start() {
        System.out.println("Транспортное средство " + vin + " начинает движение");

        while (checkTank()) {
            fuel -= consumptionRate;
        }




        System.out.println("Транспортное средство " + vin + " заканчивает движение");
    }

    private boolean checkTank(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return fuel > 0f;
    }

    public void tankUp(){
        fuel = tankCapacity;
    }


    public String getVin() {
        return vin;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "category='" + category + '\'' +
                ", tankCapacity=" + tankCapacity +
                ", consumptionRate=" + consumptionRate +
                ", vin='" + vin + '\'' +
                ", fuel=" + fuel +
                '}';
    }

    @Override
    public void run() {
        start();
    }
}
