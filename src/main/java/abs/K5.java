package abs;

public class K5 extends RentCar {
    private static final int FUEL_EFFICIENCY = 13;

    public K5(int distance) {
        super(distance);
    }

    @Override
    int getFuelEfficiency() {
        return FUEL_EFFICIENCY;
    }

    @Override
    String getCarName() {
        return "K5";
    }
}
