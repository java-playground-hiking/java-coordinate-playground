package implement_rentcar;

public class Avante implements ImplementRentCar {

    private final int fuelEfficiency = 15;
    private final String carName = "Avante";
    private final int distance;

    public Avante(int distance) {
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
