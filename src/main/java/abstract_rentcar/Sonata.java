package abstract_rentcar;

public class Sonata extends AbstractRentCar {

    private final int fuelEfficiency = 10;
    private final String carName = "Sonata";

    public Sonata(int distance) {
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
