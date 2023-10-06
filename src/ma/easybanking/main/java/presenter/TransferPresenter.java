package ma.easybanking.main.java.presenter;

import ma.easybanking.main.java.model.DTO.Transfer;
import ma.easybanking.main.java.model.TransferModel;
import ma.easybanking.main.java.view.TranferView;

import java.util.Optional;

public class TransferPresenter {

    private TransferModel transferModel;

    private TranferView transferView;

    public TransferPresenter(TransferModel transferModel, TranferView transferView){
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

}
