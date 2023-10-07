package ma.easybanking.main.java.presenter;

import ma.easybanking.main.java.model.ClientModel;
import ma.easybanking.main.java.model.DTO.Client;
import ma.easybanking.main.java.view.ClientView;

import java.util.Optional;

public class ClientPresenter {

    private ClientModel clientModel;

    private ClientView clientView;

    public ClientPresenter(ClientModel clientModel, ClientView clientView){
        this.clientModel=clientModel;
        this.clientView=clientView;
    }

    public void saveClient(){

        Optional<Client> optionalClient = clientModel.saveClient(clientView.saveClient());

        if(optionalClient.isPresent())
        {
            clientView.displayClient(optionalClient.get());
        }
        else
        {

        }

    }

    public void findClientByCode(){

        Optional<Client> optionalClient = clientModel.findClientByCode(clientView.getClient("Chercher un Client"));

        if(optionalClient.isPresent())
        {
            clientView.displayClient(optionalClient.get());
        }
        else
        {
            clientView.displayErrorMsg("");
        }
    }

}
