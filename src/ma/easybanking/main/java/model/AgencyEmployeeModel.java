package ma.easybanking.main.java.model;

import ma.easybanking.main.java.model.DAO.Services.AgencyEmployeeService;
import ma.easybanking.main.java.model.DTO.AgencyEmployee;
import ma.easybanking.main.java.model.DTO.Employee;

import java.util.List;
import java.util.Optional;

public class AgencyEmployeeModel {

    private AgencyEmployeeService agencyEmployeeService;

    public AgencyEmployeeModel(AgencyEmployeeService agencyEmployeeService)
    {
        this.agencyEmployeeService = agencyEmployeeService;
    }

    public Optional<AgencyEmployee> assignEmployeeAgency(AgencyEmployee agencyEmployee){

        return agencyEmployeeService.assignEmployeeAgency(agencyEmployee);
    }

    public List<AgencyEmployee> getEmployeeHistory(Employee employee){
        return agencyEmployeeService.getEmployeeHistory(employee);
    }

}
