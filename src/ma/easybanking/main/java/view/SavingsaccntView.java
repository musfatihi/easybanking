package ma.easybanking.main.java.view;

import ma.easybanking.main.java.model.DTO.Savingsaccnt;
import ma.easybanking.main.java.utils.Attribut;
import ma.easybanking.main.java.utils.Helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SavingsaccntView {

    public double getInterestRate(String title)
    {
        System.out.println("----------------------"+title+"--------------------------");

        String[] fields = {"InterestRate"};

        List<Attribut> attributs = new ArrayList<>();

        for (String field:fields) {

            Attribut attribut = new Attribut(field);

            attribut.setType("percentage");

            attributs.add(attribut);

        }


        HashMap<String,String> filledFields = Helpers.takeInfos(attributs);

        System.out.println("--------------------------------------------------------------------");

        return Double.parseDouble(filledFields.get("InterestRate"));

    }

    public void displaySavingsaccnt(Savingsaccnt savingsaccnt)
    {
        System.out.println(savingsaccnt);
    }

    public void displayErrorMsg(String msg){
        Helpers.displayErrorMsg(msg);
    }

}
