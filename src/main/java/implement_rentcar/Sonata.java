package implement_rentcar;

public class Sonata implements ImplementRentCar {

    private final int fuelEfficiency = 10;
    private final String carName = "Sonata";
    private final int distance;

    public Sonata(int distance) {
        this.distance = distance;
    }

    @Override
    public int getFuelEfficiency() {
        return fuelEfficiency;
    }

    @Override
    public String getCarName() {
        return carName;
    }

    @Override
    public String getRentCarInfo() {
        return getCarName() + " : " + getRequiredRemainingFuel() + "리터";
    }

    @Override
    public int getRequiredRemainingFuel() {
        return distance / getFuelEfficiency();
    }
}
