package ma.easybanking.main.java.view;

import ma.easybanking.main.java.utils.Attribut;
import ma.easybanking.main.java.utils.Helpers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CreditSimulationView {

    public HashMap<String,String> getCreditInfos(){

        System.out.println("----------------------Simulation de credit--------------------------");

        String[] fields = {"Montant","Mois"};

        List<Attribut> attributs = new ArrayList<>();

        for (String field:fields) {

            Attribut attribut = new Attribut(field);

            if(field.equals("Montant"))
            {
                attribut.setType("amount");
            }

            if(field.equals("Mois"))
            {
                attribut.setType("number");
            }

            attributs.add(attribut);

        }

        HashMap<String,String> filledFields = Helpers.takeInfos(attributs);

        System.out.println("--------------------------------------------------------------------");

        return filledFields;

    }

    public void displaySimulationResults(double monthlypymnt){
        System.out.println("Paiement à faire chaque mois : "+monthlypymnt);
    }

    public boolean validateSimulation(){

        System.out.println("Pour valider la damande de crédit appuyez sur Y sinon appuyez N : ");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input="";

        try {

            do {

                input = reader.readLine();

            }while(!input.equals("Y") && !input.equals("N"));

        }
        catch (Exception e){

        }

        return input.equals("Y");
    }

    public void displaySuccessMsg(String msg){
        Helpers.displaySuccessMsg(msg);
    }

}
