package ma.easybanking.main.java.model.DAO.Services;

import ma.easybanking.main.java.model.DAO.Implmnts.CreditRequestDAOImp;
import ma.easybanking.main.java.model.DTO.CreditRequest;

import java.util.Optional;

public class CreditRequestService {

    private CreditRequestDAOImp creditRequestDAOImp;

    public CreditRequestService(CreditRequestDAOImp creditRequestDAOImp){
        this.creditRequestDAOImp = creditRequestDAOImp;
    }

    public Optional<CreditRequest> saveCreditRequest(CreditRequest creditRequest){
        return creditRequestDAOImp.save(creditRequest);
    }

    public Optional<CreditRequest> findCreditRequestByNbr(CreditRequest creditRequest){
        return creditRequestDAOImp.findById(creditRequest);
    }

}
