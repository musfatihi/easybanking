package ma.easybanking.main.java.model;

import ma.easybanking.main.java.model.DAO.Services.EmployeeService;
import ma.easybanking.main.java.model.DTO.Employee;

import java.util.Optional;

public class EmployeeModel {

    private EmployeeService employeeService;

    public EmployeeModel(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    public Optional<Employee> saveEmployee(Employee employee){
        return employeeService.saveEmployee(employee);
    }


}
