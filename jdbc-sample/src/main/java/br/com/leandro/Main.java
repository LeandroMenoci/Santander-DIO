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


        // RECURSOS AVANÇADOS DO BANCO DE DADOS

//        employeeDAO.delete(1);

//        var employee = new EmployeeEntity();
//        employee.setId(3);
//        employee.setName("Leonardo");
//        employee.setSalary(new BigDecimal(1200));
//        employee.setBirthday(OffsetDateTime.now().minusYears(16));
//        employeeDAO.update(employee);
//        System.out.println(employee);

//        System.out.println(employeeDAO.findById(3));

//        employeeDAO.findAll().forEach(System.out::println);

        /*var employee = new EmployeeEntity();
        employee.setName("João");
        employee.setSalary(new BigDecimal("2600"));
        employee.setBirthday(OffsetDateTime.now().minusYears(56));
        System.out.println(employee);
        employeeDAO.insert(employee);
        System.out.println(employee);*/
    }
}
