package dto;

import java.sql.SQLException;

import dao.UserDB;

public class UserMgr {
	
	private static int id=0; 
	
	public void addUser(String username, String email) throws SQLException {
		User user=new User(id, email, username);
		UserDB acs=UserDB.getDatabaseAccess();
		acs.addUser(user.getUsername(), user.getEmail());
	}
	
	public void saveUserToDB(User user) throws SQLException {
		UserDB acs=UserDB.getDatabaseAccess();
		acs.addUser(user.getUsername(), user.getEmail());
	}
	
	public void removeUserFromDB(int id) throws SQLException {
		UserDB acs=UserDB.getDatabaseAccess();
		acs.removeUser(id);
	}
	
	public void updateEmail(String oldEmail, String newEmail) throws SQLException {
		User user=findUser(oldEmail);
		user.setEmail(newEmail);
	}
	
	public void updateUsername(String oldUsername, String newUsername) throws SQLException {
		User user=findUser(oldUsername, 1);
		user.setUsername(newUsername);
	}
	
	public static User findUser(String email) throws SQLException {
		UserDB Acs=UserDB.getDatabaseAccess();
		return Acs.findUser(email);
	}
	
	public static User findUser(String username, int a) throws SQLException {
		UserDB Acs=UserDB.getDatabaseAccess();
		return Acs.findUser(username, a);
	}
	
	public static User findUser(int id) throws SQLException {
		UserDB Acs=UserDB.getDatabaseAccess();
		return Acs.findUser(id);
	}

}
