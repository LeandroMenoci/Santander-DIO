package br.com.leandro.persistence;

import java.sql.SQLException;

public class AccessesDAO {

    public void insert(final long employeeId, final long moduleId) {
        try(
                var connection = ConnectionUtil.getConnection();
                var statement = connection.prepareStatement(
                        "INSERT INTO accesses (employee_id, module_id) values (?, ?);"
                );
        ) {
            statement.setLong(1, employeeId);
            statement.setLong(2, moduleId);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
