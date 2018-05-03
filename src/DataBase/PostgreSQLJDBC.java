package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PostgreSQLJDBC {
    public static void main( String args[] ) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/test",
                            "postgres", "hejhej123");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM parking;" );
            while ( rs.next() ) {
                int id = rs.getInt("id");
                double firstHourPrice  = rs.getDouble("FirstHourPrice");
                double secondHourPrice  = rs.getDouble("SecondHourPrice");
                double thirdHourPrice = rs.getDouble("ThirdHourPrice");
                double minimalAmount = rs.getDouble("MinimalAmount");
                String city = rs.getString("City");
                System.out.println( "ID = " + id );
                System.out.println("City name: "+city);
                System.out.println( "First Hour Price = " + firstHourPrice );
                System.out.println( "Second Hour Price = " + secondHourPrice );
                System.out.println( "Third Hour Price = " + thirdHourPrice );
                System.out.println("Minimal amount = "+ minimalAmount);
                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
}

