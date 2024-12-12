package car;

public abstract class Car {
    public abstract double getDistancePerLiter();
    public abstract double getTripDistance();
    public abstract String getName();

    public double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }
}
