package ma.easybanking.main.java.model.DAO.Implmnts;

import ma.easybanking.main.java.model.DAO.Intrfcs.GenericInterface;
import ma.easybanking.main.java.model.DTO.Transfer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public class TransferDAOImp implements GenericInterface<Transfer,Integer> {

    private static Connection connection;

    private static final String SAVE_TRANSFER = "with i as (insert into operations (amount) values (?) returning nbr) insert into transfers (opnbr,srcaccnt,destaccnt) select nbr,?,? from i returning opnbr";

    private static final String DELETE_TRANSFER = "update operations set deleted=true where nbr=?";


    public TransferDAOImp(Connection connection)
    {
        TransferDAOImp.connection = connection;
    }

    @Override
    public Optional<Transfer> save(Transfer transfer) {

        try {

            PreparedStatement stmt = connection.prepareStatement(SAVE_TRANSFER);

            stmt.setDouble(1,transfer.getAmount());
            stmt.setInt(2, transfer.getSrcAccount().getNbr());
            stmt.setInt(3,transfer.getDestAccount().getNbr());

            ResultSet resultSet = stmt.executeQuery();

            while(resultSet.next()){
                transfer.setNbr(resultSet.getInt(1));
                transfer.setCrtnTime(LocalDateTime.now());
                return Optional.of(transfer);
            }


        } catch (Exception e) {

            System.out.println(e);

        }

        return Optional.empty();
    }

    @Override
    public Optional<Transfer> update(Transfer transfer) {
        return Optional.empty();
    }

    @Override
    public Optional<Transfer> findById(Transfer transfer) {
        return Optional.empty();
    }

    @Override
    public Boolean delete(Integer nbr) {

        int rowsUpdated = 0;

        try {

            PreparedStatement stmt = connection.prepareStatement(DELETE_TRANSFER);

            stmt.setInt(1,nbr);

            rowsUpdated = stmt.executeUpdate();

        }
        catch (Exception e) {

            System.out.println(e);

        }

        return rowsUpdated>0;
    }

}
