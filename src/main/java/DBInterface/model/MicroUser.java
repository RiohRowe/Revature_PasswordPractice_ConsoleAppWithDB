package DBInterface.model;

public class MicroUser 
{
	private String m_UserName;
	private String m_EnPasswd;
	private String m_Email;
	private long m_RandomSeed;
	public MicroUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MicroUser(String m_UserName, String m_EnPasswd, String m_Email, long m_RandomSeed) {
		super();
		this.m_UserName = m_UserName;
		this.m_EnPasswd = m_EnPasswd;
		this.m_Email = m_Email;
		this.m_RandomSeed = m_RandomSeed;
	}
	public String getM_UserName() {
		return m_UserName;
	}
	public void setM_UserName(String m_UserName) {
		this.m_UserName = m_UserName;
	}
	public String getM_Email() {
		return m_Email;
	}
	public void setM_Email(String m_Email) {
		this.m_Email = m_Email;
	}
	public String getM_EnPasswd() {
		return m_EnPasswd;
	}
	public long getM_RandomSeed() {
		return m_RandomSeed;
	}
	@Override
	public String toString() {
		return "MicroUser [m_UserName=" + m_UserName + ", m_EnPasswd=" + m_EnPasswd + ", m_Email=" + m_Email
				+ ", m_RandomSeed=" + m_RandomSeed + "]\n";
	}
	
	
}
