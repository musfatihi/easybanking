package ma.easybanking.main.java.model.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public final class CreditRequest {

    private int nbr;
    private double amount;
    private int duration;
    private Client client;
    private Agency agency;
    private String notes;
    private LocalDate crtDate;
    private CRState crstate;

    public CreditRequest(){

    }

    public CreditRequest(int nbr){
        this.nbr=nbr;
    }

    public CreditRequest(Agency agency,Client client,double amount,int duration,String notes){
        this.agency = agency;
        this.client= client;
        this.amount = amount;
        this.duration = duration;
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "CreditRequest{" +
                "nbr=" + nbr +
                ", amount=" + amount +
                ", duration=" + duration +
                ", client=" + client.getCode() +
                ", agency=" + agency.getCode() +
                ", notes='" + notes + '\'' +
                ", crtDate=" + crtDate +
                '}';
    }

}
