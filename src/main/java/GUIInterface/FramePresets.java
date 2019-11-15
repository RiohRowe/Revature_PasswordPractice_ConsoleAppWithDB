package GUIInterface;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.prefs.BackingStoreException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import org.mindrot.jbcrypt.BCrypt;

import DBInterface.model.LifeBlock;
import DBInterface.model.MicroUser;
import DBInterface.model.User;
import DBInterface.service.SessionService;

public class FramePresets 
{
	static ImageIcon m_Logo = new ImageIcon(
		"C:\\Users\\rrowe\\Desktop\\Repos\\Main&BranchRepoForClass\\082619jwa"+
		"\\Week01\\Proj0\\myProject0\\P0\\src\\main\\java\\GUIInterface\\Imgs"+
		"\\wavy2");
	static String m_company = "LifePass";
	static CustomFrame mainframe;
	static String SeedStr(String s, long l)
	{
		String salt = BCrypt.gensalt();
		return BCrypt.hashpw(s, salt);	
		//string to byte array
//		byte[] oldStringRep = s.getBytes();
//		
//		return new String(oldStringRep);
		
			//string to byte array
//		byte[] oldStringRep = s.getBytes();
//			//Break byte array of string into 8 byte chunks
//		byte[][] strbytes = new byte[(oldStringRep.length+7)/8][8];
//		for(int i = 0; i < strbytes.length; i++)
//		{
//			for(int j = 0; j < 8; j++)
//			{
//				System.out.println(i + " i , j " + j);
//				strbytes[i][j] = oldStringRep[(i*8)+j];
//			}
//		}
//			//byte array to long
//		long strLongs[] = new long[strbytes.length];
//		for(int i = 0; i < strLongs.length; i++)
//		{
//			for(int j = 0; j < strbytes[i].length; j++)
//			{
//				strLongs[i] = (strLongs[i] << 8) + (strbytes[i][j] & 0xff);
//			}
//		}
//		System.out.println("inbound Long = " + strLongs[0]);
//			//long to newLong		
//		long newStringRep[] = new long[strLongs.length];
//		for(int i = 0; i < strLongs.length; i++)
//		{
//			newStringRep[i] = strLongs[i] ^ l;
//			System.out.println("outbound long = " + newStringRep[i]);
//		}
//			//newLong to buffer
//		ByteBuffer buffer[] = new ByteBuffer[newStringRep.length];
//		StringBuilder newString = new StringBuilder();
//		for(int i = 0; i < buffer.length; i++)
//		{
//			buffer[i] = ByteBuffer.allocate(Long.BYTES);
//			buffer[i].putLong(newStringRep[i]);
//    		//buffer to newString
//			newString.append(new String(buffer[i].array()));
//			System.out.println("new String stage [" + i + "] = " + newString);
//		}	
//		return newString.toString();
		
	}
}

//==============================================================================================================//
class CreateAccount
{
	static private int spacing = 20;
	static private int sH = 50;
	static private int sW = 200;
	static private int topspacing = 40;
	static private CustomFrame frame;
	
	public CreateAccount(String company, ImageIcon logoimg, CustomFrame f)
	{
		frame = f;
		
		int Vsp = spacing;
		int Hsp = (sW*3)/2;
	
		CustomLabel title = new CustomLabel("ACCOUNT CREATION", (Hsp*2)-((spacing*2)+
												logoimg.getIconWidth() + (sW*2)), 
												Vsp, sW*2, sH, 6, (int)((float)sH * (5f/8f)));
		CustomLabel logo = new CustomLabel(company, logoimg, (Hsp*2)-(logoimg.getIconWidth()+spacing), Vsp);
		Vsp+=(spacing + sH);

		CustomLabel firstNamel = new CustomLabel("FirstName:", Hsp - (sW + (spacing/2)), Vsp, sW, sH, 2);
		CustomTextField firstNamet = new CustomTextField(Hsp +(spacing/2), Vsp, sW, sH, "FN", null);
		Vsp+=(spacing + sH);	
		CustomLabel lastNamel = new CustomLabel("LastName:", Hsp - (sW + (spacing/2)), Vsp, sW, sH, 2);
		CustomTextField lastNamet = new CustomTextField(Hsp +(spacing/2), Vsp, sW, sH, "LN", null);
		Vsp+=(spacing + sH);	
		CustomLabel userNamel = new CustomLabel("UserName:", Hsp - (sW + (spacing/2)), Vsp, sW, sH, 2);
		CustomTextField userNamet = new CustomTextField(Hsp +(spacing/2), Vsp, sW, sH, "UN", null);
		Vsp+=(spacing + sH);	
		CustomLabel passWordl1 = new CustomLabel("Password:", Hsp - (sW + (spacing/2)), Vsp, sW, sH, 2);
		CustomTextField passWordt1 = new CustomTextField(Hsp +(spacing/2), Vsp, sW, sH, "P", null);
		Vsp+=(spacing + sH);
		CustomLabel passWordl2 = new CustomLabel("Password:", Hsp - (sW + (spacing/2)), Vsp, sW, sH, 2);
		CustomTextField passWordt2 = new CustomTextField(Hsp +(spacing/2), Vsp, sW, sH, "P", null);
		Vsp+=(spacing + sH);
		CustomLabel emaill = new CustomLabel("Email:", Hsp - (sW + (spacing/2)), Vsp, sW, sH, 2);
		CustomTextField emailt = new CustomTextField(Hsp +(spacing/2), Vsp, sW, sH, "E", null);
		Vsp+=(spacing + sH);
		CustomButton submit = new CustomButton("Submit", spacing, Vsp, sW, sH);
		CustomButton back = new CustomButton("Back", (Hsp*2)-(sW + spacing), Vsp, sW, sH);

		frame.add(title);
		frame.add(logo);
		frame.add(firstNamel);
		frame.add(firstNamet);
		frame.add(lastNamel);
		frame.add(lastNamet);
		frame.add(userNamel);
		frame.add(userNamet);
		frame.add(passWordl1);
		frame.add(passWordt1);
		frame.add(passWordl2);
		frame.add(passWordt2);
		frame.add(emaill);
		frame.add(emailt);
		frame.add(submit);
		frame.add(back);
		
		submit.getButton().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				Random rand = new Random();
				long l = rand.nextLong();
				String fname = firstNamet.getText();
				String lname = lastNamet.getText();
				String username = userNamet.getText();
				String pass1 = passWordt1.getText();
				String pass2 = passWordt2.getText();
				String email = emailt.getText();				
				//Do Checks
				
				if(validatePassword(pass1, pass2) == 0 && validateUsername(username) == 0 && ValidateEmail(email))
				{
					CustomFrame newframe = new CustomFrame("Passed");
					DialoguePopup passed = new DialoguePopup(newframe, "Account creation successfull!");
					//ToDB
					User newusr = new User(fname, lname, username, email, FramePresets.SeedStr(pass1, l), l);
					SessionService db = new SessionService();
					newusr.setUID(db.insertUser(newusr));
					frame.dispose();
				}
				else
				{
					CustomFrame newframe = new CustomFrame("failed");
					DialoguePopup failed = new DialoguePopup(newframe,"Failed to create acc. Please try again.");
				}
			}          
		}); 
		back.getButton().addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.dispose();
			}          
		}); 

		frame.setSize(Hsp*2 + spacing,Vsp + sH + spacing + topspacing);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
	
	public CreateAccount(User u, LifeBlock l, CustomFrame f)
	{
		frame = f;
		
		int Vsp = spacing;
		int Hsp = (sW*3)/2;
	
		CustomLabel title = new CustomLabel("ACCOUNT CREATION", (Hsp*2)-((spacing*2)+
												l.getLogo().getIconWidth() + (sW*2)), 
												Vsp, sW*2, sH, 6, (int)((float)sH * (5f/8f)));
		CustomLabel logo = new CustomLabel(l.getCompany(), l.getLogo(), (Hsp*2)-(l.getLogo().getIconWidth()+spacing), Vsp);
		Vsp+=(spacing + sH);

//		CustomLabel firstNamel = new CustomLabel("FirstName:", Hsp - (sW + (spacing/2)), Vsp, sW, sH, 2);
//		CustomTextField firstNamet = new CustomTextField(Hsp +(spacing/2), Vsp, sW, sH, "FN", null);
//		Vsp+=(spacing + sH);	
//		CustomLabel lastNamel = new CustomLabel("LastName:", Hsp - (sW + (spacing/2)), Vsp, sW, sH, 2);
//		CustomTextField lastNamet = new CustomTextField(Hsp +(spacing/2), Vsp, sW, sH, "LN", null);
//		Vsp+=(spacing + sH);	
		CustomLabel userNamel = new CustomLabel("UserName:", Hsp - (sW + (spacing/2)), Vsp, sW, sH, 2);
		CustomTextField userNamet = new CustomTextField(Hsp +(spacing/2), Vsp, sW, sH, "UN", null);
		Vsp+=(spacing + sH);	
		CustomLabel passWordl1 = new CustomLabel("Password:", Hsp - (sW + (spacing/2)), Vsp, sW, sH, 2);
		CustomTextField passWordt1 = new CustomTextField(Hsp +(spacing/2), Vsp, sW, sH, "P", null);
		Vsp+=(spacing + sH);
		CustomLabel passWordl2 = new CustomLabel("Password:", Hsp - (sW + (spacing/2)), Vsp, sW, sH, 2);
		CustomTextField passWordt2 = new CustomTextField(Hsp +(spacing/2), Vsp, sW, sH, "P", null);
		Vsp+=(spacing + sH);
		CustomLabel emaill = new CustomLabel("Email:", Hsp - (sW + (spacing/2)), Vsp, sW, sH, 2);
		CustomTextField emailt = new CustomTextField(Hsp +(spacing/2), Vsp, sW, sH, "E", null);
		Vsp+=(spacing + sH);
		CustomButton submit = new CustomButton("Submit", spacing, Vsp, sW, sH);
		CustomButton back = new CustomButton("Back", (Hsp*2)-(sW + spacing), Vsp, sW, sH);

		frame.add(title);
		frame.add(logo);
		frame.add(userNamel);
		frame.add(userNamet);
		frame.add(passWordl1);
		frame.add(passWordt1);
		frame.add(passWordl2);
		frame.add(passWordt2);
		frame.add(emaill);
		frame.add(emailt);
		frame.add(submit);
		frame.add(back);
		
		submit.getButton().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				Random rand = new Random();
				long seed = rand.nextLong();
				String username = userNamet.getText();
				String pass1 = passWordt1.getText();
				String pass2 = passWordt2.getText();
				String email = emailt.getText();				
				//Do Checks
				
				if(validatePassword(pass1, pass2) == 0 && validateUsername(username) == 0 && ValidateEmail(email))
				{
					CustomFrame newframe = new CustomFrame("Passed");
					DialoguePopup passed = new DialoguePopup(newframe, "Account creation successfull!");
					//ToDB
					MicroUser newmusr = new MicroUser(username,FramePresets.SeedStr(pass1, seed) , email, seed);
					SessionService db = new SessionService();
					db.insertMicroUser(newmusr, u.getUID(),l.getID());
					frame.dispose();
					FramePresets.mainframe.dispose();
					FramePresets.mainframe = new CustomFrame("Home - Logged in");
					HomeLoggedIn hli = new HomeLoggedIn(u, FramePresets.mainframe, 2);
				}
				else
				{
					CustomFrame newframe = new CustomFrame("failed");
					DialoguePopup failed = new DialoguePopup(newframe,"Failed to create acc. Please try again.");
				}
			}          
		}); 
		back.getButton().addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.dispose();
			}          
		}); 

		frame.setSize(Hsp*2 + spacing,Vsp + sH + spacing + topspacing);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	//   Methods  //
	
	/*
	 * ValidatePassword()
	 * ValidateEmail()
	 * 
	 */
	
	public int validatePassword(String p1, String p2)
	{
		int numerrs = 0;
		if(p1.compareTo(p2) != 0)
		{
			CustomFrame pwdontmatchf = new CustomFrame("Bad Password");
			DialoguePopup pwdontmatch = new DialoguePopup(pwdontmatchf, "Your passwords did not match.");
			numerrs += 1;
		}
		if(p2.length() < 10)
		{
			CustomFrame pwdontmatchf = new CustomFrame("Bad Password");
			DialoguePopup pwdontmatch = new DialoguePopup(pwdontmatchf, "Your password was not long enough. Minimum length is 10 chars.");
			numerrs += 1;
		}
		//Check realwords
		//Check Uppercase Character
		//Check number character
		//Check special character
		return numerrs;
	}
	public boolean ValidateEmail(String email)
	{
		boolean valid = true;
		if(!email.contains("@") || !email.contains("."))
		{
			CustomFrame pwdontmatchf = new CustomFrame("Bad Email");
			DialoguePopup pwdontmatch = new DialoguePopup(pwdontmatchf, "Let me remind you what an email requires: Name@something.somewhere.");
			valid = false;
		}
		if(email.length() < 5)
		{
			CustomFrame pwdontmatchf = new CustomFrame("Bad Email");
			DialoguePopup pwdontmatch = new DialoguePopup(pwdontmatchf, "Your email looks dumb. Also, it is not long enough.");
			valid  = false;
		}
		return valid;
	}
	public int validateUsername(String username)
	{
		int numerrs = 0;
		SessionService seserv = new SessionService();
		if(!seserv.isMUsernameAvailable(username))
		{
			CustomFrame pwdontmatchf = new CustomFrame("Bad UserName");
			DialoguePopup pwdontmatch = new DialoguePopup(pwdontmatchf, "The Username you inputted is not available.");
			numerrs += 1;
		}
		if(username.length() < 1)
		{
			CustomFrame pwdontmatchf = new CustomFrame("Bad UserName");
			DialoguePopup pwdontmatch = new DialoguePopup(pwdontmatchf, "You must input something for your username.");
			numerrs += 1;
		}		
		
		return numerrs;
	}
}


//==============================================================================================================//

class LogIn
{
	static private int spacing = 20;
	static private int sH = 50;
	static private int sW = 200;
	static private int topspacing = 40;
	static private User m_user;
	static private LifeBlock m_lifeBlock;
	
	public LogIn(String company, ImageIcon logoimg, CustomFrame frame)
	{
		int Vsp = spacing;
		int Hsp = (sW*3)/2;
	
		CustomLabel title = new CustomLabel("LogIn", (Hsp)-(sW/2), 
												Vsp, sW, sH, 6, (int)((float)sH * (5f/8f)));
		title.setTAlign(6); //UPDATING LABLE DOES NOT CENTER THE TEXT.
		CustomLabel logo = new CustomLabel(company, logoimg, (Hsp*2)-(logoimg.getIconWidth()+spacing), Vsp);
		Vsp+=(spacing + sH);
		CustomLabel userNamel = new CustomLabel("UserName:", Hsp - ((3*sW)/4), Vsp, sW/2, sH, 2);
		CustomTextField userNamet = new CustomTextField(Hsp - (sW/4), Vsp, sW, sH, "UserName", null);
		Vsp+=(spacing + sH);	
		CustomLabel passWordl = new CustomLabel("Password:", Hsp - ((3*sW)/4), Vsp, sW/2, sH, 2);
		CustomTextField passWordt = new CustomTextField(Hsp - (sW/4), Vsp, sW, sH, "Password", null);
		Vsp+=(spacing + sH);
		CustomButton submit = new CustomButton("Submit", spacing*2, Vsp, sW, sH);
		CustomButton back = new CustomButton("Back", (Hsp*2)-(sW + (spacing*2)), Vsp, sW, sH);
		Vsp+=(spacing + sH);
		CustomButton forgotP = new CustomButton("Forgot Password", spacing, Vsp, sW, sH);
		CustomButton forgotU = new CustomButton("Forgot Username", (Hsp*2)-(spacing + sW), Vsp, sW, sH);

		title.setBorder(4, "", 0);
		frame.add(title);
		frame.add(logo);
		frame.add(userNamel);
		frame.add(userNamet);
		frame.add(passWordl);
		frame.add(passWordt);
		frame.add(forgotP);
		frame.add(forgotU);
		frame.add(submit);
		frame.add(back);
		
		forgotP.getButton().addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				CustomFrame newframe = new CustomFrame("youfogot.");
				DialoguePopup insult = new DialoguePopup(newframe, 
					"Try using the red pen next time. The red pen never forgets.",
					65, 0, 25);
				System.out.println("I forgot my Password! send to accRecovery");
			}
		});
		
		forgotU.getButton().addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{

				CustomFrame newframe = new CustomFrame("youfogot.");
				DialoguePopup insult = new DialoguePopup(newframe, 
					"Have you tried going back in time and wring it down?",
					66, 0, 30);
				System.out.println("I Forgot My Username! send to accRecovery");
			}
		});
		
		
		submit.getButton().addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				String user = userNamet.getText();
				String pass = passWordt.getText();
				SessionService seserv = new SessionService();
				User usr = seserv.getUserByUsername(user);
				if(usr != null && BCrypt.checkpw(pass, usr.getM_EnPasswd()))
				{
					FramePresets.mainframe.dispose();
					FramePresets.mainframe = new CustomFrame("Home - Logged In");
					HomeLoggedIn li = new HomeLoggedIn(usr, FramePresets.mainframe, 0);
					CustomFrame success = new CustomFrame("Success!");
					DialoguePopup note = new DialoguePopup(success, "You have been successfully logged in.");
					frame.dispose();
					usr.setM_LoggedIn(true);
					seserv.updateUser(usr);
				}
				else
				{
					CustomFrame fail = new CustomFrame("BadCredentials");
					DialoguePopup note = new DialoguePopup(fail, "Your credentials are incorrect. Try again.");
				}
				
			}          
		}); 
		back.getButton().addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.dispose();
			}          
		}); 

		frame.setSize(Hsp*2 + spacing,Vsp + sH + spacing + topspacing);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
	public LogIn(User u, LifeBlock l, CustomFrame frame)
	{
		m_user = u;
		m_lifeBlock = l;
		int Vsp = spacing;
		int Hsp = (sW*3)/2;
	
		CustomLabel title = new CustomLabel("LogIn", (Hsp)-(sW/2), 
												Vsp, sW, sH, 6, (int)((float)sH * (5f/8f)));
		title.setTAlign(6);
		CustomLabel logo = new CustomLabel(l.getCompany(), l.getLogo(), (Hsp*2)-(l.getLogo().getIconWidth()+spacing), Vsp);
		Vsp+=(spacing + sH);
		CustomLabel userNamel = new CustomLabel("UserName:", Hsp - ((3*sW)/4), Vsp, sW/2, sH, 2);
		CustomTextField userNamet = new CustomTextField(Hsp - (sW/4), Vsp, sW, sH, "UserName", null);
		Vsp+=(spacing + sH);	
		CustomLabel passWordl = new CustomLabel("Password:", Hsp - ((3*sW)/4), Vsp, sW/2, sH, 2);
		CustomTextField passWordt = new CustomTextField(Hsp - (sW/4), Vsp, sW, sH, "Password", null);
		Vsp+=(spacing + sH);
		CustomButton submit = new CustomButton("Submit", spacing*2, Vsp, sW, sH);
		CustomButton back = new CustomButton("Back", (Hsp*2)-(sW + (spacing*2)), Vsp, sW, sH);
		Vsp+=(spacing + sH);
		CustomButton forgotP = new CustomButton("Forgot Password", spacing, Vsp, sW, sH);
		CustomButton forgotU = new CustomButton("Forgot Username", (Hsp*2)-(spacing + sW), Vsp, sW, sH);

		title.setBorder(4, "", 0);
		frame.add(title);
		frame.add(logo);
		frame.add(userNamel);
		frame.add(userNamet);
		frame.add(passWordl);
		frame.add(passWordt);
		frame.add(forgotP);
		frame.add(forgotU);
		frame.add(submit);
		frame.add(back);
		
		forgotP.getButton().addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				frame.dispose();
				FramePresets.mainframe.dispose();
				FramePresets.mainframe = new CustomFrame("Home - Logged in");
				HomeLoggedIn hli = new HomeLoggedIn(u, FramePresets.mainframe, 1);
				CustomFrame newframe = new CustomFrame("youfogot.");
				DialoguePopup insult = new DialoguePopup(newframe, 
					"Oh that is too bad. DELETING ACC. Better luck remembering next time.",
					65, 0, 25);
				SessionService seserv = new SessionService();
				seserv.deleteMicroUser(u.getM_UserName(), l.getCompany());
				System.out.println("I forgot my Password! send to accRecovery");
			}
		});
		
		forgotU.getButton().addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				frame.dispose();
				FramePresets.mainframe.dispose();
				FramePresets.mainframe = new CustomFrame("Home - Logged in");
				HomeLoggedIn hli = new HomeLoggedIn(u, FramePresets.mainframe, 1);
				CustomFrame newframe = new CustomFrame("youfogot.");
				DialoguePopup insult = new DialoguePopup(newframe, 
					"That's Ok, a platipus took your file and tried to wear it as a hat. Its gone now.",
					66, 0, 30);
				SessionService seserv = new SessionService();
				seserv.deleteMicroUser(u.getM_UserName(), l.getCompany());
				System.out.println("I Forgot My Username! send to accRecovery");
			}
		});
		
		
		submit.getButton().addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				String user = userNamet.getText();
				String pass = passWordt.getText();
				SessionService seserv = new SessionService();
				MicroUser musr = seserv.GetAccFromUnameAndCompany(u.getM_UserName(), l.getCompany());
				if( musr != null && BCrypt.checkpw(pass, musr.getM_EnPasswd()))
				{
					CustomFrame success = new CustomFrame("Success!");
					CustomFrame lbwf = new CustomFrame(m_lifeBlock.getCompany());
					LifeBlockWork lbw = new LifeBlockWork(m_user, m_lifeBlock, lbwf);
					DialoguePopup note = new DialoguePopup(success, "You have successfully logged in. Careful What button you press.");
					frame.dispose();
				}
				else
				{
					CustomFrame fail = new CustomFrame("BadCredentials");
					DialoguePopup note = new DialoguePopup(fail, "Your credentials are incorrect. Try again.");
				}
				
			}          
		}); 
		back.getButton().addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.dispose();
			}          
		}); 

		frame.setSize(Hsp*2 + spacing,Vsp + sH + spacing + topspacing);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
	
	
	//   Methods  //
	
	/*
	 * Hide()
	 * Show()
	 * 
	 */
	public boolean checkPassword(String username, String passwordtry)
	{
		String userencpassword = "";
		Random rand = new Random();
		String password = "RandomString";
		long enc = rand.nextLong();

		//convert passwordtry with long from user
			//string to byte array
		byte[] b_password = passwordtry.getBytes();
			//byte array to long
		long value = 0;
		for (int i = 0; i < b_password.length; i++)
		{
		   value = (value << 8) + (b_password[i] & 0xff);
		}
			//long to enc long
		long encpswdlong = enc^value;
			//enc long to buffer
	    ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
	    buffer.putLong(encpswdlong);
	    	//buffer to encpassword
	    String encpassword = new String(buffer.array());
	    
	    //compare encpassword to stored encpassword.
	    return encpassword.compareTo(userencpassword) == 0;
	}
}

//==============================================================================================================//
class HomeLoggedIn
{
	String ImgURL = "C:\\Users\\rrowe\\Desktop\\Repos\\Project0\\src\\GUIInterface\\Imgs\\";
	static private int spacing = 20;
	static private int sH = 50;
	static private int sW = 200;
	static private int topspacing = 40;
	private int atHome = 0;	
	//static private int gamebottom;
	static private int Hsp;
	static private int Vsp;
	static private int pindex[]; //Persistent index
	static private int indexref;
	
	
	public HomeLoggedIn(User u, CustomFrame frame, int loc)
	{
		//boolean atHome = false;
		atHome = loc;
		Vsp = spacing;
		Hsp = (3 * sW) + (4 * spacing);
		SessionService seserv = new SessionService();
		
		
		
		ArrayList<LifeBlock> lifeBlocks = new ArrayList<LifeBlock>(Arrays.asList(seserv.getLifeBlocksOf(u.getM_UserName())));
		ArrayList<LifeBlock> lifeBlocksNot = new ArrayList<LifeBlock>(Arrays.asList(seserv.getLifeBlocksNotOf(u.getM_UserName())));
		FrameObj[] homeObjs = new FrameObj[5];
		FrameObj[] gameObjs = new FrameObj[lifeBlocks.size()+2];
		FrameObj[] newgameObjs = new FrameObj[lifeBlocksNot.size()+1];
		
		if(u.isM_Admin())
		{
			CustomButton adminstuff = new CustomButton("A", 0, 0, spacing, spacing);
			frame.add(adminstuff);
			adminstuff.getButton().addActionListener(new ActionListener() 
			{	
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					CustomFrame admintoolsf = new CustomFrame("Admin Tools");
					AdminTools admintools = new AdminTools(u, admintoolsf);
				}
			});
			
		}
		CustomButton home = new CustomButton("HOME", spacing, Vsp, sW/2, sH);
		CustomButton getStarted = new CustomButton("Get Started", (spacing*2)+sW/2, Vsp, sW/2, sH);
		
		CustomLabel gameName = new CustomLabel("NameO' The Game", (spacing*3)+sW,Vsp, Hsp - ((spacing*4)+sW),sH,
															16,30);
		gameName.setBorder(2, "", 0);
		gameName.setTAlign(6);
		
		gameObjs[0] = gameName;
		
		Vsp += sH + spacing;
		
		int lbpr = 5;
		int xCorner = spacing;
		int yCorner = Vsp;
		int width = (sW*2) + spacing;
		int lBSize = (3 * sH)/2;
		int lifeBlockSpacing = (width-(lbpr*lBSize))/(lbpr-1);
		int gamebottom = yCorner + ( (lifeBlocks.size()/lbpr) * (lifeBlockSpacing + lBSize) ) + lBSize + spacing;
				
		
		CustomButton[] lbButtons = new CustomButton[lifeBlocks.size()+1];
		pindex = new int[lifeBlocks.size()];
		for(int i = 0; i < lifeBlocks.size()+1; ++i)
		{
			if(i < lifeBlocks.size())
			{
				try
				{
					lbButtons[i] = new CustomButton(lifeBlocks.get(i).getLogo(), lBSize, lBSize, true); 
					lbButtons[i].setDescription(lifeBlocks.get(i).getCompany());
				}
				catch(IndexOutOfBoundsException e)
				{
					System.out.println("Tried to access too far into my array.");
				}
				pindex[i] = i;
				indexref = i;
				addListenerToButton(lbButtons[i], lifeBlocks.get(i), u, false);
			}
			else
			{
				lbButtons[i] = new CustomButton("NEW", 0, 0, lBSize, lBSize);
				lbButtons[i].getButton().addActionListener(new ActionListener() 
				{
					
					@Override
					public void actionPerformed(ActionEvent e) 
					{
						for(int i = 0; i < newgameObjs.length; i++)
						{
							frame.add(newgameObjs[i]);
						}
						for(int i = 0; i < gameObjs.length; i++)
						{
							frame.remove(gameObjs[i]);
						}

						home.disable();
						frame.refresh();
						
					}
				});
			}
			gameObjs[i+1] = lbButtons[i];
			lbButtons[i].setPos(xCorner + ((i%lbpr)*(lifeBlockSpacing+lBSize)),
									yCorner + ((i/lbpr) * (lBSize + lifeBlockSpacing)));
			lbButtons[i].setFont(39, 0, 12, 6);
			//frame.add(lbButtons[i]);
		}
		
		CustomButton[] lbButtonsNot = new CustomButton[lifeBlocksNot.size()+1];
		for(int i = 0; i < lifeBlocksNot.size(); ++i)
		{
			try
			{
				lbButtonsNot[i] = new CustomButton(lifeBlocksNot.get(i).getLogo(), lBSize, lBSize, true); 
				lbButtonsNot[i].setDescription(lifeBlocksNot.get(i).getCompany());
			}
			catch(IndexOutOfBoundsException e)
			{
				System.out.println("Tried to access too far into my array.");
			}
			
			addListenerToButton(lbButtonsNot[i], lifeBlocksNot.get(i), u,true);
			newgameObjs[i+1] = lbButtonsNot[i];
			lbButtonsNot[i].setPos(xCorner + ((i%lbpr)*(lifeBlockSpacing+lBSize)),
									yCorner + ((i/lbpr) * (lBSize + lifeBlockSpacing)));
			lbButtonsNot[i].setFont(39, 0, 12, 6);
		}		

		
		
		
		CustomLabel score = new CustomLabel("Score:", Hsp - ( sW + spacing), Vsp, sW, sH, 11, 30);
		CustomLabel welcome = new CustomLabel("Welcome home "+u.getM_UserName()+".", xCorner, yCorner, width, sH, 6, 24);
		welcome.setBorder(4, "", 0);
		welcome.setTAlign(6);
		Vsp += sH + spacing;
		
		String welcomMsg = "<html>	This is LifePass. You can click the<br>"
								+ "	\"get started\"button to start managing<br>"
								+ "	your life's passwords, or you can delete<br>"
								+ "	your account.<html>";
		CustomLabel homeDesc = new CustomLabel(welcomMsg, spacing, Vsp, (2*sW) + (spacing), (sH*4)+(spacing*3),
													7, 30);
		CustomLabel entertainment = new CustomLabel("E: "+u.getM_eExpLvl()[0]+
													"/"+u.getM_eExpLvl()[1]+
													"  Lvl "+u.getM_eExpLvl()[2]+
													"/"+u.getM_eExpLvl()[3]+"",
													Hsp - (sW + spacing), Vsp, 
													sW+spacing, sH, 10,20);
		Vsp += sH + spacing;

		CustomLabel coolStuff = new CustomLabel("C: "+u.getM_cExpLvl()[0]+
												"/"+u.getM_cExpLvl()[1]+
												"  Lvl "+u.getM_cExpLvl()[2]+
												"/"+u.getM_cExpLvl()[3]+"",
												Hsp - (sW + spacing), Vsp, 
												sW+spacing, sH, 10,20);
		Vsp += sH + spacing;

		CustomLabel money = new CustomLabel("$: "+u.getM_mExpLvl()[0]+
											"/"+u.getM_mExpLvl()[1]+
											"  Lvl "+u.getM_mExpLvl()[2]+
											"/"+u.getM_mExpLvl()[3]+"",
											Hsp - (sW + spacing), Vsp, 
											sW+spacing, sH, 10,20);
		Vsp += sH + spacing;
		Vsp += sH + spacing;
		
		CustomButton delAcc = new CustomButton("Delete Account", spacing, Vsp, sW, sH);
		CustomButton createAcc = new CustomButton("Create Account", (Hsp/2) - (sW/2), Vsp, sW, sH);
		CustomButton Logout = new CustomButton("Logout",Hsp-(spacing+sW), Vsp, sW, sH);
		CustomButton back = new CustomButton("Back",Hsp-(spacing+sW), Vsp, sW, sH);
		newgameObjs[0] = back;
		Vsp += sH + spacing;

		homeObjs[0] = welcome;
		homeObjs[1] = homeDesc;
		homeObjs[2] = delAcc;
		homeObjs[3] = createAcc;
		homeObjs[4] = Logout;
		
		
		score.setTAlign(6);
		entertainment.setTAlign(6);
		coolStuff.setTAlign(6);
		money.setTAlign(6);
		homeDesc.setTAlign(6);
		

		
		frame.add(home);
		frame.add(getStarted);
		frame.add(score);
		frame.add(entertainment);
		frame.add(coolStuff);
		frame.add(money);

		if(atHome == 0)
		{
			for(int i = 0; i < homeObjs.length; i++)
			{
				frame.add(homeObjs[i]);
			}
			frame.setSize(Hsp + spacing,Vsp + topspacing);
			home.disable();
			frame.refresh();
		}
		else if(atHome == 1)
		{
			for(int i = 0; i < gameObjs.length; i++)
			{
				frame.add(gameObjs[i]);
			}
			frame.setSize(Hsp + spacing,Vsp + topspacing);
			getStarted.disable();
			frame.refresh();
		}
		else
		{
			for(int i = 0; i < newgameObjs.length; i++)
			{
				frame.add(newgameObjs[i]);
			}
			home.disable();
			getStarted.disable();
			frame.refresh();
		}
		home.getButton().addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if(atHome != 0)
				{

					System.out.println("taking you to Home.");
					for(int i = 0; i < homeObjs.length; i++)
					{
						frame.add(homeObjs[i]);
					}
					for(int i = 0; i < gameObjs.length; i++)
					{
						frame.remove(gameObjs[i]);
					}
					frame.setSize(Hsp + spacing,Vsp + topspacing);
					home.disable();
					getStarted.enable();
					frame.refresh();
					atHome = 0;
				}
			}
		});
		
		getStarted.getButton().addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if(atHome == 0)
				{
					System.out.println("Taking you to get started.");
					for(int i = 0; i < gameObjs.length; i++)
					{
						frame.add(gameObjs[i]);
					}
					for(int i = 0; i < homeObjs.length; i++)
					{
						frame.remove(homeObjs[i]);
					}
					if(Vsp > gamebottom)
					{		
						frame.setSize(Hsp + spacing,Vsp + topspacing);
					}
					else
					{
						frame.setSize(Hsp + spacing,gamebottom + topspacing);
					}
					getStarted.disable();
					home.enable();
					frame.refresh();
					atHome = 1;					
				}
			}
		});
		
		
		delAcc.getButton().addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				seserv.deleteUser(u);
				FramePresets.mainframe.dispose();
				FramePresets.mainframe = new CustomFrame("Home - Logged out");
				HomeLoggedOut hlo = new HomeLoggedOut(FramePresets.mainframe);
				CustomFrame insult = new CustomFrame("No Takebacksies in My kingdom");
				DialoguePopup usure = new DialoguePopup(insult, "Oops, Butterfingers... I dropped your file... its broken.");
				System.out.println("Deleteing your account");
				System.out.println("Taking you to Unloggedin Home screen");
			}          
		}); 
		createAcc.getButton().addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				CustomFrame cf = new CustomFrame("Idiot handler");
				DialoguePopup dp = new DialoguePopup(cf, "I swear, I could "+
					"just make a button that says \"does nothing\", and you "+
					"would press it. So gullable...");
				System.out.println("Taking You to Create Account");
			}          
		}); 
		Logout.getButton().addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				u.setM_LoggedIn(false);
				seserv.updateUser(u);
				FramePresets.mainframe.dispose();
				FramePresets.mainframe = new CustomFrame("home - logged out");
				HomeLoggedOut hlo = new HomeLoggedOut(FramePresets.mainframe);
				CustomFrame lo = new CustomFrame("Logging out");
				DialoguePopup pu = new DialoguePopup(lo, "You have logged out.");
			}        
		}); 
		back.getButton().addActionListener(new ActionListener() 
		{	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				for(int i = 0; i < gameObjs.length; i++)
				{
					frame.add(gameObjs[i]);
				}
				for(int i = 0; i < newgameObjs.length; i++)
				{
					//homeObjs[i].hide();
					frame.remove(newgameObjs[i]);
				}
				frame.setSize(Hsp + spacing,Vsp + topspacing);
				home.enable();
				frame.refresh();
			}
		});
		if(Vsp > gamebottom || atHome == 0)
		{		
			frame.setSize(Hsp + spacing,Vsp + topspacing);
		}
		else
		{
			frame.setSize(Hsp + spacing,gamebottom + topspacing);
		}
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	//  METHODS //
	public void addListenerToButton(CustomButton b, LifeBlock l, User u, boolean ca)
	{
		if(ca)
		{
			b.getButton().addActionListener(new ActionListener() 
			{
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					CustomFrame mucaf = new CustomFrame("LifeBlock Login");
					CreateAccount muca = new CreateAccount(u, l, mucaf);
				}
			});
		}
		else
		{
			b.getButton().addActionListener(new ActionListener() 
			{
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					CustomFrame mucaf = new CustomFrame("LifeBlock Login");
					LogIn muca = new LogIn(u, l, mucaf);
				}
			});			
		}
	}
}
//==============================================================================================================//	

class HomeLoggedOut
{
	static private int spacing = 20;
	static private int sH = 50;
	static private int sW = 200;
	static private int topspacing = 40;
	static private int Hsp;
	static private int Vsp;
	
	
	public HomeLoggedOut(CustomFrame frame)
	{
		FramePresets.mainframe = frame;
		Vsp = spacing;
		Hsp = (2 * sW) + (3 * spacing);
			
		CustomButton home = new CustomButton("HOME", spacing, Vsp, sW/2, sH);
		CustomButton getStarted = new CustomButton("Get Started", (spacing*2)+sW/2, Vsp, sW/2, sH);
		Vsp += sH + spacing;
		
		int xCorner = spacing;
		int yCorner = Vsp;
		int width = (sW*2) + spacing;
			
			
			
		CustomLabel welcome = new CustomLabel("Welcome home ... perrson...", xCorner, yCorner, width, sH, 6, 24);
		welcome.setBorder(4, "", 0);
		welcome.setTAlign(6);
		Vsp += sH + spacing;
			
		String welcomMsg = "<html>	This is LifePass. You can click the<br>"
								+ "	\"Log in\"button to get going<br>"
								+  "or you can create a new account by<br>"
								+ "clicking on the \"create Account\"button.<html>";
		CustomLabel homeDesc = new CustomLabel(welcomMsg, spacing, Vsp, (2*sW) + (spacing), (sH*4)+(spacing*3),
													7, 30);
		Vsp += sH + spacing;
		Vsp += sH + spacing;
		Vsp += sH + spacing;
		Vsp += sH + spacing;
			
		CustomButton delAcc = new CustomButton("Delete Account", spacing, Vsp, (2*sW)/3, sH);
		CustomButton createAcc = new CustomButton("Create Account", (Hsp/2) - (sW/3), Vsp, (2*sW)/3, sH);
		CustomButton Login = new CustomButton("Login",Hsp-(spacing+((2*sW)/3)), Vsp, (2*sW)/3, sH);
		Vsp += sH + spacing;

		homeDesc.setTAlign(6);
			

			
		frame.add(home);
		frame.add(getStarted);
		frame.add(welcome);
		frame.add(homeDesc);
		frame.add(delAcc);
		frame.add(createAcc);
		frame.add(Login);
		
			
		home.getButton().addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				CustomFrame insult = new CustomFrame("Idiot Handler");
				DialoguePopup pu = new DialoguePopup(insult, "I will save"+
						" you some time, by letting you know you are"+
						" already there.", 33, 0, 30);
				
				System.out.println("You are home...");
			}
		});
		
		getStarted.getButton().addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				CustomFrame insult = new CustomFrame("Idiot Handler");
				DialoguePopup pu = new DialoguePopup(insult, 
					"Seriously, did you even read my welcome mesage? "+
					"Try logging in.");
				System.out.println("...Nope...");
			}
		});
		
		
		delAcc.getButton().addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{

				CustomFrame insult = new CustomFrame("Idiot Handler");
				DialoguePopup pu = new DialoguePopup(insult, 
					"What account? Maybe you should create one first, "+
					"or log in ya dummy!", 117, 0, 30);
				System.out.println("...What Acount...");
			}          
		}); 
		createAcc.getButton().addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				CustomFrame f = new CustomFrame("New User");
				CreateAccount CA = new CreateAccount(FramePresets.m_company,
										FramePresets.m_Logo, f);
				System.out.println("Taking You to Create Account");
			}          
		}); 
		Login.getButton().addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				CustomFrame f = new CustomFrame("WelcomeBack");
				LogIn lI = new LogIn(FramePresets.m_company,
										FramePresets.m_Logo, f);
				System.out.println("Logging you in.");
			}          
		}); 		
		
		frame.setSize(Hsp + spacing,Vsp + topspacing);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}

//===============================================================================================================================================================================//

class LifeBlockWork
{
	static private int spacing = 20;
	static private int sH = 50;
	static private int sW = 200;
	static private int topspacing = 40;
	static private int Hsp;
	static private int Vsp;
	static private String ent;
	static private String coo;
	static private String mon;
	static private int eExpLvl[] = {0, 10, 0, 10};
	static private int cExpLvl[] = {0, 10, 0, 10};
	static private int mExpLvl[] = {0, 10, 0, 10};
	static private Random rand = new Random();
	static int onex;
	static int oney;
	static int twox;
	static int twoy;
	static int thrx;
	static int thry;
	static SessionService seserv = new SessionService();
	
	
	public LifeBlockWork(User u, LifeBlock l, CustomFrame frame)
	{

		eExpLvl = u.getM_eExpLvl();
		cExpLvl = u.getM_cExpLvl();
		mExpLvl = u.getM_mExpLvl();
		Vsp = spacing;
		Hsp = (2 * sW) + (3 * spacing);
		int tempSW = (2*sW)/3;
		int buttonsize = 65;
		int buttonBound = Hsp-buttonsize;
		
		
		onex = rand.nextInt(buttonBound);
		oney = rand.nextInt(buttonBound);
		twox = rand.nextInt(buttonBound);
		twoy = rand.nextInt(buttonBound);
		thrx = rand.nextInt(buttonBound);
		thry = rand.nextInt(buttonBound);
		CustomButton delete = new CustomButton("Del", onex, oney, buttonsize, buttonsize);
		CustomButton exit = new CustomButton("Exit", twox, twoy, buttonsize, buttonsize);
		CustomButton clickMe = new CustomButton("xp++", thrx, thry, buttonsize, buttonsize);
		while(delete.intersectsHoriz(exit) && (delete.intersectsVirt(exit)))
		{
			twox = rand.nextInt(buttonBound);
			twoy = rand.nextInt(buttonBound);
			exit.setPos(twox, twoy);
		}
		while((clickMe.intersectsHoriz(exit) && clickMe.intersectsVirt(exit)) || 
			  (clickMe.intersectsHoriz(delete) && clickMe.intersectsVirt(delete)))
		{
			thrx = rand.nextInt(buttonBound);
			thry = rand.nextInt(buttonBound);
			clickMe.setPos(thrx, thry);
		}
				
//		CustomButton badground = new CustomButton(	"", rand.nextInt(buttonBound), rand.nextInt(buttonBound), 
//														Hsp , Hsp);

		
		CustomLabel logo = new CustomLabel(l.getCompany(),spacing,spacing,Hsp-(2*spacing),Hsp-(2*spacing),7,40);
		CustomLabel entertainment = new CustomLabel("<html>Entertainment:<br>"+eExpLvl[0]+"/"+eExpLvl[1]+"exp   "+
														eExpLvl[2]+"/"+eExpLvl[3] + "lvl<html>",
														spacing, Hsp + spacing, (2*sW)/3, sH, 5, 12);
		CustomLabel coolStuff = new CustomLabel("<html>Cool Stuff:<br>"+cExpLvl[0]+"/"+cExpLvl[1]+"exp   "+
														cExpLvl[2]+"/"+cExpLvl[3] + "lvl<html>",
														(Hsp/2)-(tempSW/2), Hsp + spacing, tempSW, sH, 5, 12);
		CustomLabel money = new CustomLabel("<html>$$ Money $$:<br>"+mExpLvl[0]+"/"+mExpLvl[1]+"exp   "+
														mExpLvl[2]+"/"+mExpLvl[3] + "lvl<html>",
														Hsp - (tempSW + spacing), Hsp + spacing, tempSW, sH, 5, 12);
		delete.setFont(9, 0, 12, 6);
		exit.setFont(9, 0, 12, 6);
		clickMe.setFont(9, 0, 12, 6);
		logo.setFont(10, 0, 50, 6);
		entertainment.setFont(12, 0, 12, 6);
		coolStuff.setFont(12, 0, 12, 6);
		money.setFont(12, 0, 12, 6);
			
		logo.setBorder(4, "", 0);
		
		frame.add(exit);
		frame.add(clickMe);
		frame.add(delete);
		frame.add(logo);
		frame.add(entertainment);
		frame.add(coolStuff);
		frame.add(money);
		
			
//		badground.getButton().addActionListener(new ActionListener()
//		{
//			@Override
//			public void actionPerformed(ActionEvent arg0)
//			{
//			}
//		});

		logo.getLabel().addMouseListener(new MouseListener() 
		{
			
			@Override
			public void mouseReleased(MouseEvent e) 
			{
				//Make green
			}
			
			@Override
			public void mousePressed(MouseEvent e) 
			{
				//MakeRed
			}
			
			@Override
			public void mouseExited(MouseEvent e) 
			{
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(l.givesEn())
				{
					eExpLvl[0] -= l.getPointValue() * 2;
					if(eExpLvl[0] < 0)
					{
						eExpLvl[0] = 0;
					}
					ent = "<html>Entertainment:<br>" +eExpLvl[0]+"/"+eExpLvl[1]+"exp   "+
							eExpLvl[2]+"/"+eExpLvl[3] + "lvl<html>";
					entertainment.setText(ent);
					u.setM_eExpLvl(eExpLvl);
					seserv.updateUser(u);
				}
				if(l.givesCS())
				{
					cExpLvl[0] -= l.getPointValue() * 2;
					if(cExpLvl[0] < 0)
					{
						cExpLvl[0] = 0;
					}
					coo = "<html>Cool Stuff:<br>" +cExpLvl[0]+"/"+cExpLvl[1]+"exp   "+
							cExpLvl[2]+"/"+cExpLvl[3] + "lvl<html>";
					coolStuff.setText(coo);
					u.setM_cExpLvl(cExpLvl);
					seserv.updateUser(u);
				}
				if(l.givesMo())
				{
					mExpLvl[0] -= l.getPointValue() * 2;
					if(mExpLvl[0] < 0)
					{
						mExpLvl[0] = 0;
					}
					mon = "<html>$$ money $$:<br>" +mExpLvl[0]+"/" + mExpLvl[1]+"exp   "+
							mExpLvl[2]+"/"+mExpLvl[3] + "lvl<html>";
					money.setText(mon);
					u.setM_mExpLvl(mExpLvl);
					seserv.updateUser(u);
				}
			}
		});
		
		delete.getButton().addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				frame.dispose();
				seserv.deleteMicroUser(u.getM_UserName(), l.getCompany());
				System.out.println("Removing from userDB");
				FramePresets.mainframe.dispose();
				FramePresets.mainframe = new CustomFrame("Home - Logged in");
				HomeLoggedIn hlo = new HomeLoggedIn(u, FramePresets.mainframe,1);
				CustomFrame delf = new CustomFrame("Account deleted");
				DialoguePopup del = new DialoguePopup(delf, "Oops, your LifeBlock acc has been accidentally discentegrated... You will have to make a new one.");
			}
		});
		
		exit.getButton().addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				System.out.println("Removing from userDB");
				frame.dispose();
				FramePresets.mainframe.dispose();
				FramePresets.mainframe = new CustomFrame("Home - Logged in");
				HomeLoggedIn hlo = new HomeLoggedIn(u, FramePresets.mainframe,1);
				CustomFrame exlf = new CustomFrame("Exited Lifeblock");
				DialoguePopup exl = new DialoguePopup(exlf, "Oops, your credentials were swallowed by a unicorn. Your will have to log back in to play.");
				System.out.println("Exiting");
			}
		});
			
		clickMe.getButton().addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				onex = rand.nextInt(buttonBound);
				oney = rand.nextInt(buttonBound);
				twox = rand.nextInt(buttonBound);
				twoy = rand.nextInt(buttonBound);
				thrx = rand.nextInt(buttonBound);
				thry = rand.nextInt(buttonBound);
				delete.setPos(onex, oney);
				exit.setPos(twox, twoy);
				clickMe.setPos(thrx, thry);
				while(delete.intersectsHoriz(exit) && (delete.intersectsVirt(exit)))
				{
					twox = rand.nextInt(buttonBound);
					twoy = rand.nextInt(buttonBound);
					exit.setPos(twox, twoy);
				}
				while((clickMe.intersectsHoriz(exit) && clickMe.intersectsVirt(exit)) || 
					  (clickMe.intersectsHoriz(delete) && clickMe.intersectsVirt(delete)))
				{
					thrx = rand.nextInt(buttonBound);
					thry = rand.nextInt(buttonBound);
					clickMe.setPos(thrx, thry);
				}
				
				if(l.givesEn())
				{
					eExpLvl[0] += l.getPointValue() / l.getNumFits();
					if(eExpLvl[0] >= eExpLvl[1])
					{
						eExpLvl[0] = eExpLvl[0]%eExpLvl[1];
						eExpLvl[1] *= 2;
						if(eExpLvl[2] < eExpLvl[3])
						{
							eExpLvl[2] += 1;
						}
					}
					ent = "<html>Entertainment:<br>" +eExpLvl[0]+"/"+eExpLvl[1]+"exp   "+
								eExpLvl[2]+"/"+eExpLvl[3] + "lvl<html>";
					entertainment.setText(ent);
					u.setM_eExpLvl(eExpLvl);
					seserv.updateUser(u);
				}
				if(l.givesCS())
				{

					cExpLvl[0] += l.getPointValue() / l.getNumFits();
					if(cExpLvl[0] >= cExpLvl[1])
					{
						cExpLvl[0] = cExpLvl[0]%cExpLvl[1];
						cExpLvl[1] *= 2;
						if(cExpLvl[2] < cExpLvl[3])
						{
							cExpLvl[2] += 1;
						}
					}					


					coo = "<html>Cool Stuff:<br>" +cExpLvl[0]+"/"+cExpLvl[1]+"exp   "+
								cExpLvl[2]+"/"+cExpLvl[3] + "lvl<html>";
					coolStuff.setText(coo);
					u.setM_cExpLvl(cExpLvl);
					seserv.updateUser(u);					
				}
				if(l.givesMo())
				{
					mExpLvl[0] += l.getPointValue() / l.getNumFits();
					if(mExpLvl[0] >= mExpLvl[1])
					{
						mExpLvl[0] = mExpLvl[0]%mExpLvl[1];
						mExpLvl[1] *= 2;
						if(mExpLvl[2] < mExpLvl[3])
						{
							mExpLvl[2] += 1;
						}
					}

					mon = "<html>$$ money $$:<br>" +mExpLvl[0]+"/"+mExpLvl[1]+"exp   "+
								mExpLvl[2]+"/"+mExpLvl[3] + "lvl<html>";
					money.setText(mon);
					u.setM_mExpLvl(mExpLvl);
					seserv.updateUser(u);
				}
			}          
		}); 
				
		frame.setSize(Hsp+16 ,Hsp + spacing + sH + topspacing);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}

class DialoguePopup
{
	String Dialogue;	
	static private int spacing = 20;
	static private int sH = 50;
	static private int sW = 200;
	static private int topspacing = 40;
	static private int Hsp = 3*sW;
	static private int Vsp = Hsp + spacing;
	static private boolean m_kill = false;
	
	public DialoguePopup(CustomFrame frame, String txt)
	{
		Random rand = new Random();
		CustomLabel text = new CustomLabel(fitString(txt),
												spacing, spacing, (Hsp - 2*spacing), 
												(Hsp - (2*spacing)), rand.nextInt(14),50);
		CustomButton cont = new CustomButton("Continue",(Hsp - sW)/2, Vsp, sW, sH);
		
		cont.setFont(39, 0, 30, 6);
		text.setFont(rand.nextInt(221),0,25,6);
		
		text.setBorder(3, "", 0);
		
		frame.add(text);
		frame.add(cont);
		
		
		frame.setSize(Hsp , Vsp + spacing + sH + topspacing);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		cont.getButton().addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				System.out.println("remove,and continue to next frame.");
				m_kill = true;
				frame.dispose();
			}
		});

		Timer t = new Timer();
		TimerTask tickGo = new TimerTask()
		{
			public void run() 
			{
				while(!m_kill)
				{
					try 
					{
						Thread.sleep(2000);
					} 
					catch (InterruptedException e) 
					{						
						e.printStackTrace();
					}
					text.setFont(rand.nextInt(221), 0, 30, 6);
				}
			}
			public void completeTask()
			{
				while(!m_kill)
				{

					try 
					{
						Thread.sleep(2000);
					} 
					catch (InterruptedException e) 
					{
						e.printStackTrace();
					}
				}
			}
		};
		t.schedule(tickGo, 0);
	}
	
	public DialoguePopup(CustomFrame frame, String words, int art, int style, int size)
	{
		CustomLabel text = new CustomLabel(fitString(words, size),
												spacing, spacing, (Hsp - 2*spacing), 
												(Hsp - (2*spacing)), 0,size);
		CustomButton cont = new CustomButton("Continue",(Hsp - sW)/2, Vsp, sW, sH);
		
		cont.setFont(39, 0, 30, 6);
		text.setFont(art,style,size,6);
		
		text.setBorder(3, "", 0);
		
		frame.add(text);
		frame.add(cont);
		
		
		frame.setSize(Hsp , Vsp + spacing + sH + topspacing);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		cont.getButton().addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				System.out.println("remove,and continue to next frame.");
				frame.dispose();
			}
		});
	}
	
	//  METHODS //
		
	public String fitString(String s)
	{
		float wide = 13f;
		float thin = 22f;
		int avgchars = (int)((wide+thin)/2f);
		StringBuilder newst = new StringBuilder("<html>");
		StringBuilder oldst = new StringBuilder(s);
		
		int sLength = s.length();
		int stindex;
		while (sLength > 0)
		{
			//If There is a space to break on between the start 
			//and avgchar characters into the string.
			if(nextspace(oldst, avgchars))
			{
				//If we are at the end of our string;
				if(sLength <= avgchars)
				{stindex = sLength;}
				else
				{
					for(stindex = avgchars; oldst.charAt(stindex) != ' '; stindex--) {}
				}
			}
			
			else
			{
				for(stindex = 0; stindex != sLength && oldst.charAt(stindex) != ' '; stindex++) {}	
			}
			if(sLength != stindex)
			{
				newst.append(oldst.substring(0, stindex)+"<br>");
				oldst.replace(0, sLength-1, oldst.substring(stindex+1, sLength-1));
				sLength -= stindex + 1;
			}
			else
			{
				newst.append(oldst.substring(0, stindex-1)+"<html>");
				oldst.replace(0, sLength-1, "");
				sLength = 0;
			}
		}
		return newst.toString();
	}
	public String fitString(String s, int size)
	{
		float wide = 13f;
		float thin = 22f;
		int avgchars = (int)(((wide+thin)* 25f/(2f * (float)size)));
		StringBuilder newst = new StringBuilder("<html>");
		StringBuilder oldst = new StringBuilder(s);
		
		int sLength = s.length();
		int stindex;
		while (sLength > 0)
		{
			if(nextspace(oldst, avgchars))
			{
				if(sLength <= avgchars)
				{stindex = sLength;}
				else
				{
					for(stindex = avgchars; oldst.charAt(stindex) != ' '; stindex--){}
				}
			}
			else
			{
				for(stindex = 0; stindex < sLength && oldst.charAt(stindex) != ' '; stindex++) {}
			}
			if(sLength != stindex)
			{
				newst.append(oldst.substring(0, stindex)+"<br>");
				oldst.replace(0, sLength-1, oldst.substring(stindex+1, sLength-1));
				sLength -= stindex + 1;
			}
			else
			{

				newst.append(oldst.substring(0, stindex-1)+"<html>");
				oldst.replace(0, sLength-1, "");
				sLength = 0;
			}
		}
		return newst.toString();
	}
	boolean nextspace(StringBuilder s, int avgchars)
	{
		int index;
		for(index = 0; index < s.length() && s.charAt(index) != ' '; ++ index) {}
		if(index <= avgchars)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}

class AdminTools
{
	static private int spacing = 20;
	static private int sH = 50;
	static private int sW = 200;
	static private int topspacing = 40;
	static private int Hsp = sW + spacing*2;
	static private int Vsp = spacing;
	private User[] users;
	
	public AdminTools(User u, CustomFrame f)
	{
		Vsp = spacing;
		SessionService seserv = new SessionService();
		users = seserv.getAllUsers();
		CustomButton[] buttusers = new CustomButton[users.length];
		
		//Present List of Users as Buttons
		
		for(int i = 0; i < users.length; i++)
		{
			buttusers[i] = new CustomButton(users[i].getM_UserName()+((users[i].isM_Admin()) ? "   admin":""), spacing, Vsp, sW, sH);
			if(users[i].getM_UserName().compareTo(u.getM_UserName()) == 0)
			{
				buttusers[i].disable();
			}
			f.add(buttusers[i]);
			setClickOnUserName(u,users[i], buttusers[i], Vsp, f, buttusers, users);
			Vsp += sH + spacing;
		}
		f.setSize(Hsp+16 , Vsp + topspacing);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
	}
	

	// METHODS //
	public void setClickOnUserName(User userAdm, User usr, CustomButton b, int tempVsp, CustomFrame f, CustomButton[] bu, User[] usrs)
	{

		SessionService seserv = new SessionService();
		b.getButton().addActionListener(new ActionListener() 
		{	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				for(int i = 0; i < bu.length; i++)
				{
					if(usrs[i].getM_UserName().compareTo(userAdm.getM_UserName()) != 0)
					{
						bu[i].disable();
					}
				}
				int tVsp = tempVsp;
				CustomButton makeAdmin;
				if(!usr.isM_Admin())
				{
					makeAdmin = new CustomButton("Make Admin", Hsp, tVsp, sW, sH);
				}
				else
				{
					makeAdmin = new CustomButton("Un-Admin", Hsp, tVsp, sW, sH);
				}
				tVsp += sH + spacing;
				CustomButton deleteAcc = new CustomButton("Delete Acc", Hsp, tVsp, sW, sH);
				tVsp += sH + spacing;
				CustomButton viewLBs = new CustomButton("View LBs", Hsp, tVsp, sW, sH);
				tVsp += sH + spacing;
				CustomButton Back = new CustomButton("Back", Hsp, tVsp, sW, sH);
				tVsp += sH + spacing;
				if(Vsp < tVsp)
				{
					f.setSize(Hsp + sW + spacing + 16, tVsp + topspacing);
				}
				else
				{
					f.setSize(Hsp + sW + spacing + 16, Vsp + topspacing);	
				}
				
				f.add(makeAdmin);
				f.add(deleteAcc);
				f.add(viewLBs);
				f.add(Back);
				
				makeAdmin.getButton().addActionListener(new ActionListener() 
				{
					@Override
					public void actionPerformed(ActionEvent e) 
					{
						if(usr.isM_Admin())
						{
							usr.setAdminStatus(false);
						}
						else
						{
							usr.setAdminStatus(true);
						}
						seserv.updateUser(usr);
						//ResetPage
						f.dispose();
						CustomFrame cf = new CustomFrame("Admin Tools");
						AdminTools adt = new AdminTools(userAdm, cf);
					}
				});
				deleteAcc.getButton().addActionListener(new ActionListener() 
				{
					@Override
					public void actionPerformed(ActionEvent e) 
					{
						seserv.deleteUser(usr);
						//ResetPage
						f.dispose();
						CustomFrame cf = new CustomFrame("Admin Tools");
						AdminTools adt = new AdminTools(userAdm, cf);
					}
				});
				viewLBs.getButton().addActionListener(new ActionListener() 
				{
					@Override
					public void actionPerformed(ActionEvent e) 
					{						
							//ResetPage
						f.dispose();
						CustomFrame cf = new CustomFrame("Admin Tools");
						AdminTools adt = new AdminTools(userAdm, cf);
						 	//Display musers
						CustomFrame f = new CustomFrame("muser list for "+usr.getM_UserName());
						DisplayMicroUsers dmu = new DisplayMicroUsers(
							f, seserv.GetMicroAcctsFromUname(usr.getM_UserName())
						);
					}
				});
				Back.getButton().addActionListener(new ActionListener() 
				{					
					@Override
					public void actionPerformed(ActionEvent e) 
					{
						f.remove(makeAdmin);
						f.remove(deleteAcc);
						f.remove(viewLBs);
						f.remove(Back);
						for(int i = 0; i < bu.length; i++)
						{
							if(usrs[i].getM_UserName().compareTo(userAdm.getM_UserName()) != 0)
							{
								bu[i].enable();
							}
						}
						f.setSize(Hsp + sW + spacing + 16, Vsp + topspacing);	
					}
				});
			}
		});
	}
}
class DisplayMicroUsers
{
	private static int spacing = 5;
	private static int sH = 25;
	private static int sW = 500;
	private static int topspacing = 40;
	private static int Hsp = sW + (spacing*2) + 16;
	private static int Vsp = spacing;
	
	public DisplayMicroUsers(CustomFrame f, MicroUser[] mus)
	{
		Vsp = spacing;
		CustomLabel[] lelements = new CustomLabel[mus.length];
		for(int i = 0; i < mus.length; i++)
		{
			lelements[i] = new CustomLabel("Username = "+mus[i].getM_UserName()+
				"    Email = "+mus[i].getM_Email(), spacing, Vsp, sW, sH, 5);
			f.add(lelements[i]);
			lelements[i].setBorder(2, "", 0);
			lelements[i].setFont(156, 0, 20, 6);
			Vsp += sH + spacing;
		}
		CustomButton done = new CustomButton("DONE", spacing, Vsp, sW, sH);
		Vsp += sH + spacing;
		f.add(done);
		done.getButton().addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				f.dispose();
			}
		});
		f.setSize(Hsp, Vsp+ topspacing);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setVisible(true);
	}
}