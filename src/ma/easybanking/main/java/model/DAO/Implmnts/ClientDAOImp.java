package ma.easybanking.main.java.model.DAO.Implmnts;

import ma.easybanking.main.java.model.ClientModel;
import ma.easybanking.main.java.model.DAO.Intrfcs.GenericInterface;
import ma.easybanking.main.java.model.DTO.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

public class ClientDAOImp implements GenericInterface<Client,Integer> {
    private static Connection connection;

    private static final String SAVE_CLIENT = "insert into clients (firstname,lastname, birthdate, address, phonenumber) values (?,?,?,?,?) returning code";

    private static final String FIND_CLIENT_BY_CODE = "select * from clients where code=?";

    public ClientDAOImp(Connection connection){
        ClientDAOImp.connection = connection;
    }

    @Override
    public Optional<Client> save(Client client) {
        try {

            PreparedStatement stmt = connection.prepareStatement(SAVE_CLIENT, ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            stmt.setString(1, client.getFirstName());
            stmt.setString(2, client.getLastName());
            stmt.setDate(3, java.sql.Date.valueOf(client.getBirthDate()));
            stmt.setString(4, client.getAddress());
            stmt.setString(5, client.getPhoneNumber());

            ResultSet resultSet = stmt.executeQuery();

            while(resultSet.next())
            {
                client.setCode(resultSet.getInt(1));
                return Optional.of(client);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return Optional.empty();
    }

    @Override
    public Optional<Client> update(Client client) {
        return Optional.empty();
    }

    @Override
    public Optional<Client> findById(Client client) {
        try {

            PreparedStatement stmt = connection.prepareStatement(FIND_CLIENT_BY_CODE, ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            stmt.setInt(1, client.getCode());

            ResultSet resultSet = stmt.executeQuery();

            while(resultSet.next())
            {
                client.setFirstName(resultSet.getString(2));
                client.setLastName(resultSet.getString(3));
                client.setBirthDate(resultSet.getDate(4).toLocalDate());
                client.setAddress(resultSet.getString(5));
                client.setPhoneNumber(resultSet.getString(6));

                return Optional.of(client);
            }

        }
        catch(Exception e){

            System.out.println(e);

        }

        return Optional.empty();
    }

    @Override
    public Boolean delete(Integer id) {
        return null;
    }

}
