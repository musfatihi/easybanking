package ma.easybanking.main.java.model.DAO.Implmnts;

import ma.easybanking.main.java.model.DAO.Intrfcs.GenericInterface;
import ma.easybanking.main.java.model.DTO.AgencyEmployee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Optional;

public class AgencyEmployeeDAOImp implements GenericInterface<AgencyEmployee> {

    private Connection connection;

    private static final String SAVE_AGENCY_EMPLOYEE = "insert into agencyemployee (agncycode,empmtrcl) values (?,?) returning nbr,startdate,enddate";

    public AgencyEmployeeDAOImp(Connection connection){
        this.connection = connection;
    }

    @Override
    public Optional<AgencyEmployee> save(AgencyEmployee agencyEmployee) {
        try {

            PreparedStatement stmt = this.connection.prepareStatement(SAVE_AGENCY_EMPLOYEE, ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            stmt.setInt(1, agencyEmployee.getEmployee().getMtrcltNbr());
            stmt.setInt(2, agencyEmployee.getAgency().getCode());


            ResultSet resultSet = stmt.executeQuery();

            while(resultSet.next())
            {
                agencyEmployee.setNbr(resultSet.getInt(1));
                agencyEmployee.setStartDate(LocalDate.now());
            }

            return Optional.of(agencyEmployee);


        } catch (Exception e) {
            System.out.println(e);
        }

        return Optional.empty();
    }

    @Override
    public Optional<AgencyEmployee> update(AgencyEmployee agencyEmployee) {
        return Optional.empty();
    }

    @Override
    public Optional<AgencyEmployee> findById(AgencyEmployee agencyEmployee) {
        return Optional.empty();
    }

    @Override
    public Boolean delete(AgencyEmployee agencyEmployee) {
        return null;
    }
}
