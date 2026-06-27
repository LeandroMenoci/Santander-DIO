package br.com.leandro;

import br.com.leandro.persistence.EmployeeDAO;
import br.com.leandro.persistence.entity.EmployeeEntity;
import org.flywaydb.core.Flyway;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class Main {

    private final static EmployeeDAO employeeDAO = new EmployeeDAO();


    public static void main(String[] args) {

        var flyway = Flyway.configure()
                .dataSource("jdbc:mysql://localhost:3306/jdbc-sample", "root", "123456")
                .load();

        flyway.migrate();

        var employee = new EmployeeEntity();
        employee.setName("Juan");
        employee.setSalary(new BigDecimal("2500"));
        employee.setBirthday(OffsetDateTime.now().minusYears(20));
        System.out.println(employee);
        employeeDAO.insert(employee);
        System.out.println(employee);
    }
}
