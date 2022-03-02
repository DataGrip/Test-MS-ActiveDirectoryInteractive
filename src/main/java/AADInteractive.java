import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class AADInteractive {
    public static void main(String[] args) throws Exception{

        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setServerName("REPLACE_ME"); // Replace with your server name
        ds.setDatabaseName("REPLACE_ME"); // Replace with your database
        ds.setAuthentication("ActiveDirectoryInteractive");

        // Optional login hint
        ds.setUser("REPLACE_ME"); // Replace with your user name

        try (Connection connection = ds.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT SUSER_SNAME()")) {
            if (rs.next()) {
                System.out.println("You have successfully logged on as: " + rs.getString(1));
            }
        }
    }
}
