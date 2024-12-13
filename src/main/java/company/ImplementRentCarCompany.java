package company;

import implement_rentcar.ImplementRentCar;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ImplementRentCarCompany {

    public static final String NEW_LINE = "\n";
    private List<ImplementRentCar> rentCars;

    private ImplementRentCarCompany() {
        rentCars = new ArrayList<>();
    }

    public static ImplementRentCarCompany create() {
        return new ImplementRentCarCompany();
    }

    public void addCar(ImplementRentCar rentCar) {
        rentCars.add(rentCar);
    }

    public String generateReport() {
        return rentCars.stream()
                .map(ImplementRentCar::getRentCarInfo)
                .collect(Collectors.joining(NEW_LINE)) + NEW_LINE;
    }
}
