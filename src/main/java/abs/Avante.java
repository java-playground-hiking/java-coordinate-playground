package abs;

public class Avante extends RentCar {
    private static final int FUEL_EFFICIENCY = 15;

    public Avante(int distance) {
        super(distance);
    }

    @Override
    int getFuelEfficiency() {
        return FUEL_EFFICIENCY;
    }

    @Override
    String getCarName() {
        return "Avante";
    }
}
