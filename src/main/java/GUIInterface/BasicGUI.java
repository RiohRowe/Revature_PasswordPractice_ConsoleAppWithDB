package GUIInterface;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
public class BasicGUI 
{
	static JTextField textfield1, textfield2, textfield3;
	
	 public static void main(String[] args) throws InterruptedException
	 {
		 JFrame f = new JFrame("Text Field Examples");
		 f.getContentPane().setLayout(new FlowLayout());
		 textfield1 = new JTextField("Text field 1",1);
		 textfield2 = new JTextField("Text field 2",10);
		 textfield3 = new JTextField("Text field 3",100);
		 /*f.getContentPane().add(textfield1);
		 f.getContentPane().add(textfield2);
		 f.getContentPane().add(textfield3);
		 */
		 f.pack();
		 f.setVisible(true);
		 int topLeftx = 100;
		 int topLefty = 100;
		 int width = 140;
		 int height = 40;
		            
		JButton b=new JButton("Play", new ImageIcon("C:\\Users\\rrowe\\Desktop\\Repos\\Project0\\src\\GUIInterface\\Play.jpg"));    
		b.setBounds(topLeftx,topLefty,width,height);    
		f.add(b);    
		topLeftx = 0;
		topLefty = 0;
		while (topLeftx < 200)
		{
			topLeftx = topLefty = topLeftx+10;
			b.setBounds(topLeftx,topLefty,width,height);
		    Thread.sleep(10);
		}
		f.setSize(300,400);    
		f.setLayout(null);       
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
		JLabel label = new JLabel();
		label.setText("text");
		label.setText("Enter Name :");
		label.setBounds(0,0,width*2,height*2);
		JLabel label1 = new JLabel();
		label1.setText("");
		label1.setBounds(topLeftx+100,topLefty,width,height*2);
		JTextField textfield= new JTextField();
		textfield.setBounds(topLeftx +100, topLefty - 100,width,height);

		f.add(label1);
		f.add(textfield);
		f.add(label);
		label.setHorizontalAlignment(0);
		//action listener
		b.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				label1.setText("Name has been submitted.");				
			}          
		}); 
	 }            
}
