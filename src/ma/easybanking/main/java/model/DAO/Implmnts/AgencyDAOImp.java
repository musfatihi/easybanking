package ma.easybanking.main.java.model.DAO.Implmnts;

import ma.easybanking.main.java.model.DAO.Intrfcs.GenericInterface;
import ma.easybanking.main.java.model.DAO.Services.AgencyService;
import ma.easybanking.main.java.model.DTO.Agency;

import java.util.Optional;

public class AgencyDAOImp implements GenericInterface<Agency> {

    private static AgencyService agencyService;

    public AgencyDAOImp(AgencyService agencyService){
        AgencyDAOImp.agencyService = agencyService;
    }

    @Override
    public Agency save(Agency item) {
        return agencyService.saveAgency(item);
    }

    @Override
    public Agency update(Agency item) {
        return null;
    }

    @Override
    public Optional<Agency> findById(Agency item) {
        return agencyService.findAgencyByCode(item);
    }

    @Override
    public Boolean delete(Agency item) {
        return agencyService.deleteAgency(item);
    }
}
