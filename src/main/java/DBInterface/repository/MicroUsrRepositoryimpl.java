package DBInterface.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DBInterface.model.MicroUser;
import DBInterface.util.ConnectionClosers;
import DBInterface.util.ConnectionFactory;

public class MicroUsrRepositoryimpl implements MicroUsrRepository {

	@Override
	public MicroUser getAccFromUsrnameAndCompany(String usrname, String company) 
	{
		MicroUser acc = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		
		// GET CONNECTION WITH DB //
		try 
		{
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(
				"select a.* from (select lbp.* from lbcompositep as lbp "+
				"inner join player as p on lbp.uid = p.uid where p.usrname = "+
				"?)as a inner join LifeBlock as b on a.lbid = b.lbid where "+
				"b.company = ?;");
			stmt.setString(1, usrname);
			stmt.setString(2, company);
			// PASS SQL STATEMENT TO DB //
			set = stmt.executeQuery(); //This returns a ResultSet
			while(set.next()) 
			{
				System.out.println(set.getRow());
				acc = new MicroUser(
					set.getString(3),
					set.getString(4),
					set.getString(5),
					set.getLong(6)
				);
			}
		} 
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
		// CLOSE CONNECTION WITH DB //
		finally
		{
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
			ConnectionClosers.closeResultSet(set);
		}
		return acc;
	}

	@Override
	public boolean isMUsernameAvailable(String usrname) 
	{
		boolean nameFree = false;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		try
		{
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement("select count(UID) from LBCompositeP where lbusername = ?");
			stmt.setString(1, usrname);
			set = stmt.executeQuery();
			while(set.next())
			{
				if(set.getInt(1) == 0)
				{
					nameFree = true;
				}
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
			ConnectionClosers.closeResultSet(set);
		}		
		return nameFree;
	}

	@Override
	public void updateMUser(MicroUser mU) 
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		// GET CONNECTION WITH DB //
		try 
		{
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(
				"update only LBCompositeP set LBUserName = ?, "+
				"LBPassWord = ?, LBEmail = ? LBRandomSeed = ?");
			stmt.setString(1, mU.getM_UserName());
			stmt.setString(2, mU.getM_EnPasswd());
			stmt.setString(3, mU.getM_Email());
			stmt.setLong(4, mU.getM_RandomSeed());
			// PASS SQL STATEMENT TO DB //
			stmt.execute(); 
				
		} 
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
		// CLOSE CONNECTION WITH DB //
		finally
		{
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
		}
	}

	@Override
	public void insertMUser(MicroUser mU, int UID, int LBID) 
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		// GET CONNECTION WITH DB //
		try 
		{
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(
						"insert into LBCompositeP values(?, ?, ?, ?, ?, ?)");
			stmt.setInt(1, UID);
			stmt.setInt(2, LBID);
			stmt.setString(3, mU.getM_UserName());
			stmt.setString(4, mU.getM_EnPasswd());
			stmt.setString(5, mU.getM_Email());
			stmt.setLong(6, mU.getM_RandomSeed());
			
			
			// PASS SQL STATEMENT TO DB //
			stmt.execute(); 

		} 
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
		// CLOSE CONNECTION WITH DB //
		finally
		{
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
		}
	}

	@Override
	public void deleteMUser(String username, String company) 
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		// GET CONNECTION WITH DB //
		try 
		{
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(
				"delete from LBCompositeP where LBID = (select LBID from "+
				"LifeBlock where company = ?) and UID = (select UID from "+
				"Player where usrname = ?)");
			stmt.setString(1, company);
			stmt.setString(2, username);
			
			// PASS SQL STATEMENT TO DB //
			stmt.execute(); 
				
		} 
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
		// CLOSE CONNECTION WITH DB //
		finally
		{
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
		}		
	}

	@Override
	public ArrayList<MicroUser> getAcctsFromUsername(String usrname) 
	{
		ArrayList<MicroUser> acc = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		
		// GET CONNECTION WITH DB //
		try 
		{
			acc = new ArrayList<>();
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(
				"select a.* from lbcompositep as a inner join player as b "+
				"on a.uid = b.uid where b.usrname = ?");
			stmt.setString(1, usrname);
			// PASS SQL STATEMENT TO DB //
			set = stmt.executeQuery(); //This returns a ResultSet
			while(set.next()) 
			{
				System.out.println("IN WHILE LOOP");
				acc.add(new MicroUser(
					set.getString(3),
					set.getString(4),
					set.getString(5),
					set.getLong(6)
					)
				);
			}
		} 
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
		// CLOSE CONNECTION WITH DB //
		finally
		{
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
			ConnectionClosers.closeResultSet(set);
		}
		return acc;
	}
}
