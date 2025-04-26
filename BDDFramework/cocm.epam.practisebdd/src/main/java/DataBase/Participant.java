package DataBase;

import java.sql.*;

public class Participant
{
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    private static String Query= "SELECT * FROM viewparticipant where name ='Atique Rahman';";

    private Participant(){

    }
    public static Connection getConnection() throws SQLException {
        if (connection == null){
            connection= DriverManager.getConnection("jdbc:mysql://****:3306/Programs","qa","qa123");
        }
        return connection;
    }
    public static Statement getStatement() throws SQLException {
        if (statement == null)
        {
            statement = connection.createStatement();
        }
        return statement;
    }
    public static ResultSet getResultSet() throws SQLException {
        if (resultSet == null)
        {
            resultSet = statement.executeQuery(Query);
        }
        return resultSet;
    }
}
