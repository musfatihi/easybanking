package ma.easybanking.main.java.model.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Currentaccnt extends Account{

    private double overdraft;

    public Currentaccnt(){

    }

    public Currentaccnt(Agency agency,Employee employee,Client client,double overdraft)
    {
        this.agency = agency;
        this.createdBy = employee;
        this.client = client;
        this.overdraft = overdraft;

    }


    public String toString() {
        return super.toString()+"Decouvert : "+this.overdraft+"\n";
    }


}
