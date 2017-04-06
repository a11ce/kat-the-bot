package com.a11ce.maven.kat_the_bot;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class KatBrain {
	//private String workDir;
	FileHandler brainWriter;
	ArrayList<String> memList;
	Random randomizer;
//	KatBrain() throws Exception
//	{
//		throw new Exception("KatBrain.init.workDir.missing");
//	}
	
	KatBrain(String wD) throws IOException
	{
		memList = new ArrayList<String>();
		brainWriter = new FileHandler(wD);
		randomizer = new Random();
		Runtime.getRuntime().exec("/bin/bash -c mkdir " + wD);
		
		File workDir = new File(wD);
		File[] fileArr = workDir.listFiles();
		if(fileArr.length != 0)
		{
			
		
		for(int i = 0; i < fileArr.length; i++)
		{
			memList.add( fileArr[i].getName().substring(0, fileArr[i].getName().length() - 4));
		}
		}
		
	}
	
	
	public void learnWord(String inWord, boolean start, String nextWord) throws IOException
	{
		Word tempWord;
		if(brainWriter.exists(inWord))
		{
			 tempWord = brainWriter.readMem(inWord);
			if(start){ tempWord.makeFirst(); }
			tempWord.addWord(nextWord);
		}
		else
		{
			 tempWord = new Word(inWord);
			tempWord.addWord(nextWord);
		}
		brainWriter.writeMem(tempWord);
	}
	public String pickFirst()
	{
		ArrayList<Word> tempFirstList = new ArrayList<Word>();
		for(int i = 0; i < memList.size(); i++)
		{
			Word curWord = brainWriter.readMem(memList.get(i));
			if(curWord.getFirst())
			{
				tempFirstList.add(curWord);
			}
		}
		
		System.out.println("TFL SIZE " + tempFirstList.size());
		return tempFirstList.get(new Random().nextInt(tempFirstList.size())).getWord();		
	}
	
	public String pickNext(String prevString)
	{
		Word prevWord = brainWriter.readMem(prevString);
		
		ArrayList<String> all = new ArrayList<String>();
		for(int i = 0; i < prevWord.assocs.size(); i++)
		{
			for(int j = 0; j < prevWord.assocs.get(i).getStrength() ; j++)
			{
				all.add(prevWord.assocs.get(i).getWord());
			}
		}
		return all.get(new Random().nextInt(all.size()));
	}
	

	
}
