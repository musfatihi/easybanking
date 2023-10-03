package ma.easybanking.main.java.presenter;

import ma.easybanking.main.java.database.DBConnection;
import ma.easybanking.main.java.model.AgencyModel;
import ma.easybanking.main.java.model.DAO.Implmnts.AgencyDAOImp;
import ma.easybanking.main.java.model.DAO.Services.AgencyService;
import ma.easybanking.main.java.utils.Helpers;
import ma.easybanking.main.java.view.AgencyView;

import java.sql.Connection;
import java.util.Scanner;

public class App {

    //-------------------------Services---------------------------------

    private static AgencyService agencyService;

    //------------------------DAOs Implmnts------------------------------

    private static AgencyDAOImp agencyDAOImp;

    //-------------------------Models------------------------------------

    private static AgencyModel agencyModel;

    //-------------------------Views-------------------------------------

    private static AgencyView agencyView;

    //-------------------------Presenters---------------------------------

    private static AgencyPresenter agencyPresenter;


    private static String[] options = {
            "Ajouter une Agence",
            "Supprimer une Agence"
    };

    public static void start(){

        Connection connection = DBConnection.makeConnection();


        //-------------------------Services---------------------------------

        agencyService = new AgencyService(connection);

        //-----------------------DAOs Implmnts------------------------------

        agencyDAOImp = new AgencyDAOImp(agencyService);

        //-------------------------Models------------------------------------

        agencyModel = new AgencyModel(agencyDAOImp);

        //-------------------------Views-------------------------------------

        agencyView = new AgencyView();

        //-------------------------Presenters---------------------------------

        agencyPresenter = new AgencyPresenter(agencyView,agencyModel);



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
            default:
                break;
        }

    }



}
