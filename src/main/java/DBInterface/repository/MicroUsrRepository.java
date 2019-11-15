package DBInterface.repository;

import java.util.ArrayList;

import DBInterface.model.MicroUser;

public interface MicroUsrRepository 
{
	MicroUser getAccFromUsrnameAndCompany(String usrname, String company);
	ArrayList<MicroUser> getAcctsFromUsername(String usrname);
	boolean isMUsernameAvailable(String usrname);
	void updateMUser(MicroUser mU);
	void insertMUser(MicroUser mU, int UID, int LBID);
	void deleteMUser(String username, String company);
}
