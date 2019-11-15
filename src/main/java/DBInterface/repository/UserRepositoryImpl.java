package DBInterface.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DBInterface.model.LifeBlock;
import DBInterface.model.User;
import DBInterface.util.ConnectionClosers;
import DBInterface.util.ConnectionFactory;

public class UserRepositoryImpl implements UserRepository 
{

	@Override
	public ArrayList<User> getAllUsers() 
	{
		ArrayList<User> players = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		String sql = "Select * from Player";
		try
		{
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			set = stmt.executeQuery(sql);
			
			while(set.next())
			{
				players.add(
					new User(
						set.getInt(1),
						set.getString(2), 
						set.getString(3), 
						set.getString(4), 
						set.getString(5), 
						set.getString(6), 
						set.getLong(9), 
						set.getInt(10), 
						set.getInt(11), 
						set.getInt(12), 
						set.getInt(13), 
						set.getInt(14), 
						set.getInt(15), 
						set.getBoolean(7), 
						set.getBoolean(8)
					)
				);
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
		return players;
	}

	@Override
	public User getUserByUsername(String Name) 
	{
		User player = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		// GET CONNECTION WITH DB //
		try 
		{
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement("select * from Player where UsrName = ?");
			stmt.setString(1, Name);
			// PASS SQL STATEMENT TO DB //
			set = stmt.executeQuery(); //This returns a ResultSet
			while(set.next())
			{	
				System.out.println("UID from DB = " + set.getInt(1));
				player = new User(
					set.getInt(1),
					set.getString(2), 
					set.getString(3), 
					set.getString(4), 
					set.getString(5), 
					set.getString(6), 
					set.getLong(9), 
					set.getInt(10), 
					set.getInt(11), 
					set.getInt(12), 
					set.getInt(13), 
					set.getInt(14), 
					set.getInt(15), 
					set.getBoolean(7), 
					set.getBoolean(8)
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
		return player;
	}

	@Override
	public boolean isUserNameFree(String un) 
	{
		boolean namefree = false;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		try
		{
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement("select count(UID) from player where usrname = ?");
			stmt.setString(1, un);
			set = stmt.executeQuery();
			while(set.next())
			{
				if(set.getInt(1) == 0)
				{
					namefree = true;
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
		return namefree;
	}

	@Override
	public int insertUser(User u) 
	{
		int newID = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		// GET CONNECTION WITH DB //
		try 
		{
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(
						"insert into player values(default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1, u.getM_FirstName());
			stmt.setString(2, u.getM_LastName());
			stmt.setString(3, u.getM_UserName());
			stmt.setString(4, u.getM_Email());
			stmt.setString(5, u.getM_EnPasswd());
			stmt.setBoolean(6, u.isM_LoggedIn());
			stmt.setBoolean(7, u.isM_Admin());
			stmt.setLong(8, u.getM_RandomSeed());
			stmt.setInt(9, u.getM_eExpLvl()[0]);
			stmt.setInt(10, u.getM_eExpLvl()[2]);
			stmt.setInt(11, u.getM_cExpLvl()[0]);
			stmt.setInt(12, u.getM_cExpLvl()[2]);
			stmt.setInt(13, u.getM_mExpLvl()[0]);
			stmt.setInt(14, u.getM_mExpLvl()[2]);
			
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
		try 
		{
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(
				"select UID from player where UsrName = ?");
			stmt.setString(1, u.getM_UserName());
			set = stmt.executeQuery();
			while(set.next())
			{
				newID = set.getInt(1);
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
		return newID;
	}

	@Override
	public void deleteUser(User u) 
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		// GET CONNECTION WITH DB //
		try 
		{
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(
				"Delete from Player where UID = ?;");
			stmt.setInt(1, u.getUID());
			
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
	public void updateUser(User u) 
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		// GET CONNECTION WITH DB //
		try 
		{
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(
				"update only Player set FirstName = ?, LastName = ?, "+
				"UsrName = ?, Email = ?, EPass = ?, LoggedIn = ?, "+
				"IsAdmin = ?, RandomSeed = ?, Entertainment_xp = ?, "+
				"Entertainment_lvl = ?, CoolStuff_xp = ?, CoolStuff_lvl = ?, "+
				"Money_xp = ?, Money_lvl = ? where uid = ?;");
			stmt.setString(1, u.getM_FirstName());
			stmt.setString(2, u.getM_LastName());
			stmt.setString(3, u.getM_UserName());
			stmt.setString(4, u.getM_Email());
			stmt.setString(5, u.getM_EnPasswd());
			stmt.setBoolean(6, u.isM_LoggedIn());
			stmt.setBoolean(7, u.isM_Admin());
			stmt.setLong(8, u.getM_RandomSeed());
			stmt.setInt(9, u.getM_eExpLvl()[0]);
			stmt.setInt(10, u.getM_eExpLvl()[2]);
			stmt.setInt(11, u.getM_cExpLvl()[0]);
			stmt.setInt(12, u.getM_cExpLvl()[2]);
			stmt.setInt(13, u.getM_mExpLvl()[0]);
			stmt.setInt(14, u.getM_mExpLvl()[2]);
			stmt.setInt(15, u.getUID());
			
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
}