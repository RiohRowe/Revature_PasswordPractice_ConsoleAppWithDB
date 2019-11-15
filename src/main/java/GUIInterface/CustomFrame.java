package GUIInterface;

import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Toolkit;


public class CustomFrame 
{
	private JFrame m_frame;
	private String m_title;
	private int m_height;
	private int m_width;
	private ArrayList<FrameObj> m_tiles;
	private boolean m_visible;
	private int m_closeOperation;
	private LayoutManager m_manager;
	private byte m_bgColorR;
	private byte m_bgColorG;
	private byte m_bgColorB;
	private byte m_bgOpacity;

//  CONSTRUCTORS  //
	
	public CustomFrame(String title)
	{
		m_title = title;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		m_height = (int)screenSize.getHeight();
		m_width = (int)screenSize.getWidth();
		m_visible = false;
		m_closeOperation = JFrame.DISPOSE_ON_CLOSE;
		m_manager = null;
		m_bgColorR = (byte)255;
		m_bgColorG = (byte)255;
		m_bgColorB = (byte)255;
		m_bgOpacity = (byte)255;
		m_frame = new JFrame(m_title);
		m_frame.setSize(m_width, m_height);
		m_frame.setLayout(m_manager);
		m_frame.setDefaultCloseOperation(m_closeOperation);
		m_frame.setVisible(m_visible);
		m_tiles = new ArrayList<FrameObj>();
	}
	public CustomFrame(String title, int height, int width, boolean visible)
	{
		m_title = title;
		m_height = height;
		m_width = width;
		m_visible = visible;
		m_closeOperation = JFrame.DISPOSE_ON_CLOSE;
		m_manager = null;
		m_bgColorR = (byte)255;
		m_bgColorG = (byte)255;
		m_bgColorB = (byte)255;
		m_bgOpacity = (byte)255;
		m_frame = new JFrame(m_title);
		m_frame.setSize(m_width, m_height);
		m_frame.setLayout(m_manager);
		m_frame.setDefaultCloseOperation(m_closeOperation);
		m_frame.setVisible(m_visible);
		m_tiles = new ArrayList<FrameObj>();
	}
	
	//   METHODS   //
	
	/*
	 * public void setRBG(int R, int G, int B)
	 * public void setOpacity(int opacity)
	 * public void setSize(int height, int width)
	 * public void setLayout(LayoutManager layout)
	 * public void setCloseOperation(int onClose)
	 * public void show()
	 * public void hide()
	 * public int getHeight()
	 * public int getWidth()
	 * public int setHeight()
	 * public int setWidth()
	 * public void remove(JComponent obj)
	 * public void add(JComponent obj)
	 */
	public void setRBG(int R, int G, int B)
	{
		m_frame.setBackground(new Color(R,G,B,m_bgOpacity));
		m_bgColorR = (byte)R;
		m_bgColorG = (byte)G;
		m_bgColorB = (byte)B;
	}
	
	public void setOpacity(int opacity)
	{
		m_frame.setBackground(new Color(m_bgColorR,m_bgColorG,m_bgColorB, opacity));
		m_bgOpacity = (byte)opacity;
	}
	public void setSize(int height, int width)
	{
		if(height < 0 && width < 0)
		{
			return;
		}
		else if(height < 0)
		{
			m_frame.setSize(m_height,width);
			m_width = width;
		}
		else if(width < 0)
		{
			m_frame.setSize(height,m_width);
			m_height=height;
		}
		else
		{
			m_frame.setSize(height,width);
			m_height = height;
			m_width = width;
		}
	}
	public void setLayout(LayoutManager layout)
	{
		m_manager = layout;
		m_frame.setLayout(layout);
	}
	public void setCloseOperation(int onClose)
	{
		m_frame.setDefaultCloseOperation(onClose);
		m_closeOperation = onClose;
	}
	public void show()
	{
		m_frame.setVisible(true);
		m_visible = true;
	}
	public void hide()
	{
		m_frame.setVisible(false);
		m_visible = false;
	}
	public int getHeight()
	{
		return m_height;
	}
	public int getWidth()
	{
		return m_width;
	}
	public void setHeight(int height)
	{
		m_height = height;
		m_frame.setSize(m_width, height);
	}
	public void setWidth(int width)
	{
		m_width = width;
		m_frame.setSize(width, m_height);
	}
	public void remove(FrameObj obj)
	{
		m_frame.remove(obj.getObj());
		m_tiles.remove(obj);
	}
	public void add(FrameObj obj)
	{
		m_frame.add(obj.getObj());
		m_tiles.add(obj);
	}
	//AddToFrame
	public boolean addToFrame(FrameObj obj)
	{
		if(obj == null)
		{
			return false;
		}
		else
		{
			m_frame.add(obj.getObj());
			m_tiles.add(obj);
			return true;
		}
	}
	
	//RemoveFromFrame
	public boolean removeFromFrame(JComponent fObj)
	{
		if(fObj == null)
		{
			return false;
		}
		else
		{
			m_frame.remove(fObj);
			m_tiles.remove(fObj);
			return true;
		}
	}
	public void setVisible(boolean vis)
	{
		m_frame.setVisible(vis);
	}
	public void setDefaultCloseOperation(int operation)
	{
		m_frame.setDefaultCloseOperation(operation);
	}
	public void printFrame()
	{
		Component[] c = m_frame.getContentPane().getComponents();
		for (Component component : c) 
		{
			System.out.println(component.getX() + ", " + component.getY() + "\t" + 
									component.getName() + "\t" + component.getClass());
		}
		System.out.println("Num Components = " + c.length);
	}
	public void refresh()
	{
		m_frame.repaint();
	}
	public void dispose()
	{
		m_frame.dispose();
	}
	public JFrame getFrame()
	{
		return m_frame;
	}
}
