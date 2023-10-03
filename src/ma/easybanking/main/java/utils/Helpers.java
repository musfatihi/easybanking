package ma.easybanking.main.java.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;

public class Helpers {

    public static HashMap<String,String> takeInfos(List<Attribut> attributs){

        HashMap<String,String> filledFields = new HashMap<String, String>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input="";

        for (Attribut attribut:attributs) {

            do{
                System.out.println("Entrez "+attribut.getName());

                try {

                    input = reader.readLine();


                }catch (Exception e){

                }

            }while (attribut.isMandatory() && input.equals(""));


            filledFields.put(attribut.getName(),input);

        }

        return filledFields;

    }

    //Check if Input is A Number
    public static Boolean isNumber(String str){

        try {

            for (int i = 0; i < str.length();i++) {

                Integer.parseInt(str.substring(i,i+1));

            }

        }
        catch(NumberFormatException e){

            displayErrorMsg("Not A Number!!");

            return false;

        }

        return true;

    }

    //Display Success Message
    public static void displaySuccessMsg(String msg){
        System.out.print("\u001B[32m");
        System.out.println(msg);
        System.out.print("\u001B[0m");
    }

    //Display Error Message
    public static void displayErrorMsg(String msg){
        System.out.print("\u001B[31m");
        System.out.println(msg);
        System.out.print("\u001B[0m");
    }



}
