package ma.easybanking.main.java.presenter;

import ma.easybanking.main.java.model.AgencyEmployeeModel;
import ma.easybanking.main.java.model.DTO.Agency;
import ma.easybanking.main.java.model.DTO.AgencyEmployee;
import ma.easybanking.main.java.model.DTO.Employee;
import ma.easybanking.main.java.view.AgencyEmployeeView;
import ma.easybanking.main.java.view.AgencyView;
import ma.easybanking.main.java.view.EmployeeView;

import java.util.Optional;

public class AgencyEmployeePresenter {

    private AgencyEmployeeModel agencyEmployeeModel;

    private EmployeeView employeeView;

    private AgencyView agencyView;

    private AgencyEmployeeView agencyEmployeeView;

    public AgencyEmployeePresenter(AgencyEmployeeModel agencyEmployeeModel,EmployeeView employeeView,AgencyView agencyView,AgencyEmployeeView agencyEmployeeView){

        this.agencyView = agencyView;
        this.employeeView = employeeView;
        this.agencyEmployeeModel = agencyEmployeeModel;
        this.agencyEmployeeView = agencyEmployeeView;

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

    public void employeeHistory(){
        agencyEmployeeView.displayAgenciesEmployee(agencyEmployeeModel.getEmployeeHistory(this.employeeView.getEmployee("")));
    }

}
