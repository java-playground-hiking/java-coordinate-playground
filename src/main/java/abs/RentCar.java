package abs;

import message.ErrorMessages;

public abstract class RentCar {
    private final int distance;

    public RentCar(int distance) {
        this.distance = validDistance(distance);
    }

    abstract int getFuelEfficiency();
    abstract String getCarName();

    public int validDistance(int distance){
        if (distance < 0){
            throw new IllegalArgumentException(ErrorMessages.INVALID_NEGATIVE_INPUT);
        }
        return distance;
    }


    public int calculate(){
        return distance / getFuelEfficiency();
    }


}
