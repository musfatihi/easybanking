package ma.easybanking.main.java.model.DAO.Implmnts;

import ma.easybanking.main.java.model.DAO.Intrfcs.GenericInterface;
import ma.easybanking.main.java.model.DTO.Savingsaccnt;
import ma.easybanking.main.java.model.DTO.State;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Optional;

public class SavingsaccntDAOImp implements GenericInterface<Savingsaccnt,Integer> {

    static Connection connection;

    private static final String SAVE_SAVINGS_ACCOUNT = "with i as (insert into accounts (idclient, createdby, agencycode) values (?,?,?) returning nbr) insert into savingsaccnt (accnbr,interestrate) select nbr,? from i returning accnbr";


    public SavingsaccntDAOImp(Connection connection){
        SavingsaccntDAOImp.connection = connection;
    }

    @Override
    public Optional<Savingsaccnt> save(Savingsaccnt savingsaccnt) {

        try {

            PreparedStatement stmt = connection.prepareStatement(SAVE_SAVINGS_ACCOUNT);

            stmt.setInt(1, savingsaccnt.getClient().getCode());
            stmt.setInt(2, savingsaccnt.getCreatedBy().getMtrcltNbr());
            stmt.setInt(3, savingsaccnt.getAgency().getCode());
            stmt.setDouble(4, savingsaccnt.getInterestrate());


            ResultSet resultSet = stmt.executeQuery();

            while(resultSet.next())
            {
                savingsaccnt.setBalance(0);
                savingsaccnt.setCrtnDate(LocalDate.now());
                savingsaccnt.setState(State.Active);
                savingsaccnt.setNbr(resultSet.getInt(1));

                return Optional.of(savingsaccnt);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return Optional.empty();
    }

    @Override
    public Optional<Savingsaccnt> update(Savingsaccnt savingsaccnt) {
        return Optional.empty();
    }

    @Override
    public Optional<Savingsaccnt> findById(Savingsaccnt savingsaccnt) {
        return Optional.empty();
    }

    @Override
    public Boolean delete(Integer accnbr) {
        return null;
    }

}
