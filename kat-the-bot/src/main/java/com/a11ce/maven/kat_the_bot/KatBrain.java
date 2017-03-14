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
	KatBrain() throws Exception
	{
		throw new Exception("KatBrain.init.workDir.missing");
	}
	
	KatBrain(String wD)
	{
		brainWriter = new FileHandler(wD);
		randomizer = new Random();
		
		File workDir = new File(wD);
		File[] fileArr = workDir.listFiles();
		for(int i = 0; i < fileArr.length; i++)
		{
			memList.add( fileArr[i].getName().substring(0, fileArr[i].getName().length() - 4));
		}
		
	}
	
	
	public void learnWord(Word inWord, boolean start, String nextWord) throws IOException
	{
		Word tempWord;
		if(brainWriter.exists(inWord.getWord()))
		{
			 tempWord = brainWriter.readMem(inWord.getWord());
			if(start){ tempWord.makeFirst(); }
			tempWord.addWord(nextWord);
		}
		else
		{
			 tempWord = new Word(inWord.getWord());
			tempWord.addWord(nextWord);
		}
		brainWriter.writeMem(tempWord);
	}
	public Word pickFirst()
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
		
		return tempFirstList.get(new Random().nextInt(tempFirstList.size()));
		
	}
	
}
