package ma.easybanking.main.java.model;

import ma.easybanking.main.java.model.DAO.Services.CurrentaccntService;
import ma.easybanking.main.java.model.DAO.Services.SavingsaccntService;
import ma.easybanking.main.java.model.DTO.Currentaccnt;
import ma.easybanking.main.java.model.DTO.Savingsaccnt;

import java.util.Optional;

public class SavingsaccntModel {

    private SavingsaccntService savingsaccntService;

    public SavingsaccntModel(SavingsaccntService savingsaccntService){
        this.savingsaccntService = savingsaccntService;
    }

    public Optional<Savingsaccnt> saveSavingsaccnt(Savingsaccnt savingsaccnt){
        return savingsaccntService.saveSavingsaccnt(savingsaccnt);
    }
}
