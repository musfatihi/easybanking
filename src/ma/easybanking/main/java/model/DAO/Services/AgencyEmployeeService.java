package ma.easybanking.main.java.model.DAO.Services;

import ma.easybanking.main.java.model.DAO.Implmnts.AgencyEmployeeDAOImp;
import ma.easybanking.main.java.model.DTO.AgencyEmployee;

import java.util.Optional;

public class AgencyEmployeeService {

    private AgencyEmployeeDAOImp agencyEmployeeDAOImp;

    public AgencyEmployeeService(AgencyEmployeeDAOImp agencyEmployeeDAOImp){
        this.agencyEmployeeDAOImp = agencyEmployeeDAOImp;
    }

    public Optional<AgencyEmployee> assignEmployeeAgency(AgencyEmployee agencyEmployee){
       return agencyEmployeeDAOImp.save(agencyEmployee);
    }



}
