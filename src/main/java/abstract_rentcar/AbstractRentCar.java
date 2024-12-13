package abstract_rentcar;

public abstract  class AbstractRentCar {
    private final int distance;

    public AbstractRentCar(int distance) {
        this.distance = distance;
    }

    public abstract int getFuelEfficiency();
    public abstract String getCarName();

    public String getRentCarInfo() {
        return getCarName() + " : " + getRequiredRemainingFuel() + "리터";
    }

    public int getRequiredRemainingFuel() {
        return distance / getFuelEfficiency();

    }
}
