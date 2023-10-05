package ma.easybanking.main.java.model.DAO.Services;

import ma.easybanking.main.java.model.DAO.Implmnts.EmployeeDAOImp;
import ma.easybanking.main.java.model.DTO.Employee;

import java.util.Optional;

public class EmployeeService {
    private static EmployeeDAOImp employeeDAOImp;

    public EmployeeService(EmployeeDAOImp employeeDAOImp){
        EmployeeService.employeeDAOImp = employeeDAOImp;
    }

    public Optional<Employee> saveEmployee(Employee employee){
        return employeeDAOImp.save(employee);
    }
}
