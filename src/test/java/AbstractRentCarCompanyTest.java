import static org.assertj.core.api.Assertions.*;

import abstract_rentcar.Avante;
import abstract_rentcar.K5;
import abstract_rentcar.Sonata;
import company.AbstractRentCarCompany;
import org.junit.jupiter.api.Test;

public class AbstractRentCarCompanyTest {

    private static final String NEWLINE = System.getProperty("line.separator");

    @Test
    public void abstractReport() throws Exception {
        AbstractRentCarCompany company = AbstractRentCarCompany.create(); // factory method를 사용해 생성
        company.addCar(new Sonata(150));
        company.addCar(new K5(260));
        company.addCar(new Sonata(120));
        company.addCar(new Avante(300));
        company.addCar(new K5(390));

        String report = company.generateReport();
        assertThat(report).isEqualTo(
                "Sonata : 15리터" + NEWLINE +
                        "K5 : 20리터" + NEWLINE +
                        "Sonata : 12리터" + NEWLINE +
                        "Avante : 20리터" + NEWLINE +
                        "K5 : 30리터" + NEWLINE
        );
    }
}
