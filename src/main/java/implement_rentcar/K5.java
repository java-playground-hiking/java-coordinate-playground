package implement_rentcar;

public class K5 implements ImplementRentCar {

    private final int fuelEfficiency = 13;
    private final String carName = "K5";
    private final int distance;

    public K5(int distance) {
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
