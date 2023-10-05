package ma.easybanking.main.java.model.DTO;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Assignment {
    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Mission mission;
    private Employee employee;

    public Assignment(){

    }
    public Assignment(int id){

        this.id = id;

    }

    public Assignment(Mission mission,LocalDate startDate,LocalDate endDate){

        this.mission = mission;
        this.startDate = startDate;
        this.endDate = endDate;

    }

    public Assignment(Mission mission,Employee employee,LocalDate startDate,LocalDate endDate){
        this.mission = mission;
        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Assignment(Mission mission,Employee employee,LocalDate startDate){

        this.mission = mission;
        this.employee = employee;
        this.startDate = startDate;

    }

    public Assignment(Mission mission,Employee employee){

        this.mission = mission;
        this.employee = employee;

    }



}
