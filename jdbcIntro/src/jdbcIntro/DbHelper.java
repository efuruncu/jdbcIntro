package jdbcIntro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
static String userame="root";
static String password="12345";
static String dbUrl="jdbc:mysql://localhost/world?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

public Connection getconnection()throws SQLException{
	return DriverManager.getConnection(dbUrl,userame,password);
}

public void showErrorManager(SQLException exception) {
	System.out.println("Error : "+exception.getMessage());
	System.out.println("ErrorCode : "+exception.getErrorCode());
}
}
