package GUIInterface;


import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Fonts
{

	public static void main (String args[])
	{
	    JFrame f1 = new JFrame("FontTypes pg 1");
        f1.setVisible(true);
		f1.setLayout(null);       
		f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);    

		JFrame f2 = new JFrame("FontTypes pg 2");
		f2.setVisible(true);
		f2.setLayout(null);       
		f2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);    

		JFrame f3 = new JFrame("FontTypes pg 3");
		f3.setVisible(true);
		f3.setLayout(null);       
		f3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel label2;
		JLabel label1;
		Font font1;
		Font font2 = new Font("Arial Narrow",Font.PLAIN,18);
		String fonts[]
		        = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

		for (int i = 0; i < fonts.length; i++) 
		{
			label1 = new JLabel();
			label2 = new JLabel();
			label1.setText(fonts[i]);
			label2.setText(""+i);;
			label1.setBounds(10+(160*((i%96)/12)),(60*((i%96)%12)),150,50);
			label2.setBounds(10+(160*((i%96)/12)),(60*((i%96)%12))+30,150,50);
			//System.out.println("X= " + label1.getX() + "\tY= " +label1.getY()+"\ti= "+i );
			font1 = new Font(fonts[i],Font.PLAIN,18);
			label1.setFont(font1);
			label2.setFont(font2);
			if(i < 96)
			{
				f1.add(label1);
				f1.add(label2);
			}
			else if(i > 191)
			{
				f3.add(label1);
				f3.add(label2);
			}
			else
			{
				f2.add(label1);
				f2.add(label2);
			}
		}
		f1.pack();
		f2.pack();
		f3.pack();
	}
}