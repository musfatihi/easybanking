package ma.easybanking.main.java.model;

import ma.easybanking.main.java.model.DAO.Services.AgencyService;
import ma.easybanking.main.java.model.DTO.Agency;

import ma.easybanking.main.java.model.DAO.Implmnts.AgencyDAOImp;

import java.util.List;
import java.util.Optional;


public class AgencyModel {

    private AgencyService agencyService;

    public AgencyModel(AgencyService agencyService){this.agencyService=agencyService;}

    public Optional<Agency> saveAgency(Agency agency){
        return agencyService.saveAgency(agency);
    }

    public boolean deleteAgency(Agency agency){
        return agencyService.deleteAgency(agency);
    }

    public Optional<Agency> findAgencyByCode(Agency agency){
        return agencyService.findAgencyByCode(agency);
    }

    public List<Agency> findAgencyByAddress(Agency agency){
        return agencyService.findAgencyByAddress(agency);
    }

    public Optional<Agency> updateAgency(Agency agency){
        return agencyService.updateAgency(agency);
    }



}
