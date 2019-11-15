package GUIInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import javax.swing.border.Border;

public class FrameObj 
{
	// MEMBER VARIABLES //
	protected JComponent m_obj;
	protected int m_xPos;
	protected int m_yPos;
	protected int m_height;
	protected int m_width;
	protected Border m_border;
	static int objBuffer = 20;
	static String ImgURL = "C:\\Users\\rrowe\\Desktop\\Repos\\Project0\\src\\GUIInterface\\Imgs\\";
	
	// Constructor //
	
	public FrameObj(int xPos, int yPos, int height, int width)
	{
		m_xPos = xPos;
		m_yPos = yPos;
		m_height = height;
		m_width = width;
		m_border = null;
	}


	//METHODS//
	/*
	 * getXPos
	 * getYPos
	 * getHeight
	 * getWidth
	 * setObj
	 * move
	 * setPos
	 * addToFrame
	 * removeFromFrame
	 */
	
	//Move
	public void hide()
	{
		m_obj.setOpaque(false);
		m_obj.setEnabled(false);
	}
	public void show()
	{
		m_obj.setOpaque(true);
		m_obj.setEnabled(true);
	}
	public void disable()
	{
		m_obj.setEnabled(false);
	}
	public void enable()
	{
		m_obj.setEnabled(true);
	}
	public int getXPos()
	{
		return m_xPos;
	}
	public int getYPos()
	{
		return m_yPos;
	}
	public int getHeight()
	{
		return m_height;
	}
	public int getWidth()
	{
		return m_width;
	}
	public void setObj(JComponent component)
	{
		m_obj = component;
	}
	public void move(int right, int down,CustomFrame frame)
	{
		if(m_xPos < right * -1)
		{
			m_xPos = 0;
		}
		else
		{
			m_xPos = m_xPos + right;
		}
		if(m_yPos < down * -1)
		{
			m_yPos = 0;
		}
		else
		{
			m_yPos = m_yPos + down;
		}
		if(m_xPos + m_width + objBuffer > frame.getWidth())
		{
			frame.setWidth(m_xPos + m_width + objBuffer);
		}
		if(m_yPos + m_height + objBuffer > frame.getHeight())
		{
			frame.setHeight(m_yPos + m_height + objBuffer);
		}
		m_obj.setBounds(m_xPos, m_yPos, m_width, m_height);
		return;
	}
	
	//SetPos
	public void setPos(int x, int y)
	{
		m_xPos = x;
		m_yPos = y;
		m_obj.setBounds(x, y, m_width, m_height);
	}
	
	//SetSize
	public void setSize(int height, int width)
	{
		m_height = height;
		m_width = width;
		m_obj.setBounds(m_xPos, m_yPos, m_height, m_width);
	}
	
	//getObj
	public JComponent getObj()
	{
		return m_obj;
	}
	
	//DO THESE OBJECTS INTERCECT Virtically?
	public boolean intersectsVirt(FrameObj obj)
	{
		if((obj.getYPos() < m_yPos && m_yPos < obj.getYPos()+obj.getHeight())||
				(obj.getYPos() < m_yPos+m_height && m_yPos+m_height < obj.getYPos()+obj.getHeight()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	//DO THESE OBJECTS INTERCECT Horizontally?
	public boolean intersectsHoriz(FrameObj obj)
	{
		if((obj.getXPos() < m_xPos && m_xPos < obj.getXPos()+obj.getWidth())||
				(obj.getXPos() < m_xPos+m_width && m_xPos+m_width < obj.getXPos()+obj.getWidth()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//ALLIGN WITH
	public void alignWith(FrameObj obj, boolean vertical)
	{
		if(vertical)
		{
			m_xPos = obj.getXPos();
			m_obj.setBounds(m_xPos, m_yPos, m_width, m_height);
			//If Objects Intersect,
			if(this.intersectsVirt(obj))
			{
				if(m_yPos + (m_height/2) < obj.getYPos() + (obj.getHeight()/2))
				{
					m_yPos = obj.getYPos() - (m_height + objBuffer);
				}
				else
				{
					m_yPos = obj.getYPos() + (obj.getHeight() + objBuffer);
				}
			}
		}
		else
		{
			if(this.intersectsHoriz(obj))
			{
				if(m_xPos + (m_width/2) < obj.getXPos() + (obj.getWidth()/2))
				{
					m_xPos = obj.getXPos() - (m_width + objBuffer);
				}
				else
				{
					m_xPos = obj.getXPos() + (obj.getWidth() + objBuffer);
				}				
			}
		}
	}
	public static int getSpacing()
	{
		return objBuffer;
	}
	public static void setSpacing(int i)
	{
		objBuffer = i;
	}
	public void setBorder(int borderType, String title, int titlePos)
	{
		switch(borderType%7)
		{
			case 0:
			{
				m_border = BorderFactory.createEmptyBorder();
				break;
			}
			case 1:
			{
				m_border = BorderFactory.createLineBorder(Color.black);
				break;
			}
			case 2:
			{
				m_border = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
				break;
			}
			case 3:
			{
				m_border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
				break;
			}
			case 4:
			{
				m_border = BorderFactory.createRaisedBevelBorder();
				break;
			}
			case 5:
			{
				m_border = BorderFactory.createLoweredBevelBorder();
				break;
			}
			case 6:
			{
				ImageIcon icon = new ImageIcon("imgs/wavy2.gif","wavy-line border icon");
				m_border = BorderFactory.createMatteBorder(-1, -1, -1, -1, icon);
				break;
			}
			default:
			{
				System.out.println("This code should not be reached 1");
			}
		}
		if(title.length()!=0)
		{
			m_border = BorderFactory.createTitledBorder(m_border, title,(titlePos % 30) % 6, (titlePos % 30) / 6);
		}
		m_obj.setBorder(m_border);
	}
	public void setDoubleBorder(int borderType1, String title1, int titlePos1, int borderType2, String title2, int titlePos2)
	{
		Border temp = null;
		switch(borderType1%7)
		{
			case 0:
			{
				temp = BorderFactory.createEmptyBorder();
				break;
			}
			case 1:
			{
				temp = BorderFactory.createLineBorder(Color.black);
				break;
			}
			case 2:
			{
				temp = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
				break;
			}
			case 3:
			{
				temp = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
				break;
			}
			case 4:
			{
				temp = BorderFactory.createRaisedBevelBorder();
				break;
			}
			case 5:
			{
				temp = BorderFactory.createLoweredBevelBorder();
				break;
			}
			case 6:
			{
				ImageIcon icon = new ImageIcon(ImgURL.concat("wavy2.gif"),"wavy-line border icon");
				temp = BorderFactory.createMatteBorder(-1, -1, -1, -1, icon);
				break;
			}
			default:
			{
				System.out.println("This code should not be reached 1");
			}
		}
		if(title1.length()!=0)
		{
			temp = BorderFactory.createTitledBorder(temp, title1,(titlePos1 % 30) % 6, (titlePos1 % 30) / 6);
		}
		switch(borderType2%7)
		{
			case 0:
			{
				m_border = BorderFactory.createEmptyBorder();
				break;
			}
			case 1:
			{
				m_border = BorderFactory.createLineBorder(Color.black);
				break;
			}
			case 2:
			{
				m_border = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
				break;
			}
			case 3:
			{
				m_border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
				break;
			}
			case 4:
			{
				m_border = BorderFactory.createRaisedBevelBorder();
				break;
			}
			case 5:
			{
				m_border = BorderFactory.createLoweredBevelBorder();
				break;
			}
			case 6:
			{
				ImageIcon icon = new ImageIcon(ImgURL.concat("wavy2.gif"),"wavy-line border icon");
				m_border = BorderFactory.createMatteBorder(10, 10, 10, 10, icon);
				break;
			}
			default:
			{
				System.out.println("This code should not be reached 1");
			}
		}
		if(title2.length()!=0)
		{
			m_border = BorderFactory.createTitledBorder(m_border, title2,(titlePos2 % 30) % 6, (titlePos2 % 30) / 6);
		}
		m_border = BorderFactory.createCompoundBorder(temp, m_border);
		m_obj.setBorder(m_border);
	}
	public void setFont(int texttype, int style, int size, int allignment)
	{
		String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		m_obj.setFont(new Font(fonts[texttype], style, size));
		int horizAl;
		int vertAl;
		switch(allignment%15)
		{
			case 0:
			{
				horizAl = 2;
				vertAl = 1;
				break;
			}
			case 1:
			{
				horizAl = 0;
				vertAl = 1;
				break;
			}
			case 2:
			{
				horizAl = 4;
				vertAl = 1;
				break;
			}

			case 3:
			{
				horizAl = 10;
				vertAl = 1;
				break;
			}
			case 4:
			{
				horizAl = 11;
				vertAl = 1;
				break;
			}
			case 5:
			{
				horizAl = 2;
				vertAl = 0;
				break;
			}
			case 6:
			{
				horizAl = 0;
				vertAl = 0;
				break;
			}
			case 7:
			{
				horizAl = 4;
				vertAl = 0;
				break;
			}

			case 8:
			{
				horizAl = 10;
				vertAl = 0;
				break;
			}
			case 9:
			{
				horizAl = 11;
				vertAl = 0;
				break;
			}
			case 10:
			{
				horizAl = 2;
				vertAl = 3;
				break;
			}
			case 11:
			{
				horizAl = 0;
				vertAl = 3;
				break;
			}
			case 12:
			{
				horizAl = 4;
				vertAl = 3;
				break;
			}

			case 13:
			{
				horizAl = 10;
				vertAl = 3;
				break;
			}
			case 14:
			{
				horizAl = 11;
				vertAl = 3;
				break;
			}
			default:
			{
				horizAl = vertAl = 0;
			}
		}
		if(m_obj.getClass() == JLabel.class)
		{
			JLabel temp = (JLabel)m_obj;
			temp.setHorizontalAlignment(horizAl);
			temp.setVerticalAlignment(vertAl);
		}
		else if(m_obj.getClass() == JButton.class)
		{
			JButton temp = (JButton)m_obj;
			temp.setHorizontalAlignment(horizAl);
			temp.setVerticalAlignment(vertAl);
		}
		else if(m_obj.getClass() == JTextField.class)
		{
			JTextField temp = (JTextField)m_obj;
			temp.setHorizontalAlignment(horizAl);
		}
		else
		{
			System.out.println("If you are reading this, you tried to set the alignment of an unsupported FrameObj");
		}
	}
}
