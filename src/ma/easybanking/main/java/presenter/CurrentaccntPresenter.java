package ma.easybanking.main.java.presenter;

import ma.easybanking.main.java.model.CurrentaccntModel;
import ma.easybanking.main.java.model.DTO.Agency;
import ma.easybanking.main.java.model.DTO.Client;
import ma.easybanking.main.java.model.DTO.Currentaccnt;
import ma.easybanking.main.java.model.DTO.Employee;
import ma.easybanking.main.java.view.AgencyView;
import ma.easybanking.main.java.view.ClientView;
import ma.easybanking.main.java.view.CurrentaccntView;
import ma.easybanking.main.java.view.EmployeeView;

import java.util.Optional;

public class CurrentaccntPresenter {

    private CurrentaccntModel currentaccntModel;

    private EmployeeView employeeView;

    private ClientView clientView;

    private AgencyView agencyView;

    private CurrentaccntView currentaccntView;


    public CurrentaccntPresenter(CurrentaccntModel currentaccntModel,
                                 AgencyView agencyView,
                                 EmployeeView employeeView,
                                 ClientView clientView,
                                 CurrentaccntView currentaccntView){

        this.currentaccntModel = currentaccntModel;
        this.agencyView = agencyView;
        this.employeeView = employeeView;
        this.clientView = clientView;
        this.currentaccntView = currentaccntView;
    }

    public void saveCurrentaccnt(){

        Agency agency = agencyView.getAgency("");
        Employee employee = employeeView.getEmployee("");
        Client client = clientView.getClient("");

        double overdraft = currentaccntView.getOverdraft("");

        Optional<Currentaccnt> optionalCurrentaccnt = currentaccntModel.saveCurrentaccnt(new Currentaccnt(agency,employee,client,overdraft));

        if(optionalCurrentaccnt.isPresent())
        {
            currentaccntView.displayCurrentaccnt(optionalCurrentaccnt.get());
        }
        else
        {
            currentaccntView.displayErrorMsg("");

        }

    }

}
