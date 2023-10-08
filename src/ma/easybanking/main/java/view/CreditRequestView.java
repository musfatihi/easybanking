package ma.easybanking.main.java.view;

import ma.easybanking.main.java.model.CreditRequestModel;
import ma.easybanking.main.java.model.DTO.Agency;
import ma.easybanking.main.java.model.DTO.CRState;
import ma.easybanking.main.java.model.DTO.Client;
import ma.easybanking.main.java.model.DTO.CreditRequest;
import ma.easybanking.main.java.utils.Attribut;
import ma.easybanking.main.java.utils.Helpers;

import java.time.LocalDate;
import java.util.*;

public class CreditRequestView {

    public CreditRequest getCreditRequestInfos(double amount,int duration){

        System.out.println("------------------------------------------------");

        String[] fields = {"Code Client","Code Agence","Notes"};

        List<Attribut> attributs = new ArrayList<>();

        for (String field:fields) {

            Attribut attribut = new Attribut(field);

            if(field.equals("Code Client") || field.equals("Code Agence"))
            {
                attribut.setType("number");
            }

            attributs.add(attribut);

        }

        HashMap<String,String> filledFields = Helpers.takeInfos(attributs);

        System.out.println("--------------------------------------------------------------------");

        return new CreditRequest(new Agency(Integer.valueOf(filledFields.get("Code Agence"))),new Client(Integer.valueOf(filledFields.get("Code Client"))),amount,duration,filledFields.get("Notes"));

    }

    public CreditRequest getCreditRequestNbr(){

        System.out.println("------------------------------------------------");

        String[] fields = {"Numero Demande de Credit"};

        List<Attribut> attributs = new ArrayList<>();

        for (String field:fields) {

            Attribut attribut = new Attribut(field);

            attribut.setType("number");

            attributs.add(attribut);

        }

        HashMap<String,String> filledFields = Helpers.takeInfos(attributs);

        System.out.println("--------------------------------------------------------------------");

        return new CreditRequest(Integer.valueOf(filledFields.get("Numero Demande de Credit")));
    }

    public CRState getCreditRequestNewState(){

        System.out.println("------------------------------------------------");

        String[] fields = {"Nouveau etat"};

        List<Attribut> attributs = new ArrayList<>();

        for (String field:fields) {

            Attribut attribut = new Attribut(field);

            attribut.setType("crstate");

            attributs.add(attribut);

        }

        HashMap<String,String> filledFields = Helpers.takeInfos(attributs);

        System.out.println("--------------------------------------------------------------------");

        return CRState.valueOf(filledFields.get("Nouveau etat"));
    }
    public void displayCreditRequest(CreditRequest creditRequest){
        System.out.println(creditRequest);
    }

    public void displayCreditRequests(List<CreditRequest> creditRequests){
        for (CreditRequest creditRequest:creditRequests) {
            System.out.println(creditRequest);
        }
    }

    public void displayCreditRequestsByState(Map<CRState,List<CreditRequest>> creditRequests){
        for (Map.Entry<CRState, List<CreditRequest>> entry : creditRequests.entrySet()) {
            System.out.println(entry.getKey());
            displayCreditRequests(entry.getValue());
        }

    }

    public void displayCreditRequestsByDate(Map<LocalDate,List<CreditRequest>> creditRequests){

        for (Map.Entry<LocalDate, List<CreditRequest>> entry : creditRequests.entrySet()) {
            System.out.println(entry.getKey());
            displayCreditRequests(entry.getValue());
        }
    }

    public void displaySuccessMsg(String msg){
        Helpers.displaySuccessMsg(msg);
    }

    public String getFilter(){

        String[] options = {"state", "date"};

        showOptions(options);

        int choice = takeInput(1, options.length);

        return options[choice-1];

    }

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

    private void showOptions(String[] options){
        int i=1;
        for (String option : options) {
            System.out.println(i+" "+option);
            i++;
        }
    }

}

