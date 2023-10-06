package ma.easybanking.main.java.model.DAO.Services;

import ma.easybanking.main.java.model.DAO.Implmnts.TransferDAOImp;
import ma.easybanking.main.java.model.DTO.Transfer;
import ma.easybanking.main.java.model.TransferModel;

import java.util.Optional;

public class TransferService {

    private TransferDAOImp transferDAOImp;

    public TransferService(TransferDAOImp transferDAOImp){
        this.transferDAOImp = transferDAOImp;
    }

    public Optional<Transfer> saveTransfer(Transfer transfer){
        return transferDAOImp.save(transfer);
    }

}
