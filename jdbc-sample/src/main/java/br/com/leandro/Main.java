package br.com.leandro;

import br.com.leandro.persistence.EmployeeAuditDAO;
import br.com.leandro.persistence.EmployeeDAO;
import br.com.leandro.persistence.entity.EmployeeEntity;
import org.flywaydb.core.Flyway;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class Main {

    private final static EmployeeDAO employeeDAO = new EmployeeDAO();
    private final static EmployeeAuditDAO employeeAuditDAO = new EmployeeAuditDAO();


    public static void main(String[] args) {

        var flyway = Flyway.configure()
                .dataSource("jdbc:mysql://localhost:3306/jdbc-sample", "root", "123456")
                .load();

        flyway.migrate();

//        var employeeInsert = new EmployeeEntity();
//        employeeInsert.setName("Jose");
//        employeeInsert.setSalary(new BigDecimal("2600"));
//        employeeInsert.setBirthday(OffsetDateTime.now().minusYears(56));
//        System.out.println(employeeInsert);
//        employeeDAO.insert(employeeInsert);
//        System.out.println(employeeInsert);
//
        var employeeUpdate = new EmployeeEntity();
        employeeUpdate.setId(2);
        employeeUpdate.setName("Leonardo");
        employeeUpdate.setSalary(new BigDecimal(1200));
        employeeUpdate.setBirthday(OffsetDateTime.now().minusYears(16));
        employeeDAO.update(employeeUpdate);
        System.out.println(employeeUpdate);

        employeeDAO.delete(2);

        employeeAuditDAO.findAll().forEach(System.out::println);



//        System.out.println(employeeDAO.findById(3));

//        employeeDAO.findAll().forEach(System.out::println);


    }
}
