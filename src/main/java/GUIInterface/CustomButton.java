package GUIInterface;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
public class CustomButton extends FrameObj
{
	// MEMBER VARIABLES //
	private JButton m_button;
	private String m_name;
	private ImageIcon m_img;
	
	
	/*
	 * CONSTRUCTORS
	 * Allow for the following args
	 * NONE
	 * int(pos X), 		int(pos Y)
	 * int(pos X), 		int(pos Y), 	int(Height),int(Width)
	 * ImageIcon(img)
	 * ImageIcon(img), 	int(pos X),		int(pos Y)
	 * String(name)
	 * String(name), 	int(pos X),		int(pos Y)
	 * String(name), 	int(pos X),		int(pos Y),	int(Height), int(Width)
	 * String(name), 	ImageIcon(img)
	 * String(name), 	ImageIcon(img), int(pos X),	int(pos Y)
	 */
	public CustomButton()
	{
		super(0,0,50,100);
		m_button = new JButton();
		m_obj = m_button;
		m_img = null;
	}
	public CustomButton(ImageIcon img)
	{
		super(0,0,img.getIconHeight(),img.getIconWidth());
		m_button = new JButton(img);
		m_obj = m_button;
		m_img = img;
		m_button.setIcon(m_img);
		m_button.setBounds(m_xPos, m_yPos, m_width, m_height);
	}
	public CustomButton(int posX, int posY)
	{
		super(posX,posY,50,100);
		m_button = new JButton();
		m_obj = m_button;
		m_img = null;
		m_button.setBounds(m_xPos, m_yPos, m_width, m_height);
	}
	public CustomButton(int posX, int posY, int width, int height)
	{
		super(posX,posY,height,width);
		m_button = new JButton();
		m_obj = m_button;
		m_img = null;
		m_button.setBounds(m_xPos, m_yPos, m_width, m_height);
	}	
	public CustomButton(ImageIcon img, int sizeX, int sizeY, boolean sizeDistinction)
	{
		super(0,0,sizeY,sizeX);
		m_button = new JButton(img);
		m_obj = m_button;
		m_img = img;
		m_button.setIcon(m_img);
		m_button.setBounds(m_xPos, m_yPos, m_width, m_height);
	}
	public CustomButton(ImageIcon img, int posX, int posY)
	{
		super(posX,posY,img.getIconHeight(),img.getIconWidth());
		m_button = new JButton(img);
		m_obj = m_button;
		m_img = img;
		m_button.setIcon(m_img);
		m_button.setBounds(m_xPos, m_yPos, m_width, m_height);
	}
	public CustomButton(String name)
	{
		super(0,0,50,100);
		m_name = name;
		m_button = new JButton(name);
		m_obj = m_button;
		m_img = null;
		m_button.setBounds(m_xPos, m_yPos, m_width, m_height);
		m_button.setName(name);
	}
	public CustomButton(String name, ImageIcon img)
	{
		super(0,0,img.getIconHeight(),img.getIconWidth());
		m_name = name;
		m_button = new JButton(name, img);
		m_obj = m_button;
		m_img = img;
		m_button.setIcon(m_img);
		m_button.setBounds(m_xPos, m_yPos, m_width, m_height);
		m_button.setName(name);
	}
	public CustomButton(String name, int posX, int posY)
	{
		super(posX,posY,50,100);
		m_name = name;
		m_button = new JButton(name);
		m_obj = m_button;
		m_img = null;
		m_button.setBounds(m_xPos, m_yPos, m_width, m_height);
		m_button.setName(name);
	}
	public CustomButton(String name, int posX, int posY, int width, int height)
	{
		super(posX,posY,height,width);
		m_name = name;
		m_button = new JButton(name);
		m_obj = m_button;
		m_img = null;
		m_button.setBounds(m_xPos, m_yPos, m_width, m_height);
		m_button.setName(name);
	}	
	public CustomButton(String name, ImageIcon img,  int posX, int posY)
	{
		super(posX,posY,img.getIconHeight(),img.getIconWidth());
		System.out.println("iconHeight = " + img.getIconHeight() + "\niconwidth = " + img.getIconWidth() + "\n\n");
		m_name = name;
		m_button = new JButton(name,img);
		m_obj = m_button;
		m_img = img;
		m_button.setIcon(m_img);
		m_button.setBounds(m_xPos, m_yPos, m_width, m_height);
		System.out.println("buttonHeight = " + m_height + "\nbuttonwidth = " + m_width + "\n\n");
		System.out.println(m_button.getBounds());
		m_button.setName(name);
	}

	
	//METHODS//
	/*    /InheritedMethods/
	 * void move(int right, int down)
	 * void setPos(int x, int y)
	 * boolean addToFrame(JFrame frame, JComponent fObj)
	 * boolean removeFromFrame(JFrame frame, JComponent fObj)
	 */
	
	public JButton getButton()
	{
		return m_button;
	}
	
	public void setImg(ImageIcon img)
	{
		m_img = img;
		m_button.setIcon(img);
		m_height = img.getIconHeight();
		m_width = img.getIconWidth();
		m_button.setSize(img.getIconHeight(), img.getIconWidth());

	}
	public void setName(String name)
	{
		m_name = name;
		m_button.setText(name);
	}
	public void setDescription(String Desc)
	{
		m_button.setToolTipText(Desc);
	}
}
