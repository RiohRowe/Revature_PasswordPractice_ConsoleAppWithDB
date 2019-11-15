package GUIInterface;

import java.awt.Font;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CustomLabel extends FrameObj 
{
	//  MemberVars  //
	private JLabel m_label;
	private ImageIcon m_img;
	private String m_text;
	private static final Font[] m_fonts = {
	new Font("Comic Sans MS",Font.PLAIN,12),
	new Font("Algerian",Font.PLAIN,12),
	new Font("Bauhaus93",Font.PLAIN,12),
	new Font("Blackadder ITC",Font.PLAIN,12),
	new Font("Bradley Hand ITC",Font.PLAIN,12),
	new Font("Broadway",Font.PLAIN,12),
	new Font("Castellar",Font.PLAIN,12),
	new Font("chiller",Font.PLAIN,12),
	new Font("Gigi",Font.PLAIN,12),
	new Font("Goudy Stout",Font.PLAIN,12),
	new Font("magneto",Font.PLAIN,12),
	new Font("Old English Text MT",Font.PLAIN,12),
	new Font("Ravie",Font.PLAIN,12),
	new Font("OCR A Extended",Font.PLAIN,12),
	new Font("Segoe Script",Font.PLAIN,12),
	new Font("Script MT Bold",Font.PLAIN,12),
	new Font("Snap ITC",Font.PLAIN,12),
	new Font("Temput Sans ITC",Font.PLAIN,12),
	new Font("Times New Roman",Font.PLAIN,12),
	new Font("Forte",Font.PLAIN,12)};
	
	// CONSTRUCTORS //
	public CustomLabel()
	{
		super(0,0,100,50);
		m_obj = m_label = new JLabel();
		m_img = null;
		m_text = "";
		Random rand = new Random();
		m_label.setFont(m_fonts[rand.nextInt(19)]);
		m_label.setBounds(0 , 0, 100, 50);
	}
	public CustomLabel(String description, ImageIcon img, int x, int y)
	{
			super(x,y,img.getIconWidth(),img.getIconHeight());
			m_obj = m_label = new JLabel();
			m_text = "";
			m_img = img;
			m_img.setDescription(description);
			m_label.setBounds(m_xPos , m_yPos, m_width, m_height);
			m_label.setIcon(img);
	}
	public CustomLabel(String text, int x, int y, int width, int height, int fontindex)
	{
		super(x,y,width,height);
		m_obj = m_label = new JLabel();
		m_text = text;
		m_label.setText(m_text);
		m_label.setBounds(x,y,width,height);
		m_label.setFont(m_fonts[fontindex%20]);
	}
	public CustomLabel(String text, int x, int y, int width, int height, int fontindex, int fontsize)
	{
		super(x,y,width,height);
		m_obj = m_label = new JLabel();
		m_text = text;
		m_label.setText(m_text);
		m_label.setBounds(x,y,width, height);
		m_label.setFont(new Font(m_fonts[fontindex%20].getFamily(), m_fonts[fontindex%20].getStyle(), fontsize));
	}
	
	// METHODS //
	/*
	 * setText
	 * setImg
	 * setImgDesc
	 * setFont
	 */
	public JLabel getLabel()
	{
		return m_label;
	}
	public void setText(String text)
	{
		m_text = text;
		m_label.setText(text);
	}
	public void setText(int text)
	{
		m_text = ""+text;
		m_label.setText(""+text);
	}
	public void setImg(ImageIcon img)
	{
		m_img = img;
		m_label.setIcon(img);
		m_label.setBounds(m_xPos,m_yPos,img.getIconWidth(),img.getIconHeight());
	}
	public void setImg(ImageIcon img, String desc)
	{
		m_img = img;
		m_img.setDescription(desc);
		m_label.setIcon(m_img);
		m_label.setBounds(m_xPos,m_yPos,img.getIconWidth(),img.getIconHeight());
	}
	public void setFont(Font font)
	{
		m_label.setFont(font);
	}
	public void setFont()
	{
		m_label.setFont(m_fonts[new Random().nextInt(19)]);
	}
	public void setFontSize(int size)
	{
		m_label.setFont(new Font(m_label.getFont().getFontName(), m_label.getFont().getStyle(), size));
	}
	public void setTAlign(int Allignment)
	{
		int horizAl;
		int vertAl;
		switch(Allignment%15)
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
		m_label.setHorizontalAlignment(horizAl);
		m_label.setVerticalAlignment(vertAl);
	}
}
