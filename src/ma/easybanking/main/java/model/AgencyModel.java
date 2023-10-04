package ma.easybanking.main.java.model;

import ma.easybanking.main.java.model.DTO.Agency;

import ma.easybanking.main.java.model.DAO.Implmnts.AgencyDAOImp;

import java.util.Optional;


public class AgencyModel {

    private AgencyDAOImp agencyDAOImp;

    public AgencyModel(AgencyDAOImp agencyDAOImp){this.agencyDAOImp=agencyDAOImp;}

    public Agency saveAgency(Agency agency){
        return agencyDAOImp.save(agency);
    }

    public boolean deleteAgency(Agency agency){
        return agencyDAOImp.delete(agency);
    }

    public Optional<Agency> findAgencyByCode(Agency agency){
        return agencyDAOImp.findById(agency);
    }

}