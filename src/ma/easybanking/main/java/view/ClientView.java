package ma.easybanking.main.java.view;

import ma.easybanking.main.java.model.DTO.Agency;
import ma.easybanking.main.java.model.DTO.Client;
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

}
