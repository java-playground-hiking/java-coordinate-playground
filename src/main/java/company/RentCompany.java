package company;

import car.Car;
import java.util.ArrayList;
import java.util.List;

public class RentCompany {
    private final List<Car> cars = new ArrayList<>();

    private RentCompany() {}

    public static RentCompany create() {
        return new RentCompany();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public String generateReport() {
        StringBuilder report = new StringBuilder();
        for (Car car : cars) {
            report.append(car.getName())
                    .append(" : ")
                    .append((int) Math.ceil(car.getChargeQuantity()))
                    .append("리터")
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
