package ma.easybanking.main.java.model;

import ma.easybanking.main.java.model.DAO.Services.AgencyEmployeeService;
import ma.easybanking.main.java.model.DTO.AgencyEmployee;

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

}
