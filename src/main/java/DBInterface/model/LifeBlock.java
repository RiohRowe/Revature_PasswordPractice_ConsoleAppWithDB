package DBInterface.model;

import javax.swing.ImageIcon;

public class LifeBlock 
{
	private int m_LBID;//DatabaseID
	private ImageIcon m_logo;
	private String m_ImgURL;
	private String m_company;
	private byte m_pointType;
	private byte m_pointAmount;
	public static String BaseURL = "C:\\Users\\rrowe\\Desktop\\Repos\\"+
									"Main&BranchRepoForClass\\082619jwa\\"+
									"Week01\\Proj0\\myProject0\\P0\\src\\"+
									"main\\java\\GUIInterface\\Imgs\\";
	
	//   CONSTRUCTOR   //
	
	public LifeBlock(ImageIcon logo, String company, 	boolean entertainment,
									 boolean coolStuff, boolean money, 
									 int v)
	{
		m_logo = logo;
		m_ImgURL = "";
		m_company = company;
		m_pointType = 0;
		if(entertainment)
		{
			m_pointType = (byte)(m_pointType | 1);
		}
		if(coolStuff)
		{
			m_pointType = (byte)(m_pointType | 2);
		}		
		if(money)
		{
			m_pointType = (byte)(m_pointType | 4);
		}
		m_pointAmount = (byte)v;
		m_LBID = 0;
	}
	
	public LifeBlock(int DBID, 	String logoURL, 		String company,
								boolean entertainment, 	boolean coolStuff, 
								boolean money, 			int v)
	{
		m_LBID = DBID;
		m_logo = new ImageIcon(BaseURL + logoURL);
		m_ImgURL = logoURL;
		m_company = company;
		m_pointType = 0;
		if(entertainment)
		{
			m_pointType = (byte)(m_pointType | 1);
		}
		if(coolStuff)
		{
			m_pointType = (byte)(m_pointType | 2);
		}		
		if(money)
		{
			m_pointType = (byte)(m_pointType | 4);
		}
		m_pointAmount = (byte)v;
	}
	
	//   Methods   //

	public ImageIcon getLogo()
	{
		return m_logo;
	}
	public String getCompany()
	{
		return m_company;
	}
	public byte getPointValue()
	{
		return m_pointAmount;
	}
	public byte getNumFits()
	{
		byte fits = (byte)0;
		if((m_pointType & 1) > 0)
		{
			fits++;
		}
		if((m_pointType & 2) > 0)
		{
			fits++;
		}
		if((m_pointType & 4) > 0)
		{
			fits++;
		}
		return fits;
	}
	public boolean givesEn()
	{
		return ((m_pointType & 1)>0);
	}
	public boolean givesCS()
	{
		return ((m_pointType & 2)>0);
	}
	public boolean givesMo()
	{
		return ((m_pointType & 4)>0);
	}
	public int getID()
	{
		return m_LBID;
	}
	public String getImgURL()
	{
		return m_ImgURL;
	}
	public void setUID(int newID)
	{
		if(0 < newID && m_LBID == 0)
		{
			m_LBID = newID;
		}
	}

	@Override
	public String toString() {
		return "LifeBlock [m_LBID=" + m_LBID + ", m_logo=" + m_logo + ", m_ImgURL=" + m_ImgURL + ", m_company="
				+ m_company + ", m_pointType=" + m_pointType + ", m_pointAmount=" + m_pointAmount + "]\n";
	}
	
}
