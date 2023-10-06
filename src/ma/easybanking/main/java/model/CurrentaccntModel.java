package ma.easybanking.main.java.model;

import ma.easybanking.main.java.model.DAO.Services.CurrentaccntService;
import ma.easybanking.main.java.model.DTO.Currentaccnt;

import java.util.Optional;

public class CurrentaccntModel {

    private CurrentaccntService currentaccntService;

    public CurrentaccntModel(CurrentaccntService currentaccntService){
        this.currentaccntService = currentaccntService;
    }

    public Optional<Currentaccnt> saveCurrentaccnt(Currentaccnt currentaccnt){
        return currentaccntService.saveCurrentaccnt(currentaccnt);
    }

}
