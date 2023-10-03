package ma.easybanking.main.java.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static Connection connection;


    //Connection Establishing
    public static Connection makeConnection() {
        try
        {

            if(connection==null) {

                connection = DriverManager.getConnection(DBConfig.DB_URL,DBConfig.DB_USERNAME,DBConfig.DB_PASSWORD);

            }

            return connection;

        }
        catch ( Exception e )
        {

            System.out.println( e.getMessage( ));
            return null;

        }

    }
}
