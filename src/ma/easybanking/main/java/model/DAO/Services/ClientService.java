package ma.easybanking.main.java.model.DAO.Services;

import ma.easybanking.main.java.model.ClientModel;
import ma.easybanking.main.java.model.DAO.Implmnts.ClientDAOImp;
import ma.easybanking.main.java.model.DTO.Client;

import java.util.Optional;

public class ClientService {
    private ClientDAOImp clientDAOImp;

    public ClientService(ClientDAOImp clientDAOImp){
        this.clientDAOImp = clientDAOImp;
    }

    public Optional<Client> saveClient(Client client){
        return clientDAOImp.save(client);
    }

    public Optional<Client> findClientByCode(Client client){
        return clientDAOImp.findById(client);
    }

}
