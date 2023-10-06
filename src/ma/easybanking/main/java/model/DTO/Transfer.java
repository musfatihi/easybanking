package ma.easybanking.main.java.model.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
public class Transfer extends Operation{

    private Account srcAccount;

    private Account destAccount;

    public Transfer(double amount,Account srcAccount, Account destAccount){
        this.amount = amount;
        this.srcAccount = srcAccount;
        this.destAccount = destAccount;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "srcAccount=" + srcAccount.getNbr() +
                ", destAccount=" + destAccount.getNbr() +
                ", nbr=" + nbr +
                ", crtnTime=" + crtnTime +
                ", amount=" + amount +
                '}';
    }

}
