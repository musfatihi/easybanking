package ma.easybanking.main.java.model.DAO.Services;

import ma.easybanking.main.java.model.DTO.Agency;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class AgencyService {

    private Connection connection;

    private static final String SAVE_AGENCY = "insert into agencies (name, address, phonenumber) values (?,?,?) returning code";

    private static final String DELETE_AGENCY = "update agencies set deleted=true where code=?";




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


}
