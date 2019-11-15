package GUIInterface;

import java.util.Stack;

public class Session 
{
	private static CustomFrame hLO;//Home Logged out
	
	public static void main(String[] args) 
	{
		hLO = new CustomFrame("Home - Logged out");
		//Start on home page//
		HomeLoggedOut P1 = new HomeLoggedOut(hLO);
		
	}
}
