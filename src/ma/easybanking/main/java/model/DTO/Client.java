package ma.easybanking.main.java.model.DTO;

import java.time.LocalDate;
import java.util.List;

import lombok.*;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Client extends Person{

    private int code;

    private List<Account> accounts;


    public Client(int code){
        this.code = code;
    }

    public Client(String firstName, String lastName, LocalDate birthDate, String address, String phoneNumber){

        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNumber = phoneNumber;

    }


}
