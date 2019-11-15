package DBInterface;

import DBInterface.model.LifeBlock;
import DBInterface.service.SessionService;

public class Driver {

	public static void main(String[] args) {
		
		//Let's attempt to pull some movies out of our database.
		 SessionService ss = new SessionService();
		
//		LifeBlock[] lbs = ss.getAllLifeBlocks();
//		for(int i = 0; i < lbs.length; i++)
//		{
//			System.out.println(lbs[i]);	
//		}
		//System.out.println(ss.getAllUsers());
		//System.out.println(ss.GetAccFromUnameAndCompany("Rowedsta123", "Amazon"));
		System.out.println(ss.isUsernameAvailable("Rowedsta123"));
		
		
		//Let's create a new movie to insert into our DB.
		
//		Movie m = new Movie(1, "My Movie Name", new Date(100000));
//		ms.insertMovie(m);
	}
}