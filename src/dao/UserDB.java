package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.User;

public class UserDB implements UserInterface {
	
	Connection connection=ConnectionManager.getInstance().getConnection();
	private static UserDB databaseAccess=new UserDB();
	
	private UserDB() {
		
	}
	
	public static UserDB getDatabaseAccess() {
		return databaseAccess;
	}

	@Override
	public void addUser(String username, String email) throws SQLException {

		String query = "INSERT INTO korisnici(username, email) VALUES (?, ?)";

		try (PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setString(1, username);
			statement.setString(2, email);

			statement.executeUpdate();

		}
	}
	
public User findUser(String email) throws SQLException {
		
	User user = null;

	String query = "SELECT * FROM users WHERE email = ?";

	ResultSet rs = null;

	try (PreparedStatement statement = connection.prepareStatement(query);) {

		statement.setString(1, email);

		rs = statement.executeQuery();

		if (rs.next()) {

			user = new User(rs.getInt("id"), rs.getString("email"), rs.getString("username"));

			rs.close();
		}
	}

return user;
	}

@Override
public User findUser(String username, int a) throws SQLException {
	
	User user = null;

	String query = "SELECT * FROM users WHERE username = ?";

	ResultSet rs = null;

	try (PreparedStatement statement = connection.prepareStatement(query);) {

		statement.setString(1, username);

		rs = statement.executeQuery();

		if (rs.next()) {

			user = new User(rs.getInt("id"), rs.getString("email"), rs.getString("username"));

			rs.close();
		}
	}

return user;
	
}

@Override
public User findUser(int id) throws SQLException {
	
	User user = null;

	String query = "SELECT * FROM users WHERE id = ?";

	ResultSet rs = null;

	try (PreparedStatement statement = connection.prepareStatement(query);) {

		statement.setInt(1, id);

		rs = statement.executeQuery();

		if (rs.next()) {

			user = new User(rs.getInt("id"), rs.getString("email"), rs.getString("username"));

			rs.close();
		}
	}

return user;

	}

@Override
public void removeUser(int id) throws SQLException {

	String query = "DELETE FROM users WHERE id = ?";

	try (PreparedStatement statement = connection.prepareStatement(query);) {

		statement.setInt(1, id);

		statement.executeUpdate();

	}

}

}
