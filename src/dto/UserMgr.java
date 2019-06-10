package dto;

import dao.UserDB;

public class UserMgr {
	
	private static int id=0;
	private 
	
	public void addUser(String username, String email){
		User user=new User(id, username, email);
		id++;
		saveUserToDB(user);
	}
	
	public void saveUserToDB(User user) {
		
	}
	
	public void removeUserFromDB(String username) {
		User user=findUser(username);	
	}
	
	public void updateEmail(String oldEmail, String newEmail) {
		User user=findUser(oldEmail);
		user.setEmail(newEmail);
	}
	
	public void updateUsername(String oldUsername, String newUsername) {
		User user=findUser(oldUsername);
		user.setUsername(newUsername);
	}
	
	public static User findUSer(String email) {
		UserDB Acs=UserDB.getDatabaseAccess();
		return Acs.findUser(email);
	}
	
	public static User findUSer(int id) {
		UserDB Acs=UserDB.getDatabaseAccess();
		return Acs.findUser(id);
	}

}
