package com.a11ce.maven.kat_the_bot;

import java.io.Serializable;
import java.util.ArrayList;

public class Word implements Serializable {
	private ArrayList<Association> assocs;
	private boolean isFirst;
	private boolean isLast;
	
	private String thisWord;
	
	public Word(String _thisWord)
	{
		thisWord = _thisWord;
		assocs = new ArrayList<Association>();
		isFirst = false;
		isLast = false;
	}
	public String getWord()
	{
		return thisWord;
	}
	public void makeFirst()
	{
		isFirst = true;
	}
	public void makeLast()
	{
		isLast = true;
	}
	public boolean getFirst()
	{
		return this.isFirst;
	}
	public boolean getLast()
	{
		return this.isLast;
	}
	public void addWord(String inWord)
	{
		inWord = inWord.trim().toLowerCase();
		boolean alreadyKnows = false;// TODO: temporary, replace by condensing if
		int alreadyKnowsIndex = -1;  // TODO: temporary, replace by condensing if
		for(int i = 0; i < assocs.size(); i++)
		{
			if(assocs.get(i).getWord().equalsIgnoreCase(inWord))
			{
				alreadyKnows = true;
				alreadyKnowsIndex = i;
			}
		}
		if(alreadyKnows == true)
		{
			assocs.set(alreadyKnowsIndex, assocs.get(alreadyKnowsIndex).addStrength());
		}
		else
		{
			assocs.add(new Association(inWord));
		}
	}
}


