
package p1;

import java.sql.*;

public class DB_Connection 
{
      public static String SENDERS_EMAILID="vikaskbajpai@gmail.com";
      public static String SENDERS_PASSWORD="healthyliving";
    public static Connection get_DBConnection()
    {
        Connection conn=null;
        try
        {
           Class.forName("com.mysql.jdbc.Driver");
           conn=DriverManager.getConnection("jdbc:mysql://localhost/airlines_db","root","abc");
           
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return conn;
    }
    
}
