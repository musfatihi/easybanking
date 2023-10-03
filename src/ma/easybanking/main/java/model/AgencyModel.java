package ma.easybanking.main.java.model;

import ma.easybanking.main.java.model.DAO.Services.AgencyService;
import ma.easybanking.main.java.model.DTO.Agency;

public class AgencyModel {

    public static AgencyService agencyService;

    public AgencyModel(AgencyService agencyService){
        AgencyModel.agencyService=agencyService;
    }

    public Agency saveAgency(Agency agency){
        return agencyService.saveAgency(agency);
    }

}
