package inf;

import message.ErrorMessages;

public class K5 implements RentCar{
    private static final int FUEL_EFFICIENCY = 13;

    private int distance;

    public K5(int distance){
        this.distance = validDistance(distance);
    }


    @Override
    public String getCarName() {
        return "K5";
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
