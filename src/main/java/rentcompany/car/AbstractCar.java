package rentcompany.car;

public abstract class AbstractCar implements Car {
    private double distance;
    private double distancePerLiter;

    public AbstractCar(double distance, double distancePerLiter) {
        this.distance = distance;
        this.distancePerLiter = distancePerLiter;
    }

    public double getChargeQuantity() {
        return distance / distancePerLiter;
    }
}
