package ma.easybanking.main.java.model;

import ma.easybanking.main.java.model.DAO.Services.TransferService;
import ma.easybanking.main.java.model.DTO.Transfer;

import java.util.Optional;

public class TransferModel {

    private TransferService transferService;

    public TransferModel(TransferService transferService){
        this.transferService = transferService;
    }

    public Optional<Transfer> saveTransfer(Transfer transfer){
        return this.transferService.saveTransfer(transfer);
    }

}
