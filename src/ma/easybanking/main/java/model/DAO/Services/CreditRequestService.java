package ma.easybanking.main.java.model.DAO.Services;

import ma.easybanking.main.java.model.DAO.Implmnts.CreditRequestDAOImp;
import ma.easybanking.main.java.model.DTO.CRState;
import ma.easybanking.main.java.model.DTO.CreditRequest;

import java.util.List;
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

    public List<CreditRequest> findAllCreditRequests(){
        return creditRequestDAOImp.findAll();
    }

    public boolean changeCreditRequestState(CreditRequest creditRequest, CRState crState){
        return creditRequestDAOImp.changeState(creditRequest.getNbr(),crState.name());
    }

}
