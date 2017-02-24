package com.a11ce.maven.kat_the_bot;
import java.io.Serializable;
public class Association implements Serializable{
	private String targetWord;
	private int strength;
	
	public Association(String _targetWord)
	{
		targetWord = _targetWord;
		strength = 1;
	}
	public String toString()
	{
		return targetWord + " (" + strength +")";
	}
	public String getWord()
	{
		return targetWord;
	}
	public int getStrength()
	{
		return strength;
	}
	public Association addStrength()
	{
		strength++;
		return this;
	}

}
