package ma.easybanking.main.java.model.DAO.Services;

import ma.easybanking.main.java.model.DAO.Implmnts.SavingsaccntDAOImp;
import ma.easybanking.main.java.model.DTO.Savingsaccnt;

import java.util.Optional;

public class SavingsaccntService {

    private SavingsaccntDAOImp savingsaccntDAOImp;

    public SavingsaccntService(SavingsaccntDAOImp savingsaccntDAOImp){
        this.savingsaccntDAOImp = savingsaccntDAOImp;
    }

    public Optional<Savingsaccnt> saveSavingsaccnt(Savingsaccnt savingsaccnt)
    {
        return savingsaccntDAOImp.save(savingsaccnt);
    }

}
