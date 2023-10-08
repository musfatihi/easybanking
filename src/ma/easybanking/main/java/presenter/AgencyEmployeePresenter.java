package ma.easybanking.main.java.presenter;

import ma.easybanking.main.java.model.AgencyEmployeeModel;
import ma.easybanking.main.java.model.DAO.Services.AgencyEmployeeService;
import ma.easybanking.main.java.model.DTO.Agency;
import ma.easybanking.main.java.model.DTO.AgencyEmployee;
import ma.easybanking.main.java.model.DTO.Employee;
import ma.easybanking.main.java.view.AgencyView;
import ma.easybanking.main.java.view.EmployeeView;

import java.util.Optional;

public class AgencyEmployeePresenter {

    private AgencyEmployeeModel agencyEmployeeModel;

    //private AgencyEmployeeView agencyEmployeeView;
    private EmployeeView employeeView;

    private AgencyView agencyView;

    public AgencyEmployeePresenter(AgencyEmployeeModel agencyEmployeeModel,EmployeeView employeeView,AgencyView agencyView){

        this.agencyView = agencyView;
        this.employeeView = employeeView;
        this.agencyEmployeeModel = agencyEmployeeModel;

    }


    public void assignEmployeeAgency(){

        Employee employee = this.employeeView.getEmployee("");
        Agency agency = this.agencyView.getAgency("");

        Optional<AgencyEmployee> optionalAgencyEmployee = agencyEmployeeModel.assignEmployeeAgency(new AgencyEmployee(agency,employee));

        if(optionalAgencyEmployee.isPresent())
        {
            System.out.println(optionalAgencyEmployee.get());
        }


    }

}
