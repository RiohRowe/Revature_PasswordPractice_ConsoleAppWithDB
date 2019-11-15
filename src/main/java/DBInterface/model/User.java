package DBInterface.model;

import java.util.Arrays;

public class User 
{
	private int m_UID;
	private int[] m_eExpLvl;
	private int[] m_cExpLvl;
	private int[] m_mExpLvl;
	private String m_FirstName;
	private String m_LastName;
	private String m_UserName;
	private String m_Email;
	private String m_EnPasswd;
	private long m_RandomSeed;
	private boolean m_LoggedIn;
	private boolean m_Admin;
	
	//CONSTRUCTORS//
	public User(String firstName, String lastName, String usrName, String email, String enPasswd, long randomSeed)
	{
		m_FirstName = firstName;
		m_LastName = lastName;
		m_UserName = usrName;
		m_Email = email;
		m_EnPasswd = enPasswd;
		m_RandomSeed = randomSeed;
		
		m_eExpLvl = new int[] {0,10,1,10};		
		m_cExpLvl = new int[] {0,10,1,10};		
		m_mExpLvl = new int[] {0,10,1,10};
		
		m_LoggedIn = false;
		m_Admin = false;
		m_UID = 0;
	}
	
	public User(int UID, String firstName, String lastName, String usrName, String email, String enPasswd, long randomSeed,
				int eXp, int eLvl, int cXp, int cLvl, int mXp, int mLvl, boolean loggedIn, boolean admin )
	{
		m_UID = UID;
		m_FirstName = firstName;
		m_LastName = lastName;
		m_UserName = usrName;
		m_Email = email;
		m_EnPasswd = enPasswd;
		m_RandomSeed = randomSeed;
		
		m_eExpLvl = new int[] {eXp,lvltoexpblock(eLvl),eLvl,10};		
		m_cExpLvl = new int[] {cXp,lvltoexpblock(cLvl),cLvl,10};		
		m_mExpLvl = new int[] {mXp,lvltoexpblock(mLvl),mLvl,10};
		
		m_LoggedIn = loggedIn;
		m_Admin = admin;
	}
	
	//  METHODS //
	
	private int lvltoexpblock(int lvl)
	{
		int i = 1;
		for(int j = 1; j < lvl; j++)
		{i*=2;}
		return i * 10;
	}

	public int[] getM_eExpLvl() 
	{
		return m_eExpLvl;
	}

	public void setM_eExpLvl(int[] m_eExpLvl) 
	{
		this.m_eExpLvl = m_eExpLvl;
	}

	public int[] getM_cExpLvl() 
	{
		return m_cExpLvl;
	}

	public void setM_cExpLvl(int[] m_cExpLvl) 
	{
		this.m_cExpLvl = m_cExpLvl;
	}

	public int[] getM_mExpLvl() 
	{
		return m_mExpLvl;
	}

	public void setM_mExpLvl(int[] m_mExpLvl) 
	{
		this.m_mExpLvl = m_mExpLvl;
	}

	public String getM_FirstName() 
	{
		return m_FirstName;
	}

	public void setM_FirstName(String m_FirstName) 
	{
		this.m_FirstName = m_FirstName;
	}

	public String getM_LastName() 
	{
		return m_LastName;
	}

	public void setM_LastName(String m_LastName) 
	{
		this.m_LastName = m_LastName;
	}

	public String getM_UserName() 
	{
		return m_UserName;
	}

	public void setM_UserName(String m_UserName) 
	{
		this.m_UserName = m_UserName;
	}

	public String getM_Email() 
	{
		return m_Email;
	}

	public void setM_Email(String m_Email) 
	{
		this.m_Email = m_Email;
	}

	public boolean isM_LoggedIn() 
	{
		return m_LoggedIn;
	}

	public void setM_LoggedIn(boolean m_LoggedIn) 
	{
		this.m_LoggedIn = m_LoggedIn;
	}

	public String getM_EnPasswd() 
	{
		return m_EnPasswd;
	}

	public long getM_RandomSeed() 
	{
		return m_RandomSeed;
	}

	public boolean isM_Admin() 
	{
		return m_Admin;
	}
	public int getUID()
	{
		return m_UID;
	}
	public void setUID(int newID)
	{
		if(0 < newID && m_UID == 0)
		{
			m_UID = newID;
		}
	}
	public void setAdminStatus(boolean admin)
	{
		m_Admin = admin;
	}

	@Override
	public String toString() {
		return "User [m_UID=" + m_UID + ", m_eExpLvl=" + Arrays.toString(m_eExpLvl) + ", m_cExpLvl="
				+ Arrays.toString(m_cExpLvl) + ", m_mExpLvl=" + Arrays.toString(m_mExpLvl) + ", m_FirstName="
				+ m_FirstName + ", m_LastName=" + m_LastName + ", m_UserName=" + m_UserName + ", m_Email=" + m_Email
				+ ", m_EnPasswd=" + m_EnPasswd + ", m_RandomSeed=" + m_RandomSeed + ", m_LoggedIn=" + m_LoggedIn
				+ ", m_Admin=" + m_Admin + "]\n";
	}
	
}
