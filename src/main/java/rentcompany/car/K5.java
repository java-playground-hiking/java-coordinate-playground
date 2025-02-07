package rentcompany.car;

public class K5 extends AbstractCar {
    private static final double DISTANCE_PER_LITER = 13;
    private String name;

    public K5(double distance) {
        super(distance, DISTANCE_PER_LITER);
        this.name = "K5";
    }

    @Override
    public String getName() {
        return name;
    }
}
