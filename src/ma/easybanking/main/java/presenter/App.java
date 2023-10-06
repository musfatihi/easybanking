package ma.easybanking.main.java.presenter;

import ma.easybanking.main.java.database.DBConnection;
import ma.easybanking.main.java.model.*;
import ma.easybanking.main.java.model.DAO.Implmnts.*;
import ma.easybanking.main.java.model.DAO.Services.*;
import ma.easybanking.main.java.utils.Helpers;
import ma.easybanking.main.java.view.*;

import java.sql.Connection;
import java.util.Scanner;

public class App {

    //------------------------DAOs Implmnts------------------------------

    private static AgencyDAOImp agencyDAOImp;

    private static EmployeeDAOImp employeeDAOImp;

    private static AgencyEmployeeDAOImp agencyEmployeeDAOImp;

    private static CurrentaccntDAOImp currentaccntDAOImp;

    private static SavingsaccntDAOImp savingsaccntDAOImp;

    //-------------------------Services---------------------------------

    private static AgencyService agencyService;

    private static EmployeeService employeeService;

    private static AgencyEmployeeService agencyEmployeeService;

    private static CurrentaccntService currentaccntService;

    private static SavingsaccntService savingsaccntService;


    //-------------------------Models------------------------------------

    private static AgencyModel agencyModel;

    private static EmployeeModel employeeModel;

    private static AgencyEmployeeModel agencyEmployeeModel;

    private static CurrentaccntModel currentaccntModel;

    private static SavingsaccntModel savingsaccntModel;

    //-------------------------Views-------------------------------------

    private static AgencyView agencyView;

    private static EmployeeView employeeView;

    private static ClientView clientView;

    private static CurrentaccntView currentaccntView;

    private static SavingsaccntView savingsaccntView;

    private static CreditSimulationView creditSimulationView;


    //-------------------------Presenters---------------------------------

    private static AgencyPresenter agencyPresenter;

    private static EmployeePresenter employeePresenter;

    private static AgencyEmployeePresenter agencyEmployeePresenter;

    private static CurrentaccntPresenter currentaccntPresenter;

    private static SavingsaccntPresenter savingsaccntPresenter;

    private static CreditSimulationPresenter creditSimulationPresenter;


    private static String[] options = {
            "Ajouter une Agence",
            "Supprimer une Agence",
            "Trouver une Agence par code",
            "Ajouter un Employé",
            "Affecter un Employé à une Agence",
            "Créer un Compte Courant",
            "Créer un Compte d'epargne",
            "Faire une simulation de crédit"
    };

    public static void start(){

        Connection connection = DBConnection.makeConnection();

        //-----------------------DAOs Implmnts------------------------------

        agencyDAOImp = new AgencyDAOImp(connection);

        employeeDAOImp = new EmployeeDAOImp(connection);

        agencyEmployeeDAOImp = new AgencyEmployeeDAOImp(connection);

        currentaccntDAOImp = new CurrentaccntDAOImp(connection);

        savingsaccntDAOImp = new SavingsaccntDAOImp(connection);


        //-------------------------Services---------------------------------

        agencyService = new AgencyService(agencyDAOImp);

        employeeService = new EmployeeService(employeeDAOImp);

        agencyEmployeeService = new AgencyEmployeeService(agencyEmployeeDAOImp);

        currentaccntService = new CurrentaccntService(currentaccntDAOImp);

        savingsaccntService = new SavingsaccntService(savingsaccntDAOImp);

        //-------------------------Models------------------------------------

        agencyModel = new AgencyModel(agencyService);

        employeeModel = new EmployeeModel(employeeService);

        agencyEmployeeModel = new AgencyEmployeeModel(agencyEmployeeService);

        currentaccntModel = new CurrentaccntModel(currentaccntService);

        savingsaccntModel = new SavingsaccntModel(savingsaccntService);

        //-------------------------Views-------------------------------------

        agencyView = new AgencyView();
        employeeView = new EmployeeView();
        clientView = new ClientView();
        currentaccntView = new CurrentaccntView();
        savingsaccntView = new SavingsaccntView();

        creditSimulationView = new CreditSimulationView();

        //-------------------------Presenters---------------------------------

        agencyPresenter = new AgencyPresenter(agencyView,agencyModel);
        employeePresenter = new EmployeePresenter(employeeView,employeeModel);
        agencyEmployeePresenter = new AgencyEmployeePresenter(agencyEmployeeModel,employeeView,agencyView);
        currentaccntPresenter = new CurrentaccntPresenter(currentaccntModel,agencyView,employeeView,clientView,currentaccntView);
        savingsaccntPresenter = new SavingsaccntPresenter(savingsaccntModel,agencyView,employeeView,clientView,savingsaccntView);

        creditSimulationPresenter = new CreditSimulationPresenter(creditSimulationView);



        while(true){

            showOptions(options);

            int choice = takeInput(1,options.length);

            treatement(choice);

        }

    }

    private static void showOptions(String[] options){
        int i=1;
        for (String option : options) {
            System.out.println(i+" "+option);
            i++;
        }
    }

    // Asking for Input as Choice
    private static int takeInput(int min, int max) {
        String choice;
        Scanner input = new Scanner(System.in);

        while(true)
        {
            System.out.println("Faites un choix : ");

            choice = input.next();

            if(Helpers.isNumber(choice) && Integer.parseInt(choice) >= min && Integer.parseInt(choice) <= max)
            {
                return Integer.parseInt(choice);
            }
            else
            {
                Helpers.displayErrorMsg("Entrée non valide.");

            }

        }

    }



    private static void treatement(int option){

        switch(option) {
            case 1:
                agencyPresenter.saveAgency();
                break;
            case 2:
                agencyPresenter.deleteAgency();
                break;
            case 3:
                agencyPresenter.findAgencyByCode();
                break;
            case 4:
                employeePresenter.saveEmployee();
                break;
            case 5:
                agencyEmployeePresenter.assignEmployeeAgency();
                break;
            case 6:
                currentaccntPresenter.saveCurrentaccnt();
                break;
            case 7:
                savingsaccntPresenter.saveSavingsaccnt();
                break;
            case 8:
                creditSimulationPresenter.simulateCredit();
                break;
            default:
                break;
        }

    }



}
