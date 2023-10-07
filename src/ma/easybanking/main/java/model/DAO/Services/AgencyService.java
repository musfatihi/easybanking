package ma.easybanking.main.java.model.DAO.Services;

import ma.easybanking.main.java.model.DAO.Implmnts.AgencyDAOImp;
import ma.easybanking.main.java.model.DTO.Agency;


import java.util.List;
import java.util.Optional;


public class AgencyService {

    private AgencyDAOImp agencyDAOImp;

    public AgencyService(AgencyDAOImp agencyDAOImp){
        this.agencyDAOImp = agencyDAOImp;
    }


    //Agency Saving
    public Optional<Agency> saveAgency(Agency agency) {

        return agencyDAOImp.save(agency);

    }

    //Agency Deletion
    public Boolean deleteAgency(Agency agency){

        return agencyDAOImp.delete(agency.getCode());

    }

    public Optional<Agency> findAgencyByCode(Agency agency){

        return agencyDAOImp.findById(agency);

    }

    public List<Agency> findAgencyByAddress(Agency agency){

        return agencyDAOImp.findByAddress(agency);

    }


}
