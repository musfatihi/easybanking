package ma.easybanking.main.java.model.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public final class CreditRequest {

    private int nbr;
    private double amount;
    private int duration;
    private Client client;
    private Agency agency;
    private String notes;

    public CreditRequest(){

    }

    public CreditRequest(Agency agency,Client client,double amount,int duration,String notes){
        this.agency = agency;
        this.client= client;
        this.amount = amount;
        this.duration = duration;
        this.notes = notes;
    }

}
