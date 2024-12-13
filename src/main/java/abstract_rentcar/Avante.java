package abstract_rentcar;

public class Avante extends AbstractRentCar {

    private final int fuelEfficiency = 15;
    private final String carName = "Avante";

    public Avante(int distance) {
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
