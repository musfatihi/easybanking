package ma.easybanking.main.java.model.DAO.Implmnts;

import ma.easybanking.main.java.model.DAO.Intrfcs.GenericInterface;
import ma.easybanking.main.java.model.DAO.Services.AgencyService;
import ma.easybanking.main.java.model.DTO.Agency;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AgencyDAOImp implements GenericInterface<Agency,Integer> {

    private static Connection connection;

    private static final String SAVE_AGENCY = "insert into agencies (name, address, phonenumber) values (?,?,?) returning code";

    private static final String DELETE_AGENCY = "update agencies set deleted=true where code=?";

    private static final String FIND_AGENCY_BY_CODE = "select * from agencies where code=? and deleted=false";

    private static final String FIND_AGENCY_BY_ADDRESS = "select * from agencies where address=? and deleted=false";

    private static final String UPDATE_AGENCY = "update agencies set name=?, address=?, phonenumber=? where code=?";




    public AgencyDAOImp(Connection connection){
        AgencyDAOImp.connection = connection;
    }

    @Override
    public Optional<Agency> save(Agency agency) {

        try {

            PreparedStatement stmt = connection.prepareStatement(SAVE_AGENCY);

            stmt.setString(1, agency.getName());
            stmt.setString(2, agency.getAddress());
            stmt.setString(3, agency.getPhoneNumber());

            ResultSet resultSet = stmt.executeQuery();

            while(resultSet.next())
            {
                agency.setCode(resultSet.getInt(1));
                return Optional.of(agency);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return Optional.empty();
    }

    @Override
    public Optional<Agency> findById(Agency agency) {

        try {

            PreparedStatement stmt = connection.prepareStatement(FIND_AGENCY_BY_CODE);

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

    @Override
    public Boolean delete(Integer code) {
        int rowsUpdated = 0;

        try {

            PreparedStatement stmt = connection.prepareStatement(DELETE_AGENCY);

            stmt.setInt(1,code);

            rowsUpdated = stmt.executeUpdate();

        }
        catch (Exception e) {

            System.out.println(e);

        }

        return rowsUpdated>0;
    }

    @Override
    public Optional<Agency> update(Agency agency) {

        int updatedRows=0;

        try {

            PreparedStatement stmt = connection.prepareStatement(UPDATE_AGENCY);

            stmt.setString(1, agency.getName());
            stmt.setString(2, agency.getAddress());
            stmt.setString(3, agency.getPhoneNumber());
            stmt.setInt(4, agency.getCode());

            updatedRows = stmt.executeUpdate();

            return (updatedRows>0?Optional.of(agency):Optional.empty());

        } catch (Exception e) {
            System.out.println(e);
        }

        return Optional.empty();
    }


    public List<Agency> findByAddress(Agency agency) {

        List<Agency> agencies = new ArrayList<>();

        try {

            PreparedStatement stmt = connection.prepareStatement(FIND_AGENCY_BY_ADDRESS);

            stmt.setString(1, agency.getAddress());


            ResultSet resultSet = stmt.executeQuery();

            while(resultSet.next()){

                agency.setCode(resultSet.getInt(1));
                agency.setName(resultSet.getString(2));
                agency.setPhoneNumber(resultSet.getString(4));

                agencies.add(agency);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return agencies;

    }

}
