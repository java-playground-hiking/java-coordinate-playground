package company;

import car.Avante;
import car.K5;
import car.Sonata;
import company.RentCompany;

public class RentCompanyTest {
    private static final String NEWLINE = System.getProperty("line.separator");

    public static void main(String[] args) {
        RentCompany company = RentCompany.create();
        company.addCar(new Sonata(150));
        company.addCar(new K5(260));
        company.addCar(new Sonata(120));
        company.addCar(new Avante(300));
        company.addCar(new K5(390));

        String report = company.generateReport();
        System.out.println(report);
        // 예상 결과:
        // Sonata : 15리터
        // K5 : 20리터
        // Sonata : 12리터
        // Avante : 20리터
        // K5 : 30리터
    }
}
