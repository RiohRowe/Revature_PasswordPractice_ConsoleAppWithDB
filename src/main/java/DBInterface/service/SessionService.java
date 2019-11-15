package DBInterface.service;

import java.util.ArrayList;
import java.util.List;

import DBInterface.model.LifeBlock;
import DBInterface.model.MicroUser;
import DBInterface.model.User;
import DBInterface.repository.LifeBlockRepositoryImpl;
import DBInterface.repository.MicroUsrRepositoryimpl;
import DBInterface.repository.UserRepositoryImpl;

public class SessionService 
{
	public LifeBlock[] getAllLifeBlocks()
	{
		ArrayList<LifeBlock> lbs = new LifeBlockRepositoryImpl().getAllLifeBlocks();
		LifeBlock[] allLBs = new LifeBlock[lbs.size()];
		for(int i = 0; i < lbs.size(); ++i)
		{
			allLBs[i] = lbs.get(i);
		}
		return allLBs;
	}
		public LifeBlock getLifeBlockByCompany(String company)
	{
		return new LifeBlockRepositoryImpl().getLifeBlockByCompany(company);
	}
	public LifeBlock[] getLifeBlocksOf(String userName)
	{		
		ArrayList<LifeBlock> lbs = new LifeBlockRepositoryImpl().getLifeBlocksOf(userName);
		LifeBlock[] allULBs = new LifeBlock[lbs.size()];
		for(int i = 0; i < lbs.size(); ++i)
		{
			allULBs[i] = lbs.get(i);
		}
		return allULBs;
	}
	public LifeBlock[] getLifeBlocksNotOf(String userName)
	{		
		ArrayList<LifeBlock> lbs = new LifeBlockRepositoryImpl().getLifeBlocksNotOf(userName);
		LifeBlock[] allULBs = new LifeBlock[lbs.size()];
		for(int i = 0; i < lbs.size(); ++i)
		{
			allULBs[i] = lbs.get(i);
		}
		return allULBs;
	}
	public int insertLifeBlock(LifeBlock lB)
	{
		return new LifeBlockRepositoryImpl().insertLifeBlock(lB);
	}
	public void updateLifeBlock(LifeBlock lB)
	{
		new LifeBlockRepositoryImpl().updateLifeBlock(lB);
	}
	public void deleteLifeBlock(LifeBlock lB)
	{
		new LifeBlockRepositoryImpl().deleteLifeBlock(lB);
	}
	
	// MICROUSER //
	public MicroUser GetAccFromUnameAndCompany(String username, String company)
	{
		return new MicroUsrRepositoryimpl().getAccFromUsrnameAndCompany(username, company);
	}
	public boolean isMUsernameAvailable(String username)
	{
		return new MicroUsrRepositoryimpl().isMUsernameAvailable(username);
	}
	public void updateMicroUser(MicroUser mU)
	{
		new MicroUsrRepositoryimpl().updateMUser(mU);
	}
	public void insertMicroUser(MicroUser mU, int UID, int LBID)
	{
		new MicroUsrRepositoryimpl().insertMUser(mU, UID, LBID);
	}
	public void deleteMicroUser(String username, String company)
	{
		new MicroUsrRepositoryimpl().deleteMUser(username, company);
	}
	public MicroUser[] GetMicroAcctsFromUname(String usrname)
	{
		ArrayList<MicroUser> almusers = new MicroUsrRepositoryimpl().getAcctsFromUsername(usrname);
		if(almusers != null)
		{
			MicroUser[] amusers = new MicroUser[almusers.size()];
			for(int i = 0; i < almusers.size(); ++i)
			{
				amusers[i] = almusers.get(i);
			}
			return amusers;
		}
		else 
		return new MicroUser[0];
	}
	
	// Users //
	
	public User[] getAllUsers()
	{
		ArrayList<User> users = new UserRepositoryImpl().getAllUsers();
		User[] allUsers = new User[users.size()];
		for(int i = 0; i < users.size(); ++i)
		{
			allUsers[i] = users.get(i);
		}
		return allUsers;
	}
	public User getUserByUsername(String name)
	{
		return new UserRepositoryImpl().getUserByUsername(name);
	}
	public boolean isUserNameFree(String un)
	{
		return new UserRepositoryImpl().isUserNameFree(un);
	}
	public int insertUser(User u)
	{
		return new UserRepositoryImpl().insertUser(u);
	}
	public void deleteUser(User u)
	{
		new UserRepositoryImpl().deleteUser(u);
	}
	public void updateUser(User u)
	{
		new UserRepositoryImpl().updateUser(u);	
	}
}
