package ma.easybanking.main.java.view;

import ma.easybanking.main.java.model.DTO.Agency;
import ma.easybanking.main.java.model.DTO.Employee;
import ma.easybanking.main.java.utils.Attribut;
import ma.easybanking.main.java.utils.Helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EmployeeView {

    public Employee saveEmployee(){

        System.out.println("----------------------Ajout d'un employé--------------------------");

        String[] fields = {"Prenom", "Nom", "Date de naissance", "Adresse", "N Tel","Date de recrutement","Adresse Mail"};

        List<Attribut> attributs = new ArrayList<>();

        for (String field:fields) {

            Attribut attribut = new Attribut(field);


            if(field.equals("Date de naissance") || field.equals("Date de recrutement")){
                attribut.setType("date");
            }

            if(field.equals("N Tel")){
                attribut.setType("tel");
            }

            if(field.equals("Adresse Mail")){
                attribut.setType("mail");
            }

            attributs.add(attribut);

        }

        HashMap<String,String> filledFields = Helpers.takeInfos(attributs);

        return new Employee(filledFields.get("Prenom"),filledFields.get("Nom"), Helpers.strToDate(filledFields.get("Date de naissance")),filledFields.get("Adresse"),
                filledFields.get("N Tel"),Helpers.strToDate(filledFields.get("Date de recrutement")),filledFields.get("Adresse Mail"));

    }


    public Employee getEmployee(String title){

        System.out.println("----------------------"+title+"--------------------------");

        String[] fields = {"Matricule Employe"};

        List<Attribut> attributs = new ArrayList<>();

        for (String field:fields) {

            Attribut attribut = new Attribut(field);

            attribut.setType("number");

            attributs.add(attribut);

        }


        HashMap<String,String> filledFields = Helpers.takeInfos(attributs);

        System.out.println("--------------------------------------------------------------------");

        return new Employee(Integer.valueOf(filledFields.get("Matricule Employe")));

    }


    public void displayEmployee(Employee employee){
        System.out.println(employee);
    }

}
