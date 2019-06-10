package dao;

import java.sql.SQLException;
import dto.User;

public interface UserInterface {

	public void addUser(String username, String email) throws SQLException;
	
	public User findUSer(String email) throws SQLException;
	
	public User findUser(int id) throws SQLException;
	
	public void removeUser(int id) throws SQLException;

}
