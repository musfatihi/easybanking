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

    private static TransferDAOImp transferDAOImp;

    private static ClientDAOImp clientDAOImp;

    private static CreditRequestDAOImp creditRequestDAOImp;

    //-------------------------Services---------------------------------

    private static AgencyService agencyService;

    private static EmployeeService employeeService;

    private static AgencyEmployeeService agencyEmployeeService;

    private static CurrentaccntService currentaccntService;

    private static SavingsaccntService savingsaccntService;

    private static TransferService transferService;

    private static ClientService clientService;

    private static CreditRequestService creditRequestService;


    //-------------------------Models------------------------------------

    private static AgencyModel agencyModel;

    private static EmployeeModel employeeModel;

    private static AgencyEmployeeModel agencyEmployeeModel;

    private static CurrentaccntModel currentaccntModel;

    private static SavingsaccntModel savingsaccntModel;

    private static TransferModel transferModel;

    private static ClientModel clientModel;

    private static CreditRequestModel creditRequestModel;

    //-------------------------Views-------------------------------------

    private static AgencyView agencyView;

    private static EmployeeView employeeView;

    private static ClientView clientView;

    private static CurrentaccntView currentaccntView;

    private static SavingsaccntView savingsaccntView;

    private static CreditSimulationView creditSimulationView;

    private static TransferView tranferView;

    private static CreditRequestView creditRequestView;

    private static AgencyEmployeeView agencyEmployeeView;

    //-------------------------Presenters---------------------------------

    private static AgencyPresenter agencyPresenter;

    private static EmployeePresenter employeePresenter;

    private static AgencyEmployeePresenter agencyEmployeePresenter;

    private static CurrentaccntPresenter currentaccntPresenter;

    private static SavingsaccntPresenter savingsaccntPresenter;

    private static CreditSimulationPresenter creditSimulationPresenter;

    private static TransferPresenter transferPresenter;

    private static ClientPresenter clientPresenter;

    private static CreditRequestPresenter creditRequestPresenter;


    private static String[] options = {
            "Ajouter une Agence",
            "Supprimer une Agence",
            "Trouver une Agence par code",
            "Ajouter un Employé",
            "Affecter un Employé à une Agence",
            "Créer un Compte Courant",
            "Créer un Compte d'epargne",
            "Faire une simulation de crédit",
            "Lancer un Virement",
            "Supprimer un Virement",
            "Ajouter un Client",
            "Chercher un Client",
            "Chercher une Demande de Crédit",
            "Chercher une Agence par Adresse",
            "Muter un employé",
            "Afficher toutes les demandes de crédit",
            "Changer l'état d'une demande de crédit",
            "Filtrer les demandes de crédit",
            "Mettre à jour une Agence",
            "Liste de Contacts",
            "Chercher une Agence par employé",
            "Historiques"
    };

    public static void start(){

        Connection connection = DBConnection.makeConnection();

        //-----------------------DAOs Implmnts------------------------------

        agencyDAOImp = new AgencyDAOImp(connection);

        employeeDAOImp = new EmployeeDAOImp(connection);

        agencyEmployeeDAOImp = new AgencyEmployeeDAOImp(connection);

        currentaccntDAOImp = new CurrentaccntDAOImp(connection);

        savingsaccntDAOImp = new SavingsaccntDAOImp(connection);

        transferDAOImp = new TransferDAOImp(connection);

        clientDAOImp = new ClientDAOImp(connection);

        creditRequestDAOImp = new CreditRequestDAOImp(connection);

        //-------------------------Services---------------------------------

        agencyService = new AgencyService(agencyDAOImp);

        employeeService = new EmployeeService(employeeDAOImp);

        agencyEmployeeService = new AgencyEmployeeService(agencyEmployeeDAOImp);

        currentaccntService = new CurrentaccntService(currentaccntDAOImp);

        savingsaccntService = new SavingsaccntService(savingsaccntDAOImp);

        transferService = new TransferService(transferDAOImp);

        clientService = new ClientService(clientDAOImp);

        creditRequestService = new CreditRequestService(creditRequestDAOImp);

        //-------------------------Models------------------------------------

        agencyModel = new AgencyModel(agencyService);

        employeeModel = new EmployeeModel(employeeService);

        agencyEmployeeModel = new AgencyEmployeeModel(agencyEmployeeService);

        currentaccntModel = new CurrentaccntModel(currentaccntService);

        savingsaccntModel = new SavingsaccntModel(savingsaccntService);

        transferModel = new TransferModel(transferService);

        clientModel = new ClientModel(clientService);

        creditRequestModel = new CreditRequestModel(creditRequestService);

        //-------------------------Views-------------------------------------

        agencyView = new AgencyView();
        employeeView = new EmployeeView();
        clientView = new ClientView();
        currentaccntView = new CurrentaccntView();
        savingsaccntView = new SavingsaccntView();
        creditSimulationView = new CreditSimulationView();
        tranferView = new TransferView();
        creditRequestView = new CreditRequestView();
        agencyEmployeeView = new AgencyEmployeeView();

        //-------------------------Presenters---------------------------------

        agencyPresenter = new AgencyPresenter(agencyView,agencyModel,employeeView);
        employeePresenter = new EmployeePresenter(employeeView,employeeModel);
        agencyEmployeePresenter = new AgencyEmployeePresenter(agencyEmployeeModel,employeeView,agencyView,agencyEmployeeView);
        currentaccntPresenter = new CurrentaccntPresenter(currentaccntModel,agencyView,employeeView,clientView,currentaccntView);
        savingsaccntPresenter = new SavingsaccntPresenter(savingsaccntModel,agencyView,employeeView,clientView,savingsaccntView);
        transferPresenter = new TransferPresenter(transferModel,tranferView);
        clientPresenter = new ClientPresenter(clientModel,clientView);
        creditRequestPresenter = new CreditRequestPresenter(creditRequestModel,creditRequestView);
        creditSimulationPresenter = new CreditSimulationPresenter(creditSimulationView,creditRequestPresenter);

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
            case 9:
                transferPresenter.saveTransfer();
                break;
            case 10:
                transferPresenter.deleteTransfer();
                break;
            case 11:
                clientPresenter.saveClient();
                break;
            case 12:
                clientPresenter.findClientByCode();
                break;
            case 13:
                creditRequestPresenter.findCreditRequestByNbr();
                break;
            case 14:
                agencyPresenter.findAgencyByAddress();
                break;
            case 15:
                agencyEmployeePresenter.assignEmployeeAgency();
                break;
            case 16:
                creditRequestPresenter.findAllCreditRequests();
                break;
            case 17:
                creditRequestPresenter.changeCreditRequestState();
                break;
            case 18:
                creditRequestPresenter.filterCreditRequests();
                break;
            case 19:
                agencyPresenter.updateAgency();
                break;
            case 20:
                agencyPresenter.findAllAgencies();
                break;
            case 21:
                agencyPresenter.findAgencyByEmpMtrcl();
                break;
            case 22:
                agencyEmployeePresenter.employeeHistory();
                break;
            default:
                break;
        }

    }



}
