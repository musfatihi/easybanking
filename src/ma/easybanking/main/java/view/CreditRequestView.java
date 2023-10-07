package ma.easybanking.main.java.view;

import ma.easybanking.main.java.model.CreditRequestModel;
import ma.easybanking.main.java.model.DTO.Agency;
import ma.easybanking.main.java.model.DTO.Client;
import ma.easybanking.main.java.model.DTO.CreditRequest;
import ma.easybanking.main.java.utils.Attribut;
import ma.easybanking.main.java.utils.Helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    public void displayCreditRequest(CreditRequest creditRequest){
        System.out.println(creditRequest);
    }

    public void displaySuccessMsg(String msg){
        Helpers.displaySuccessMsg(msg);
    }


}
