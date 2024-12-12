package abs;

public class Sonata extends RentCar{
    private static final int FUEL_EFFICIENCY = 10;

    public Sonata(int distance) {
        super(distance);
    }

    @Override
    int getFuelEfficiency() {
        return FUEL_EFFICIENCY;
    }

    @Override
    String getCarName() {
        return "Sonata";
    }


}
