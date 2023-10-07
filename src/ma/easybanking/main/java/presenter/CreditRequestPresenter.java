package ma.easybanking.main.java.presenter;

import ma.easybanking.main.java.model.CreditRequestModel;
import ma.easybanking.main.java.model.DTO.CreditRequest;
import ma.easybanking.main.java.model.DTO.Operation;
import ma.easybanking.main.java.view.CreditRequestView;

import java.util.Optional;

public class CreditRequestPresenter {

    private CreditRequestModel creditRequestModel;
    private CreditRequestView creditRequestView;


    public CreditRequestPresenter(CreditRequestModel creditRequestModel,CreditRequestView creditRequestView)
    {
        this.creditRequestModel = creditRequestModel;
        this.creditRequestView = creditRequestView;
    }


    public void saveCreditRequest(double amount,int duration){

        Optional<CreditRequest> optionalCreditRequest = creditRequestModel.saveCreditRequest(creditRequestView.getCreditRequestInfos(amount,duration));

        if(optionalCreditRequest.isPresent())
        {
            creditRequestView.displayCreditRequest(optionalCreditRequest.get());

            creditRequestView.displaySuccessMsg("Votre demande de crédit a été bien enregistrée");

        }else{

        }

    }

}
