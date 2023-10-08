package ma.easybanking.main.java.presenter;

import ma.easybanking.main.java.model.CreditRequestModel;
import ma.easybanking.main.java.model.DTO.CreditRequest;
import ma.easybanking.main.java.model.DTO.Operation;
import ma.easybanking.main.java.view.CreditRequestView;

import java.util.List;
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

    public void findCreditRequestByNbr(){

        Optional<CreditRequest> optionalCreditRequest = creditRequestModel.findCreditRequestByNbr(creditRequestView.getCreditRequestNbr());

        if(optionalCreditRequest.isPresent())
        {
            creditRequestView.displayCreditRequest(optionalCreditRequest.get());
        }
        else
        {

        }

    }

    public void findAllCreditRequests(){
        List<CreditRequest> creditRequests = creditRequestModel.findAllCreditRequests();
        creditRequestView.displayCreditRequests(creditRequests);
    }

    public void changeCreditRequestState(){
        if(creditRequestModel.changeCreditRequestState(creditRequestView.getCreditRequestNbr(),creditRequestView.getCreditRequestNewState()))
        {
            creditRequestView.displaySuccessMsg("L'état de demande de crédit a été changé avec succès");
        }
    }

    public void filterCreditRequests(){
        System.out.println("----------------------Filtrer les demandes de crédit--------------------------");

        if(creditRequestView.getFilter().equals("state")){
            creditRequestView.displayCreditRequestsByState(creditRequestModel.findCreditRequestsByState());
        }else{
            creditRequestView.displayCreditRequestsByDate(creditRequestModel.findCreditRequestsByDate());
        }
    }

}
