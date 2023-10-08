package ma.easybanking.main.java.model;

import ma.easybanking.main.java.model.DAO.Services.CreditRequestService;
import ma.easybanking.main.java.model.DTO.CRState;
import ma.easybanking.main.java.model.DTO.CreditRequest;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class CreditRequestModel {
    private CreditRequestService creditRequestService;

    public CreditRequestModel(CreditRequestService creditRequestService)
    {
        this.creditRequestService = creditRequestService;
    }

    public Optional<CreditRequest> saveCreditRequest(CreditRequest creditRequest)
    {
        return creditRequestService.saveCreditRequest(creditRequest);
    }

    public Optional<CreditRequest> findCreditRequestByNbr(CreditRequest creditRequest)
    {
        return creditRequestService.findCreditRequestByNbr(creditRequest);
    }

    public List<CreditRequest> findAllCreditRequests()
    {
        return creditRequestService.findAllCreditRequests();
    }

    public boolean changeCreditRequestState(CreditRequest creditRequest, CRState crState){
        return creditRequestService.changeCreditRequestState(creditRequest,crState);
    }

    public Map<CRState,List<CreditRequest>> findCreditRequestsByState()
    {
        return creditRequestService.findAllCreditRequests().stream()
                .collect(Collectors.groupingBy(
                        CreditRequest::getCrstate
                ));
    }

    public Map<LocalDate,List<CreditRequest>> findCreditRequestsByDate()
    {
        return creditRequestService.findAllCreditRequests().stream()
                .collect(Collectors.groupingBy(
                        CreditRequest::getCrtDate
                ));
    }

}
