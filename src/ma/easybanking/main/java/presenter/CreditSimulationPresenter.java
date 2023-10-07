package ma.easybanking.main.java.presenter;

import ma.easybanking.main.java.view.CreditSimulationView;

import java.util.HashMap;

public class CreditSimulationPresenter {

    private double interests=0.12;

    private CreditSimulationView creditSimulationView;

    private CreditRequestPresenter creditRequestPresenter;

    public CreditSimulationPresenter(CreditSimulationView creditSimulationView,CreditRequestPresenter creditRequestPresenter){
        this.creditSimulationView = creditSimulationView;
        this.creditRequestPresenter = creditRequestPresenter;
    }

    public void simulateCredit(){

        HashMap<String,String> creditInfos = creditSimulationView.getCreditInfos();

        double monthlypymnt = ((Double.parseDouble(creditInfos.get("Montant"))*(this.interests/12))/(1-Math.pow((1+(this.interests/12)),-Integer.valueOf(creditInfos.get("Mois")))));

        creditSimulationView.displaySimulationResults(monthlypymnt);

        if(creditSimulationView.validateSimulation())
        {
            creditRequestPresenter.saveCreditRequest(Double.parseDouble(creditInfos.get("Montant")),Integer.valueOf(creditInfos.get("Mois")));

        }

    }


}
