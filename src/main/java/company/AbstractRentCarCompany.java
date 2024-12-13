package company;

import abstract_rentcar.AbstractRentCar;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AbstractRentCarCompany {

    public static final String NEW_LINE = "\n";
    private List<AbstractRentCar> rentCars;

    private AbstractRentCarCompany() {
        rentCars = new ArrayList<>();
    }

    public static AbstractRentCarCompany create() {
        return new AbstractRentCarCompany();
    }

    public void addCar(AbstractRentCar rentCar) {
        rentCars.add(rentCar);
    }

    public String generateReport() {
        return rentCars.stream()
                .map(AbstractRentCar::getRentCarInfo)
                .collect(Collectors.joining(NEW_LINE)) + NEW_LINE;
    }
}
