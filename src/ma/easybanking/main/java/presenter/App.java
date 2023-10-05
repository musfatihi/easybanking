package ma.easybanking.main.java.presenter;

import ma.easybanking.main.java.database.DBConnection;
import ma.easybanking.main.java.model.AgencyEmployeeModel;
import ma.easybanking.main.java.model.AgencyModel;
import ma.easybanking.main.java.model.DAO.Implmnts.AgencyDAOImp;
import ma.easybanking.main.java.model.DAO.Implmnts.AgencyEmployeeDAOImp;
import ma.easybanking.main.java.model.DAO.Implmnts.EmployeeDAOImp;
import ma.easybanking.main.java.model.DAO.Services.AgencyEmployeeService;
import ma.easybanking.main.java.model.DAO.Services.AgencyService;
import ma.easybanking.main.java.model.DAO.Services.EmployeeService;
import ma.easybanking.main.java.model.EmployeeModel;
import ma.easybanking.main.java.utils.Helpers;
import ma.easybanking.main.java.view.AgencyView;
import ma.easybanking.main.java.view.EmployeeView;

import java.sql.Connection;
import java.util.Scanner;

public class App {

    //------------------------DAOs Implmnts------------------------------

    private static AgencyDAOImp agencyDAOImp;

    private static EmployeeDAOImp employeeDAOImp;

    private static AgencyEmployeeDAOImp agencyEmployeeDAOImp;

    //-------------------------Services---------------------------------

    private static AgencyService agencyService;

    private static EmployeeService employeeService;

    private static AgencyEmployeeService agencyEmployeeService;


    //-------------------------Models------------------------------------

    private static AgencyModel agencyModel;

    private static EmployeeModel employeeModel;

    private static AgencyEmployeeModel agencyEmployeeModel;

    //-------------------------Views-------------------------------------

    private static AgencyView agencyView;

    private static EmployeeView employeeView;

    //-------------------------Presenters---------------------------------

    private static AgencyPresenter agencyPresenter;

    private static EmployeePresenter employeePresenter;

    private static AgencyEmployeePresenter agencyEmployeePresenter;


    private static String[] options = {
            "Ajouter une Agence",
            "Supprimer une Agence",
            "Trouver une Agence par code",
            "Ajouter un Employé",
            "Affecter un Employé à une agence"
    };

    public static void start(){

        Connection connection = DBConnection.makeConnection();

        //-----------------------DAOs Implmnts------------------------------

        agencyDAOImp = new AgencyDAOImp(connection);

        employeeDAOImp = new EmployeeDAOImp(connection);

        agencyEmployeeDAOImp = new AgencyEmployeeDAOImp(connection);


        //-------------------------Services---------------------------------

        agencyService = new AgencyService(agencyDAOImp);

        employeeService = new EmployeeService(employeeDAOImp);

        agencyEmployeeService = new AgencyEmployeeService(agencyEmployeeDAOImp);

        //-------------------------Models------------------------------------

        agencyModel = new AgencyModel(agencyService);

        employeeModel = new EmployeeModel(employeeService);

        agencyEmployeeModel = new AgencyEmployeeModel(agencyEmployeeService);

        //-------------------------Views-------------------------------------

        agencyView = new AgencyView();
        employeeView = new EmployeeView();

        //-------------------------Presenters---------------------------------

        agencyPresenter = new AgencyPresenter(agencyView,agencyModel);
        employeePresenter = new EmployeePresenter(employeeView,employeeModel);
        agencyEmployeePresenter = new AgencyEmployeePresenter(agencyEmployeeModel,employeeView,agencyView);



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
            default:
                break;
        }

    }



}
