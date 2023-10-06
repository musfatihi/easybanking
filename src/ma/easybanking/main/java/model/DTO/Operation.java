package ma.easybanking.main.java.model.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;


@Setter
@Getter
public class Operation {
    protected int nbr;
    protected LocalDateTime crtnTime;
    protected double amount;

    @Override
    public String toString() {
        return "Operation{" +
                "nbr=" + nbr +
                ", crtnTime=" + crtnTime +
                ", amount=" + amount +
                '}';
    }
}
