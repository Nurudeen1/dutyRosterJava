import java.sql.*;
public class App 
{
    public static void main( String[] args )
    {
       Connection c =null;

       try{
            //Class.forName("org.sqlite.JDBC");
           String path = "/Users/mohammedabdulai/Documents/Project/dutyRosterJava/app/src/main/App.db";
           c = DriverManager.getConnection(path);

           System.out.print("successful");
       }
       catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);

       }
       
    }
}
