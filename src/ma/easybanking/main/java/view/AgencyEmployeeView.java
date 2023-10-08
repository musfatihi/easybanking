package ma.easybanking.main.java.view;

import ma.easybanking.main.java.model.DTO.AgencyEmployee;

import java.util.List;

public class AgencyEmployeeView {

    public void displayAgenciesEmployee(List<AgencyEmployee> agenciesEmployee){
        for (AgencyEmployee agencyEmployee: agenciesEmployee) {
            System.out.println(agencyEmployee);
        }
    }

}
