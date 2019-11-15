package GUIInterface;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.Border;

import DBInterface.model.LifeBlock;

import java.awt.geom.Ellipse2D;
import java.nio.ByteBuffer;
import java.util.Random;

public class TestFunctionality 
{
	public static void main(String[] args) 
	{
		
		int frameSize = 500;
		String ImgURL = "C:\\Users\\rrowe\\Desktop\\Repos\\Project0\\src\\GUIInterface\\Imgs\\";
		ImageIcon img = new ImageIcon(ImgURL.concat("wavy2.gif"));
		ImageIcon img2 = new ImageIcon(ImgURL.concat("Play.jpg"));

		LifeBlock lb = new LifeBlock(img2, "Amazon", false, false, true, 2);
		CustomFrame home1 = new CustomFrame("Home Menu");
		CustomFrame home2 = new CustomFrame("Popup1");
		CustomFrame home3 = new CustomFrame("Popup2");
		LifeBlockWork wh = new LifeBlockWork(lb, home1);		
		

		DialoguePopup dp2 = new DialoguePopup(home3, "The quick onyx goblin jumps over the lazy dwarf",
														51, 0, 90);
		DialoguePopup dp = new DialoguePopup(home2);
	}
}
