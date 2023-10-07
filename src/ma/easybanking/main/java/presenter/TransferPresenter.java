package ma.easybanking.main.java.presenter;

import ma.easybanking.main.java.model.DTO.Transfer;
import ma.easybanking.main.java.model.TransferModel;
import ma.easybanking.main.java.view.TransferView;

import java.util.Optional;

public class TransferPresenter {

    private TransferModel transferModel;

    private TransferView transferView;

    public TransferPresenter(TransferModel transferModel, TransferView transferView){
        this.transferModel = transferModel;
        this.transferView = transferView;
    }

    public void saveTransfer(){
        Optional<Transfer> optionalTransfer = transferModel.saveTransfer(transferView.getTranferInfos(""));
        if(optionalTransfer.isPresent())
        {
            transferView.displayTransfer(optionalTransfer.get());

        }else{

            transferView.displayErrorMsg("Error!!");

        }
    }

    public void deleteTransfer(){

        if(transferModel.deleteTransfer(transferView.getTrnsferCode("")))
        {
            transferView.displaySuccessMsg("Virement supprimé avec succès");
        }
        else
        {
            transferView.displayErrorMsg("L'Opération de suppression a échoué!!");
        }

    }

}
