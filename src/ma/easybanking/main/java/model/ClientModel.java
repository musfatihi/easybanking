package ma.easybanking.main.java.model;

import ma.easybanking.main.java.model.DAO.Services.ClientService;
import ma.easybanking.main.java.model.DTO.Client;

import java.util.Optional;

public class ClientModel {
    private ClientService clientService;


    public ClientModel(ClientService clientService){
        this.clientService = clientService;
    }

    public Optional<Client> saveClient(Client client){
        return clientService.saveClient(client);
    }

    public Optional<Client> findClientByCode(Client client){
        return clientService.findClientByCode(client);
    }

}
