package tour360;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {

    Connection connection;
    Statement statement;

    Conn(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://root@localhost:3306/tour101","root","1234");
            statement= connection.createStatement();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
