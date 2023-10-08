package ma.easybanking.main.java.model.DAO.Implmnts;

import ma.easybanking.main.java.model.DAO.Intrfcs.GenericInterface;
import ma.easybanking.main.java.model.DTO.Agency;
import ma.easybanking.main.java.model.DTO.AgencyEmployee;
import ma.easybanking.main.java.model.DTO.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AgencyEmployeeDAOImp implements GenericInterface<AgencyEmployee,Integer> {

    private static Connection connection;

    private static final String SAVE_AGENCY_EMPLOYEE = "insert into agencyemployee (agncycode,empmtrcl) values (?,?) returning nbr,startdate,enddate";

    private static final String AGENCIES_EMPLOYEE_BY_EMPLOYEE = "select * from agencyemployee where empmtrcl=? order by nbr desc";


    public AgencyEmployeeDAOImp(Connection connection){
        AgencyEmployeeDAOImp.connection = connection;
    }

    @Override
    public Optional<AgencyEmployee> save(AgencyEmployee agencyEmployee) {
        try {

            PreparedStatement stmt = connection.prepareStatement(SAVE_AGENCY_EMPLOYEE, ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            stmt.setInt(1, agencyEmployee.getAgency().getCode());
            stmt.setInt(2, agencyEmployee.getEmployee().getMtrcltNbr());



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
    public Boolean delete(Integer nbr) {
        return null;
    }

    public List<AgencyEmployee> getEmployeeHistory(Employee employee){

        List<AgencyEmployee> agenciesEmployee = new ArrayList<>();

        try {

            PreparedStatement stmt = connection.prepareStatement(AGENCIES_EMPLOYEE_BY_EMPLOYEE, ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            stmt.setInt(1, employee.getMtrcltNbr());

            ResultSet resultSet = stmt.executeQuery();

            while(resultSet.next())
            {
                AgencyEmployee agencyEmployee = new AgencyEmployee();

                agencyEmployee.setNbr(resultSet.getInt(1));
                agencyEmployee.setAgency(new Agency(resultSet.getInt(2)));
                agencyEmployee.setEmployee(new Employee(resultSet.getInt(3)));
                agencyEmployee.setStartDate(resultSet.getDate(4).toLocalDate());
                if(resultSet.getDate(5)!=null)
                {
                    agencyEmployee.setEndDate(resultSet.getDate(5).toLocalDate());
                }
                agenciesEmployee.add(agencyEmployee);
            }



        } catch (Exception e) {
            System.out.println(e);
        }

        return agenciesEmployee;
    }

}
