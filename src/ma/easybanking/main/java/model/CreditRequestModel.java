package ma.easybanking.main.java.model;

import ma.easybanking.main.java.model.DAO.Services.CreditRequestService;
import ma.easybanking.main.java.model.DTO.CreditRequest;

import java.util.Optional;

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

}
