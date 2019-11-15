package DBInterface.repository;

import java.util.ArrayList;

import DBInterface.model.LifeBlock;



public interface LifeBlockRepository 
{
	ArrayList<LifeBlock> getAllLifeBlocks();
	LifeBlock getLifeBlockByCompany(String company);
	ArrayList<LifeBlock> getLifeBlocksOf(String userName);
	ArrayList<LifeBlock> getLifeBlocksNotOf(String userName); 
	int insertLifeBlock(LifeBlock lB);
	void updateLifeBlock(LifeBlock lB);
	void deleteLifeBlock(LifeBlock lB);
}
