package DBInterface.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import DBInterface.model.LifeBlock;
import DBInterface.util.ConnectionClosers;
import DBInterface.util.ConnectionFactory;

public class LifeBlockRepositoryImpl implements LifeBlockRepository 
{

	@Override
	public ArrayList<LifeBlock> getAllLifeBlocks() 
	{
		ArrayList<LifeBlock> LBs = new ArrayList<LifeBlock>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		final String SQL = "select LBID, Logo_url, Company, Give_Entertainment"+
								", Give_Cool_Stuff, Give_Money, Point_Value fr"+
								"om public.LifeBlock";
		
		// GET CONNECTION WITH DB //
		try 
		{
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			// PASS SQL STATEMENT TO DB //
			set = stmt.executeQuery(SQL); //This returns a ResultSet
			
			while(set.next()) 
			{
				LBs.add(
						new LifeBlock(
								set.getInt(1),// # = index into sql results
								set.getString(2), //Starts at 1, not 0.
								set.getString(3),
								set.getBoolean(4),
								set.getBoolean(5),
								set.getBoolean(6),
								set.getInt(7)
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
		return LBs;
	}

	@Override
	public LifeBlock getLifeBlockByCompany(String company) 
	{
		LifeBlock LB = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		
		// GET CONNECTION WITH DB //
		try 
		{
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement("select * from LifeBlock where Company = ?");
			stmt.setString(1, company);
			// PASS SQL STATEMENT TO DB //
			set = stmt.executeQuery(); //This returns a ResultSet
			while(set.next())
			{
				LB = new LifeBlock(	set.getInt(1),// # = index into sql results
									set.getString(2), //Starts at 1, not 0.
									set.getString(3),
									set.getBoolean(4),
									set.getBoolean(5),
									set.getBoolean(6),
									set.getInt(7)
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
		return LB;
	}

	@Override
	public ArrayList<LifeBlock> getLifeBlocksOf(String userName) 
	{
		
		ArrayList<LifeBlock> LBs = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		
		// GET CONNECTION WITH DB //
		try 
		{
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement("select LB.* from LifeBlock as LB left join (SELECT"+
				 	"  LBP.LBID, p.usrname FROM Player AS P left JOIN "+
				 	"LBCompositeP AS LBP ON P.UID = LBP.UID) as r1 on "+
				 	"LB.LBID = r1.LBID where r1.Usrname = ?");
			stmt.setString(1,userName);
			// PASS SQL STATEMENT TO DB //
			set = stmt.executeQuery(); //This returns a ResultSet
			
			while(set.next()) 
			{
				LBs.add(
						new LifeBlock(
								set.getInt(1),// # = index into sql results
								set.getString(2), //Starts at 1, not 0.
								set.getString(3),
								set.getBoolean(4),
								set.getBoolean(5),
								set.getBoolean(6),
								set.getInt(7)
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
		return LBs;
	}
	
	@Override
	public ArrayList<LifeBlock> getLifeBlocksNotOf(String userName) 
	{
		
		ArrayList<LifeBlock> LBs = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		
		// GET CONNECTION WITH DB //
		try 
		{
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement("select * from LifeBlock except (sel"+
			"ect LB.* from LifeBlock as LB left join (SELECT  LBP.LBID, p.usr"+
			"name FROM Player AS P left JOIN LBCompositeP AS LBP ON P.UID = L"+
			"BP.UID) as r1 on LB.LBID = r1.LBID where r1.Usrname = ?)");
			stmt.setString(1,userName);

			// PASS SQL STATEMENT TO DB //
			set = stmt.executeQuery(); //This returns a ResultSet
			
			while(set.next()) 
			{
				LBs.add(
						new LifeBlock(
								set.getInt(1),// # = index into sql results
								set.getString(2), //Starts at 1, not 0.
								set.getString(3),
								set.getBoolean(4),
								set.getBoolean(5),
								set.getBoolean(6),
								set.getInt(7)
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
		return LBs;
	}


	@Override
	public int insertLifeBlock(LifeBlock lB) 
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
						"insert into LifeBlock values(default, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1, lB.getImgURL());
			stmt.setString(2, lB.getCompany());
			stmt.setBoolean(3, lB.givesEn());
			stmt.setBoolean(4, lB.givesCS());
			stmt.setBoolean(5, lB.givesMo());
			stmt.setInt(6, lB.getPointValue());
			
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
					"select LBID from LifeBlock where company = ?");
			stmt.setString(1, lB.getCompany());
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
	public void updateLifeBlock(LifeBlock lB) 
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		// GET CONNECTION WITH DB //
		try 
		{
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(
				"update only LifeBlock set Logo_url = ?, Company = ?, Give_En"+
				"tertainment = ?, Give_Cool_Stuff = ?, Give_Money = ?,"+
				" Point_Value = ? where LBID = ?;");
			stmt.setString(1, lB.getImgURL());
			stmt.setString(2, lB.getCompany());
			stmt.setBoolean(3, lB.givesEn());
			stmt.setBoolean(4, lB.givesCS());
			stmt.setBoolean(5, lB.givesMo());
			stmt.setInt(6, lB.getPointValue());
			stmt.setInt(7, lB.getID());
			
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
	public void deleteLifeBlock(LifeBlock lB) 
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		// GET CONNECTION WITH DB //
		try 
		{
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(
				"Delete from LifeBlock where LBID = ?;");
			stmt.setInt(1, lB.getID());
			
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
