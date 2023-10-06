package ma.easybanking.main.java.model.DAO.Implmnts;

import ma.easybanking.main.java.model.DAO.Intrfcs.GenericInterface;
import ma.easybanking.main.java.model.DTO.Currentaccnt;
import ma.easybanking.main.java.model.DTO.State;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Optional;

public class CurrentaccntDAOImp implements GenericInterface<Currentaccnt,Integer> {

    private Connection connection;

    private static final String SAVE_CURRENT_ACCOUNT = "with i as (insert into accounts (idclient, createdby, agencycode) values (?,?,?) returning nbr) insert into currentaccnt (accnbr,overdraft) select nbr,? from i returning accnbr";

    public  CurrentaccntDAOImp(Connection connection)
    {
        this.connection = connection;
    }

    @Override
    public Optional<Currentaccnt> save(Currentaccnt currentaccnt) {

        try {

            PreparedStatement stmt = this.connection.prepareStatement(SAVE_CURRENT_ACCOUNT);

            stmt.setInt(1, currentaccnt.getClient().getCode());
            stmt.setInt(2, currentaccnt.getCreatedBy().getMtrcltNbr());
            stmt.setInt(3, currentaccnt.getAgency().getCode());
            stmt.setDouble(4, currentaccnt.getOverdraft());


            ResultSet resultSet = stmt.executeQuery();

            while(resultSet.next())
            {
                currentaccnt.setBalance(0);
                currentaccnt.setState(State.Active);
                currentaccnt.setNbr(resultSet.getInt(1));
                currentaccnt.setCrtnDate(LocalDate.now());

                return Optional.of(currentaccnt);

            }

        } catch (Exception e) {

            System.out.println(e);

        }

        return Optional.empty();
    }

    @Override
    public Optional<Currentaccnt> update(Currentaccnt currentaccnt) {
        return Optional.empty();
    }

    @Override
    public Optional<Currentaccnt> findById(Currentaccnt currentaccnt) {
        return Optional.empty();
    }

    @Override
    public Boolean delete(Integer accnbr) {
        return null;
    }

}
