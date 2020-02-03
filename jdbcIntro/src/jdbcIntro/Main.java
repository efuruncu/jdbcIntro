package jdbcIntro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws SQLException {
	
		selectDemo();
		//insertDemo();
		//updateDemo();
		//deleteDemo();
		

	}
	
	public static void selectDemo() throws SQLException {
		Connection connection=null;
		DbHelper helper=new DbHelper();
		Statement statement=null;
		ResultSet resultset;
		try {
			connection=helper.getconnection();
			statement=connection.createStatement();
			String sql="select Code,Name,Continent,Region from country";
			resultset=statement.executeQuery(sql);
			ArrayList<Country> countries=new ArrayList<Country>();
			while(resultset.next()) {
				countries.add(new Country(
						resultset.getString("Code"),
						resultset.getString("Name"),
						resultset.getString("Continent"),
						resultset.getString("Region")
						
						));
			}
			System.out.println(countries.size());
			
		}catch(SQLException e) {
			helper.showErrorManager(e);
		}finally {
			connection.close();
		}
	}
	public static void insertDemo() throws SQLException {
		Connection connection=null;
		DbHelper helper=new DbHelper();
		PreparedStatement statement=null;
		ResultSet resultset;
		try {
			connection=helper.getconnection();
			String sql="insert into city (Name,CountryCode,District,Population) values ('Malatya','TUR','BAttalgazi',200000)";
			//String sql="insert into city (Name,CountryCode,District,Population) values (?,?,?,?)";
			//statement.setString(1, "Malatya");
			//statement.setString(2, "TUR");
			//statement.setString(3, "Battalgazi");
			//statement.setInt(4, 500000);
			
			statement=connection.prepareStatement(sql);
			statement.executeUpdate();	
			System.out.println("Kayýt eklendi");
			
			
		}catch(SQLException e) {
			helper.showErrorManager(e);
		}finally {
			connection.close();
		}
	}
	
	public static void updateDemo() throws SQLException {
		Connection connection=null;
		DbHelper helper=new DbHelper();
		PreparedStatement statement=null;
		ResultSet resultset;
		try {
			connection=helper.getconnection();
			String sql="update city set population=80000 where id=4081";
			
			statement=connection.prepareStatement(sql);
			statement.executeUpdate();
			System.out.println("Kayýt güncellendi");
			
			
		}catch(SQLException e) {
			helper.showErrorManager(e);
		}finally {
			connection.close();
		}
	}
	
	public static void deleteDemo() throws SQLException {
		Connection connection=null;
		DbHelper helper=new DbHelper();
		PreparedStatement statement=null;
		ResultSet resultset;
		try {
			connection=helper.getconnection();
			String sql="delete from city where id=4081";
			
			statement=connection.prepareStatement(sql);
			statement.executeUpdate();
			System.out.println("Kayýt silindi");
			
			
		}catch(SQLException e) {
			helper.showErrorManager(e);
		}finally {
			connection.close();
		}
	}

}
