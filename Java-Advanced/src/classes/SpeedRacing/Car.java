package classes.SpeedRacing;

public class Car {
    private String model;
    private double fuel;
    private double fuelCoast;
    private int distance = 0;

    public Car(String model, double fuel, double fuelCoast) {
        this.model = model;
        this.fuel = fuel;
        this.fuelCoast = fuelCoast;
    }

    public boolean travel(double distanceToTravel) {
        double neededFuel = distanceToTravel * this.fuelCoast;

        if (this.fuel >= neededFuel) {
            this.fuel -= neededFuel;
            this.distance += distanceToTravel;
            return true;
        }

        return false;
    }

    public double getFuel() {
        return this.fuel;
    }

    public double getDistance() {
        return this.distance;
    }
}
