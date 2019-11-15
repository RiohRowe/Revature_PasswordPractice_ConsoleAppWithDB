package DBInterface.repository;


import java.util.ArrayList;

import DBInterface.model.User;

public interface UserRepository 
{
	ArrayList<User> getAllUsers();
	User getUserByUsername(String Name);
	boolean isUserNameFree(String un);
	int insertUser(User u);
	void deleteUser(User u);
	void updateUser(User u);
}
