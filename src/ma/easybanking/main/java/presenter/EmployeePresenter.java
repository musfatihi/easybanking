package ma.easybanking.main.java.presenter;

import ma.easybanking.main.java.model.DTO.Employee;
import ma.easybanking.main.java.model.EmployeeModel;
import ma.easybanking.main.java.view.EmployeeView;

import java.util.Optional;

public class EmployeePresenter {
    private EmployeeModel employeeModel;
    private EmployeeView employeeView;

    public EmployeePresenter(EmployeeView employeeView,EmployeeModel employeeModel){
        this.employeeView = employeeView;
        this.employeeModel = employeeModel;
    }

    public void saveEmployee(){

        Optional<Employee> optionalEmployee = employeeModel.saveEmployee(employeeView.saveEmployee());

        if(optionalEmployee.isPresent())
        {
            employeeView.displayEmployee(optionalEmployee.get());
        }
        else
        {

        }

    }


}
