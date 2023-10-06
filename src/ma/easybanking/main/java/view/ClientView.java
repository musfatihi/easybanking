package ma.easybanking.main.java.view;

import ma.easybanking.main.java.model.DTO.Agency;
import ma.easybanking.main.java.model.DTO.Client;
import ma.easybanking.main.java.model.DTO.Employee;
import ma.easybanking.main.java.utils.Attribut;
import ma.easybanking.main.java.utils.Helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ClientView {

    public Client getClient(String title){

        System.out.println("----------------------"+title+"--------------------------");

        String[] fields = {"Code Client"};

        List<Attribut> attributs = new ArrayList<>();

        for (String field:fields) {

            Attribut attribut = new Attribut(field);

            attribut.setType("number");

            attributs.add(attribut);

        }

        HashMap<String,String> filledFields = Helpers.takeInfos(attributs);

        System.out.println("--------------------------------------------------------------------");

        return new Client(Integer.valueOf(filledFields.get("Code Client")));

    }

    public Client saveClient(){

        System.out.println("----------------------Ajout d'un client--------------------------");

        String[] fields = {"Prenom", "Nom", "Date de naissance", "Adresse", "N Tel"};

        List<Attribut> attributs = new ArrayList<>();

        for (String field:fields) {

            Attribut attribut = new Attribut(field);


            if(field.equals("Date de naissance") || field.equals("Date de recrutement")){
                attribut.setType("date");
            }

            if(field.equals("N Tel")){
                attribut.setType("tel");
            }

            attributs.add(attribut);

        }

        HashMap<String,String> filledFields = Helpers.takeInfos(attributs);

        return new Client(filledFields.get("Prenom"),filledFields.get("Nom"), Helpers.strToDate(filledFields.get("Date de naissance")),filledFields.get("Adresse"),
                filledFields.get("N Tel"));


    }


    public void displayClient(Client client){
        System.out.println(client);
    }

    public void displayErrorMsg(String msg){
        Helpers.displayErrorMsg(msg);
    }

}
