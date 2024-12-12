package inf;

import message.ErrorMessages;

public class Sonata implements RentCar{
    private static final int FUEL_EFFICIENCY = 10;
    private int distance;

    public Sonata(int distance){
        this.distance = validDistance(distance);
    }

    @Override
    public String getCarName() {
        return "Sonata";
    }

    @Override
    public int validDistance(int distance){
        if (distance < 0){
            throw new IllegalArgumentException(ErrorMessages.INVALID_NEGATIVE_INPUT);
        }
        return distance;
    }

    @Override
    public int calculate() {
        return distance / FUEL_EFFICIENCY;
    }

}
