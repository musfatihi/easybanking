package ma.easybanking.main.java.view;

import ma.easybanking.main.java.model.DTO.Account;
import ma.easybanking.main.java.model.DTO.Transfer;
import ma.easybanking.main.java.utils.Attribut;
import ma.easybanking.main.java.utils.Helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TransferView {

    public Transfer getTranferInfos(String title){

        System.out.println("----------------------"+title+"--------------------------");

        String[] fields = {"Montant","Compte Source","Compte Destination"};

        List<Attribut> attributs = new ArrayList<>();

        for (String field:fields) {

            Attribut attribut = new Attribut(field);

            if(attribut.equals("Montant"))
            {
                attribut.setType("amount");
            }else
            {
                attribut.setType("number");
            }

            attributs.add(attribut);

        }


        HashMap<String,String> filledFields = Helpers.takeInfos(attributs);

        System.out.println("--------------------------------------------------------------------");

        return new Transfer(Double.parseDouble(filledFields.get("Montant")),new Account(Integer.valueOf(filledFields.get("Compte Source"))),new Account(Integer.valueOf(filledFields.get("Compte Destination"))));

    }

    public Transfer getTrnsferCode(String title)
    {
        System.out.println("----------------------"+title+"--------------------------");

        String[] fields = {"Numero de Virement"};

        List<Attribut> attributs = new ArrayList<>();

        for (String field:fields) {

            Attribut attribut = new Attribut(field);

            attribut.setType("number");

            attributs.add(attribut);

        }


        HashMap<String,String> filledFields = Helpers.takeInfos(attributs);

        System.out.println("--------------------------------------------------------------------");

        return new Transfer(Integer.valueOf(filledFields.get("Numero de Virement")));

    }

    public void displayTransfer(Transfer transfer){
        System.out.println(transfer);
    }

    public void displayErrorMsg(String msg){
        Helpers.displayErrorMsg(msg);
    }

    public void displaySuccessMsg(String msg){Helpers.displaySuccessMsg(msg);}

}
