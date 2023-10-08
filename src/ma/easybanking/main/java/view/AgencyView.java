package ma.easybanking.main.java.view;

import ma.easybanking.main.java.model.DTO.Agency;
import ma.easybanking.main.java.utils.Attribut;
import ma.easybanking.main.java.utils.Helpers;

import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AgencyView {

    public Agency saveAgency(){

        System.out.println("----------------------Ajout d'une Agence--------------------------");

        String[] fields = {"Nom", "Adresse", "N Tel"};

        List<Attribut> attributs = new ArrayList<>();

        for (String field:fields) {

            Attribut attribut = new Attribut(field);

            attributs.add(attribut);

        }


        HashMap<String,String> filledFields = Helpers.takeInfos(attributs);

        System.out.println("--------------------------------------------------------------------");

        return new Agency(filledFields.get("Nom"),filledFields.get("Adresse"),filledFields.get("N Tel"));

    }

    public Agency getAgency(String title){

        System.out.println("----------------------"+title+"--------------------------");

        String[] fields = {"Code Agence"};

        List<Attribut> attributs = new ArrayList<>();

        for (String field:fields) {

            Attribut attribut = new Attribut(field);

            attribut.setType("number");

            attributs.add(attribut);

        }


        HashMap<String,String> filledFields = Helpers.takeInfos(attributs);

        System.out.println("--------------------------------------------------------------------");

        return new Agency(Integer.valueOf(filledFields.get("Code Agence")));

    }

    public Agency getAgencyAddress(String title){

        System.out.println("----------------------"+title+"--------------------------");

        String[] fields = {"Adresse dAgence"};

        List<Attribut> attributs = new ArrayList<>();

        for (String field:fields) {

            Attribut attribut = new Attribut(field);

            attributs.add(attribut);

        }

        HashMap<String,String> filledFields = Helpers.takeInfos(attributs);

        System.out.println("--------------------------------------------------------------------");

        return new Agency(filledFields.get("Adresse dAgence"));

    }

    public Agency updateAgency(){

        System.out.println("----------------------Modification d'une Agence--------------------------");

        String[] fields = {"Code Agence","Nom", "Adresse", "N Tel"};

        List<Attribut> attributs = new ArrayList<>();

        for (String field:fields) {

            Attribut attribut = new Attribut(field);

            if(field.equals("Code Agence"))
            {
                attribut.setType("number");
            }

            attributs.add(attribut);
        }


        HashMap<String,String> filledFields = Helpers.takeInfos(attributs);

        System.out.println("--------------------------------------------------------------------");

        return new Agency(Integer.valueOf(filledFields.get("Code Agence")),filledFields.get("Nom"),filledFields.get("Adresse"),filledFields.get("N Tel"));

    }








    public void displayAgency(Agency agency){
        System.out.println(agency);
    }

    public void displayAgencies(List<Agency> agencies){

        for (Agency agency:agencies) {
            System.out.println(agency);
        }

    }


    public void displaySuccessMsg(String msg){
        Helpers.displaySuccessMsg(msg);
    }

    public void displayErrorMsg(String msg){
        Helpers.displayErrorMsg(msg);
    }


}
