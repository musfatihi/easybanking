package ma.easybanking.main.java.model.DTO;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Savingsaccnt extends Account{

    private double interestrate;

    public Savingsaccnt(){
    }

    public Savingsaccnt(Agency agency,Employee employee,Client client,double interestrate){
        this.agency = agency;
        this.createdBy = employee;
        this.client = client;
        this.interestrate = interestrate;
    }

    public String toString() {
        return super.toString()+"Taux d'interet : "+this.interestrate+"\n";
    }

}
