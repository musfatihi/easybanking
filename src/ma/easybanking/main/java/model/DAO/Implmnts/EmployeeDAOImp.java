package ma.easybanking.main.java.model.DAO.Implmnts;

import ma.easybanking.main.java.model.DAO.Intrfcs.GenericInterface;
import ma.easybanking.main.java.model.DTO.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

public class EmployeeDAOImp implements GenericInterface<Employee,Integer> {

    private static Connection connection;

    private static final String SAVE_EMPLOYEE = "insert into employees (firstname,lastname, birthdate, address, phonenumber, rcrtmntdate, mailaddress) values (?,?,?,?,?,?,?) returning mtrcltnbr";


    public EmployeeDAOImp(Connection connection){
        EmployeeDAOImp.connection = connection;
    }

    @Override
    public Optional<Employee> save(Employee employee) {

        try {

            PreparedStatement stmt = connection.prepareStatement(SAVE_EMPLOYEE, ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            stmt.setString(1, employee.getFirstName());
            stmt.setString(2, employee.getLastName());
            stmt.setDate(3, java.sql.Date.valueOf(employee.getBirthDate()));
            stmt.setString(4, employee.getAddress());
            stmt.setString(5, employee.getPhoneNumber());
            stmt.setDate(6, java.sql.Date.valueOf(employee.getRcrtmntDate()));
            stmt.setString(7, employee.getMailAddress());

            ResultSet resultSet = stmt.executeQuery();

            while(resultSet.next())
            {
                employee.setMtrcltNbr(resultSet.getInt(1));
                return Optional.of(employee);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return Optional.empty();
    }

    @Override
    public Optional<Employee> update(Employee employee) {
        return Optional.empty();
    }

    @Override
    public Optional<Employee> findById(Employee employee) {
        return Optional.empty();
    }

    @Override
    public Boolean delete(Integer mtrcl) {
        return null;
    }
}
