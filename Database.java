import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Database {
	public static final String insert = "INSERT INTO userschat VALUES (?,?,?)";
	public static final String getName = "SELECT * FROM userschat";
	public static int id;
	public static boolean getUser(String name) throws SQLException{
		boolean a = false;
			List<String> list = new ArrayList<>();
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/mydbtest", "root", "root");
			PreparedStatement statement = conn.prepareStatement(getName);
			ResultSet res = statement.executeQuery();
			while (res.next()) {
				String nameBD = res.getString("name");
				list.add(nameBD);
			}
			if(list.contains(name)){
				a=true;
			}
		return a;
	}
	public static int getID () throws SQLException{
		Connection connect;
		PreparedStatement statement;
		ResultSet res;
		connect = DriverManager.getConnection("jdbc:mysql://localhost/mydbtest", "root", "root");
		statement = connect.prepareStatement(getName);
		res = statement.executeQuery();
		while (res.next()) {
			 id = res.getInt("id");
		}
		return ++id;
	}
	public static void setDB(String name, String password) {
		Connection connect;
		PreparedStatement statement;
		try {
			connect = DriverManager.getConnection("jdbc:mysql://localhost/mydbtest", "root", "root");
		    statement = connect.prepareStatement(insert);
		    statement.setInt(1, getID());
			statement.setString(2, name);
			statement.setString(3, password);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}