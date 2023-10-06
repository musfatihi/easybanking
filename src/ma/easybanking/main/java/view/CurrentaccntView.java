package ma.easybanking.main.java.view;

import ma.easybanking.main.java.model.DTO.Agency;
import ma.easybanking.main.java.model.DTO.Currentaccnt;
import ma.easybanking.main.java.utils.Attribut;
import ma.easybanking.main.java.utils.Helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CurrentaccntView {

    public double getOverdraft(String title)
    {
        System.out.println("----------------------"+title+"--------------------------");

        String[] fields = {"Overdraft"};

        List<Attribut> attributs = new ArrayList<>();

        for (String field:fields) {

            Attribut attribut = new Attribut(field);

            attribut.setType("amount");

            attributs.add(attribut);

        }


        HashMap<String,String> filledFields = Helpers.takeInfos(attributs);

        System.out.println("--------------------------------------------------------------------");

        return Double.parseDouble(filledFields.get("Overdraft"));

    }



    public void displayCurrentaccnt(Currentaccnt currentaccnt)
    {
        System.out.println(currentaccnt);
    }

    public void displayErrorMsg(String msg)
    {
        Helpers.displayErrorMsg(msg);
    }

}
