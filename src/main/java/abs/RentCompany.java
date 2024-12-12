package abs;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {
    private static final String NEWLINE = System.lineSeparator();

    private List<RentCar> rentCars;

    public RentCompany(){
        this.rentCars = new ArrayList<>();
    }

    public static RentCompany create() {
        return new RentCompany();
    }

    public void addCar(RentCar rentCar){
        rentCars.add(rentCar);
    }

    public String generateReport() {
        StringBuilder sb = new StringBuilder();

        for (RentCar rentCar : rentCars) {
            sb.append(rentCar.getCarName())
                    .append(" : ")
                    .append(rentCar.calculate())
                    .append("리터")
                    .append(NEWLINE);
        }

        return sb.toString();
    }
}
