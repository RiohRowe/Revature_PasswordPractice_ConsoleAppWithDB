package GUIInterface;

import java.awt.Color;

import javax.swing.JTextField;

public class CustomTextField extends FrameObj
{

	//   MEMBER VARS //

	private JTextField m_tf;
	private String m_deftext;
	private Color m_bgcolor;

	//   CONSTRUCTORS //
	
	public CustomTextField()
	{
		super(0,0,200,100);
		m_obj = m_tf = new JTextField();
		m_tf.setBounds(0, 0, 200, 100);
	}
	
	public CustomTextField(int xPos, int yPos, int width, int height, String defaultxt, Color bgcolor) 
	{
		super(xPos, yPos, height, width);
		m_obj = m_tf = new JTextField(defaultxt);
		m_tf.setBounds(xPos, yPos, width, height);
		m_bgcolor = bgcolor;
		if(bgcolor != null)
		{
			m_obj.setBackground(bgcolor);
		}
	}
	
	//   METHODS //
	
	public void setDefaultText(String text)
	{
		m_tf.setText(text);
	}
	public void setBGColor(Color color)
	{
		m_tf.setBackground(color);
	}
	public String getText()
	{
		return m_tf.getText();
	}
}
