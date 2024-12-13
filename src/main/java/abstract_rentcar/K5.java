package abstract_rentcar;

public class K5 extends AbstractRentCar {

    private final int fuelEfficiency = 13;
    private final String carName = "K5";

    public K5(int distance) {
        super(distance);
    }

    @Override
    public String getCarName() {
        return carName;
    }

    @Override
    public int getFuelEfficiency() {
        return fuelEfficiency;
    }
}
