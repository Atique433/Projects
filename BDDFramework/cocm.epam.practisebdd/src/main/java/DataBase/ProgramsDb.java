package DataBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProgramsDb
{
    Logger logger = LogManager.getLogger(ProgramsDb.class);
    public void programs ()throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try{
            Connection connection = Participant.getConnection();
            logger.info(connection.isClosed());
            Statement statement = Participant.getStatement();
            ResultSet resultSet = Participant.getResultSet();
            logger.info("Result set will display the participant names present in view participant table :");
            while (resultSet.next()) {
                logger.info(resultSet.getString("name"));
            }
            connection.close();
            logger.info("\n\nConnection is closed or not :\n" + connection.isClosed());
        }
        catch (SQLException sqlException)
        {
            logger.info(sqlException);
        }
    }
}
