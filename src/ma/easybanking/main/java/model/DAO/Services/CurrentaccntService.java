package ma.easybanking.main.java.model.DAO.Services;

import ma.easybanking.main.java.model.DAO.Implmnts.CurrentaccntDAOImp;
import ma.easybanking.main.java.model.DTO.Currentaccnt;

import java.util.Optional;

public class CurrentaccntService {
    private CurrentaccntDAOImp currentaccntDAOImp;

    public CurrentaccntService(CurrentaccntDAOImp currentaccntDAOImp)
    {
        this.currentaccntDAOImp = currentaccntDAOImp;
    }

    public Optional<Currentaccnt> saveCurrentaccnt(Currentaccnt currentaccnt){
        return currentaccntDAOImp.save(currentaccnt);
    }

}
