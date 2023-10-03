package ma.easybanking.main.java.model.DAO.Services;

import ma.easybanking.main.java.model.DTO.Agency;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;


public class AgencyService {

    private Connection connection;

    private static final String SAVE_AGENCY = "insert into agencies (name, address, phonenumber) values (?,?,?) returning code";

    private static final String DELETE_AGENCY = "update agencies set deleted=true where code=?";

    private static final String FIND_AGENCY_BY_CODE = "select * from agencies where code=? and deleted=false";





    //Constructor
    public AgencyService(Connection connection) {
        this.connection = connection;
    }

    //Agency Saving
    public Agency saveAgency(Agency agency) {

        try {

            PreparedStatement stmt = this.connection.prepareStatement(SAVE_AGENCY);

            stmt.setString(1, agency.getName());
            stmt.setString(2, agency.getAddress());
            stmt.setString(3, agency.getPhoneNumber());

            ResultSet resultSet = stmt.executeQuery();
            resultSet.next();
            agency.setCode(resultSet.getInt(1));

        } catch (Exception e) {
            System.out.println(e);
        }

        return agency;

    }

    //Agency Deletion
    public Boolean deleteAgency(Agency agency){

        int rowsUpdated = 0;

        try {

            PreparedStatement stmt = this.connection.prepareStatement(DELETE_AGENCY);

            stmt.setInt(1,agency.getCode());

            rowsUpdated = stmt.executeUpdate();

        }
        catch (Exception e) {

            System.out.println(e);

        }

        return rowsUpdated>0;

    }

    public Optional<Agency> findAgencyByCode(Agency agency){

        try {

            PreparedStatement stmt = this.connection.prepareStatement(FIND_AGENCY_BY_CODE);

            stmt.setInt(1, agency.getCode());


            ResultSet resultSet = stmt.executeQuery();

            while(resultSet.next()){

                agency.setName(resultSet.getString(2));
                agency.setAddress(resultSet.getString(3));
                agency.setPhoneNumber(resultSet.getString(4));

                return Optional.of(agency);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return Optional.empty();

    }


}
