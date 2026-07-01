package br.com.leandro;

import br.com.leandro.persistence.ContactDAO;
import br.com.leandro.persistence.EmployeeAuditDAO;
import br.com.leandro.persistence.EmployeeDAO;
import br.com.leandro.persistence.EmployeeParamDAO;
import br.com.leandro.persistence.entity.ContactEntity;
import br.com.leandro.persistence.entity.EmployeeEntity;
import br.com.leandro.persistence.entity.ModuleEntity;
import net.datafaker.Faker;
import org.flywaydb.core.Flyway;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Locale;
import java.util.stream.Stream;

import static java.time.ZoneOffset.UTC;

public class Main {

    private final static EmployeeDAO employeeDAO = new EmployeeDAO();
    private final static EmployeeParamDAO employeeParamDAO = new EmployeeParamDAO();
    private final static EmployeeAuditDAO employeeAuditDAO = new EmployeeAuditDAO();
    private final static ContactDAO contactDAO = new ContactDAO();
    private final static Faker faker = new Faker(Locale.of("pt", "BR"));


    public static void main(String[] args) {

        var flyway = Flyway.configure()
                .dataSource("jdbc:mysql://localhost:3306/jdbc-sample", "root", "123456")
//                .cleanDisabled(false)
                .load();
//        flyway.clean();
        flyway.migrate();

//        var employeeInsert = new EmployeeEntity();
//        employeeInsert.setName("Paloma");
//        employeeInsert.setSalary(new BigDecimal("1100"));
//        employeeInsert.setBirthday(OffsetDateTime.now().minusYears(33));
//        System.out.println(employeeInsert);
//        employeeParamDAO.insert(employeeInsert);
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

//        var entities = Stream.generate(() -> {
//            var employee = new EmployeeEntity();
//            employee.setName(faker.name().fullName());
//            employee.setSalary(new BigDecimal(faker.number().digits(4)));
//            employee.setBirthday(OffsetDateTime.of(faker.date().birthdayLocalDate(18, 35), LocalTime.MIN,UTC));
//            return employee;
//        }).limit(4000)
//                .toList();
//        employeeParamDAO.insertBatch(entities);


//        var employeeInsert = new EmployeeEntity();
//        employeeInsert.setName("Maria de Lurdes");
//        employeeInsert.setSalary(new BigDecimal("3121"));
//        employeeInsert.setBirthday(OffsetDateTime.now().minusYears(21));
//        System.out.println(employeeInsert);
//        employeeParamDAO.insert(employeeInsert);
//        System.out.println(employeeInsert);
//
//        var contact1 = new ContactEntity();
//        contact1.setDescription("maria@lurdes.com");
//        contact1.setType("e-mail");
//        contact1.setEmployee(employeeInsert);
//        contactDAO.insert(contact1);
//
//        var contact2 = new ContactEntity();
//        contact2.setDescription("31999999999");
//        contact2.setType("telefone");
//        contact2.setEmployee(employeeInsert);
//        contactDAO.insert(contact2);

//        System.out.println(employeeParamDAO.findById(1));

//        employeeParamDAO.findAll().forEach(System.out::println);

        var entities = Stream.generate(() -> {
            var employee = new EmployeeEntity();
            employee.setName(faker.name().fullName());
            employee.setSalary(new BigDecimal(faker.number().digits(4)));
            employee.setBirthday(OffsetDateTime.of(faker.date().birthdayLocalDate(18, 35), LocalTime.MIN,UTC));
            employee.setModules(new ArrayList<>());
            var moduleAmount = faker.number().numberBetween(1, 4);
                    for (int i = 0; i < moduleAmount; i++) {
                        var module = new ModuleEntity();
                        module.setId(i + 1);
                        employee.getModules().add(module);
                    }
            return employee;
        }).limit(3).toList();
        entities.forEach(employeeParamDAO::insert);
    }
}
