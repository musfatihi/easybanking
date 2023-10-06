package ma.easybanking.main.java.model.DTO;


import java.time.LocalDate;
import java.util.List;

import lombok.*;
import ma.easybanking.main.java.utils.Helpers;


@Data
public class Account {

    protected int nbr;
    protected double balance;
    protected LocalDate crtnDate;
    protected State state;


    protected Client client;
    protected Employee createdBy;
    protected Agency agency;
    protected List<Operation> operations;

    public Account(){

    }

    public String toString() {
        return "Numéro de Compte : "+this.nbr+"\n"+"Date de création : "+ Helpers.localDateToStr(this.crtnDate)+"\n"+"Solde : "+this.balance+"\n"+
                "Agence : "+this.agency.getCode()+"\n"+"Employé : "+this.createdBy.getMtrcltNbr()+"\n"+"Client : "+this.client.getCode()+"\n"+"Etat : "+this.state+"\n";
    }


}
