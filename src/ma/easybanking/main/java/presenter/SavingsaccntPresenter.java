package ma.easybanking.main.java.presenter;

import ma.easybanking.main.java.model.CurrentaccntModel;
import ma.easybanking.main.java.model.DTO.*;
import ma.easybanking.main.java.model.SavingsaccntModel;
import ma.easybanking.main.java.view.*;

import java.util.Optional;

public class SavingsaccntPresenter {

    private SavingsaccntModel savingsaccntModel;

    private EmployeeView employeeView;

    private ClientView clientView;

    private AgencyView agencyView;

    private SavingsaccntView savingsaccntView;

    public SavingsaccntPresenter(SavingsaccntModel savingsaccntModel,
                                 AgencyView agencyView,
                                 EmployeeView employeeView,
                                 ClientView clientView,
                                 SavingsaccntView savingsaccntView)
    {

        this.savingsaccntModel = savingsaccntModel;
        this.agencyView = agencyView;
        this.employeeView = employeeView;
        this.clientView = clientView;
        this.savingsaccntView = savingsaccntView;
    }

    public void saveSavingsaccnt(){

        Agency agency = agencyView.getAgency("");
        Employee employee = employeeView.getEmployee("");
        Client client = clientView.getClient("");

        double interestrate = savingsaccntView.getInterestRate("");

        Optional<Savingsaccnt> optionalSavingsaccnt = savingsaccntModel.saveSavingsaccnt(new Savingsaccnt(agency,employee,client,interestrate));

        if(optionalSavingsaccnt.isPresent())
        {
            savingsaccntView.displaySavingsaccnt(optionalSavingsaccnt.get());
        }
        else
        {
            savingsaccntView.displayErrorMsg("");

        }

    }

}
