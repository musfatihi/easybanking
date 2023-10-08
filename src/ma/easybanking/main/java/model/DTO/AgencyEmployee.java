package ma.easybanking.main.java.model.DTO;

import ma.easybanking.main.java.utils.Helpers;

import java.time.LocalDate;

public class AgencyEmployee {

    private int nbr;
    private Agency agency;
    private Employee employee;
    private LocalDate startDate;
    private LocalDate endDate;
    public AgencyEmployee(){

    }

    public AgencyEmployee(Agency agency,Employee employee){
        this.agency = agency;
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Agency getAgency() {
        return agency;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public int getNbr() {
        return nbr;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setNbr(int nbr) {
        this.nbr = nbr;
    }

    @Override
    public String toString() {
        return "Nbr : "+this.nbr+"\n"+"Agence : "+this.agency.getCode()+"\n"+
                "Employe : "+this.employee.getMtrcltNbr()+"\n"+
                "Du : "+Helpers.localDateToStr(this.startDate)+"\n"+
                "Au : "+(this.endDate!=null?Helpers.localDateToStr(this.endDate):"--")+"\n";
    }

}
