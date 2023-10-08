package ma.easybanking.main.java.model.DAO.Implmnts;

import ma.easybanking.main.java.model.DAO.Intrfcs.GenericInterface;
import ma.easybanking.main.java.model.DTO.Agency;
import ma.easybanking.main.java.model.DTO.CRState;
import ma.easybanking.main.java.model.DTO.Client;
import ma.easybanking.main.java.model.DTO.CreditRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CreditRequestDAOImp implements GenericInterface<CreditRequest,Integer> {

    private static Connection connection;


    private final static String  SAVE_CREDIT_REQUEST = "insert into creditrequests(client, agency, amount, duration, notes) values (?,?,?,?,?) returning nbr";

    private final static String FIND_CREDIT_REQUEST_BY_NRB = "select * from creditrequests where nbr=?";

    private final static String FIND_ALL_CREDIT_REQUESTS = "select * from creditrequests";

    private final static String CHANGE_CREDIT_REQUEST_STATE = "update creditrequests set state=? where nbr=?";



    public CreditRequestDAOImp(Connection connection){
        CreditRequestDAOImp.connection = connection;
    }
    @Override
    public Optional<CreditRequest> save(CreditRequest creditRequest) {

        try {

            PreparedStatement stmt = connection.prepareStatement(SAVE_CREDIT_REQUEST);

            stmt.setInt(1, creditRequest.getClient().getCode());
            stmt.setInt(2,creditRequest.getAgency().getCode());
            stmt.setDouble(3,creditRequest.getAmount());
            stmt.setInt(4,creditRequest.getDuration());
            stmt.setString(5, creditRequest.getNotes());

            ResultSet resultSet = stmt.executeQuery();

            while(resultSet.next())
            {
                creditRequest.setNbr(resultSet.getInt(1));
                return Optional.of(creditRequest);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return Optional.empty();
    }

    @Override
    public Optional<CreditRequest> update(CreditRequest creditRequest) {
        return Optional.empty();
    }

    @Override
    public Optional<CreditRequest> findById(CreditRequest creditRequest) {

        try {

            PreparedStatement stmt = connection.prepareStatement(FIND_CREDIT_REQUEST_BY_NRB);

            stmt.setInt(1, creditRequest.getNbr());

            ResultSet resultSet = stmt.executeQuery();

            while(resultSet.next())
            {

                creditRequest.setClient(new Client(resultSet.getInt(2)));
                creditRequest.setAgency(new Agency(resultSet.getInt(3)));
                creditRequest.setCrtDate(resultSet.getDate(4).toLocalDate());
                creditRequest.setAmount(resultSet.getDouble(5));
                creditRequest.setDuration(resultSet.getInt(6));
                creditRequest.setNotes(resultSet.getString(7));

                return Optional.of(creditRequest);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return Optional.empty();
    }

    @Override
    public Boolean delete(Integer nbr) {
        return null;
    }

    public List<CreditRequest> findAll(){

        List<CreditRequest> creditRequests = new ArrayList<>();

        try {

            PreparedStatement stmt = connection.prepareStatement(FIND_ALL_CREDIT_REQUESTS);

            ResultSet resultSet = stmt.executeQuery();

            while(resultSet.next())
            {

                CreditRequest creditRequest = new CreditRequest();

                creditRequest.setNbr(resultSet.getInt(1));
                creditRequest.setClient(new Client(resultSet.getInt(2)));
                creditRequest.setAgency(new Agency(resultSet.getInt(3)));
                creditRequest.setCrtDate(resultSet.getDate(4).toLocalDate());
                creditRequest.setAmount(resultSet.getDouble(5));
                creditRequest.setDuration(resultSet.getInt(6));
                creditRequest.setNotes(resultSet.getString(7));
                creditRequest.setCrstate(CRState.valueOf(resultSet.getString(8)));


                creditRequests.add(creditRequest);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return creditRequests;

    }

    public boolean changeState(int nbr,String state){

        int updatedRows=0;

        try {

            PreparedStatement stmt = connection.prepareStatement(CHANGE_CREDIT_REQUEST_STATE);

            stmt.setString(1, state);
            stmt.setInt(2,nbr);

            updatedRows = stmt.executeUpdate();


        } catch (Exception e) {
            System.out.println(e);
        }

        return updatedRows>0;
    }

}
