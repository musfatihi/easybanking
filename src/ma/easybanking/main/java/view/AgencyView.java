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

            if(field.equals("Nom") || field.equals("Adresse") || field.equals("N Tel")){
                attribut.setMandatory();
            }

            attributs.add(attribut);

        }


        HashMap<String,String> filledFields = Helpers.takeInfos(attributs);

        System.out.println("--------------------------------------------------------------------");

        return new Agency(filledFields.get("Nom"),filledFields.get("Adresse"),filledFields.get("N Tel"));

    }

    public Agency getAgency(){

        System.out.println("----------------------Suppression d'une Agence--------------------------");

        String[] fields = {"Code Agence"};

        List<Attribut> attributs = new ArrayList<>();

        for (String field:fields) {

            Attribut attribut = new Attribut(field);

            attributs.add(attribut);

        }


        HashMap<String,String> filledFields = Helpers.takeInfos(attributs);

        System.out.println("--------------------------------------------------------------------");

        return new Agency(Integer.valueOf(filledFields.get("Code Agence")));

    }

    public void displayAgency(Agency agency){
        System.out.println(agency);
    }

    public void displaySuccessMsg(String msg){
        Helpers.displaySuccessMsg(msg);
    }

    public void displayErrorMsg(String msg){
        Helpers.displayErrorMsg(msg);
    }


}
