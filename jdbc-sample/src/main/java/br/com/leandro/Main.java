package br.com.leandro;

import br.com.leandro.persistence.EmployeeAuditDAO;
import br.com.leandro.persistence.EmployeeDAO;
import br.com.leandro.persistence.EmployeeParamDAO;
import br.com.leandro.persistence.entity.EmployeeEntity;
import net.datafaker.Faker;
import org.flywaydb.core.Flyway;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.Locale;
import java.util.stream.Stream;

import static java.time.ZoneOffset.UTC;

public class Main {

    private final static EmployeeDAO employeeDAO = new EmployeeDAO();
    private final static EmployeeParamDAO employeeParamDAO = new EmployeeParamDAO();
    private final static EmployeeAuditDAO employeeAuditDAO = new EmployeeAuditDAO();
    private final static Faker faker = new Faker(Locale.of("pt", "BR"));


    public static void main(String[] args) {

        var flyway = Flyway.configure()
                .dataSource("jdbc:mysql://localhost:3306/jdbc-sample", "root", "123456")
                .load();

        flyway.migrate();

//        var employeeInsert = new EmployeeEntity();
//        employeeInsert.setName("Paloma");
//        employeeInsert.setSalary(new BigDecimal("1100"));
//        employeeInsert.setBirthday(OffsetDateTime.now().minusYears(33));
//        System.out.println(employeeInsert);
//        employeeParamDAO.insertWithProcedure(employeeInsert);
//        System.out.println(employeeInsert);
//
//        var employeeUpdate = new EmployeeEntity();
//        employeeUpdate.setId(2);
//        employeeUpdate.setName("Leonardo");
//        employeeUpdate.setSalary(new BigDecimal(1200));
//        employeeUpdate.setBirthday(OffsetDateTime.now().minusYears(16));
//        employeeParamDAO.update(employeeUpdate);
//        System.out.println(employeeUpdate);
//
//        employeeParamDAO.delete(2);
//
//        employeeAuditDAO.findAll().forEach(System.out::println);



//        System.out.println(employeeDAO.findById(3));

//        employeeDAO.findAll().forEach(System.out::println);

        var entities = Stream.generate(() -> {
            var employee = new EmployeeEntity();
            employee.setName(faker.name().fullName());
            employee.setSalary(new BigDecimal(faker.number().digits(4)));
            employee.setBirthday(OffsetDateTime.of(faker.date().birthdayLocalDate(18, 35), LocalTime.MIN,UTC));
            return employee;
        }).limit(4000)
                .toList();
        employeeParamDAO.insertBatch(entities);


    }
}
