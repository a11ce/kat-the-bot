package com.a11ce.maven.kat_the_bot;

import java.io.IOException;

public class Trainer {

	private KatBrain brain;
	
	Trainer(String wD) throws IOException
	{
		brain = new KatBrain(wD);
		
	}
	
	public void trainSentence(String in) throws IOException
	{
		this.trainSentence(in.split(" "));
	}
	
	public void trainSentence(String[] in) throws IOException
	{
		for(int j = 0; j < in.length; j++)
		{
			in[j] = formatfix(in[j]);
		}
			
			
			
		brain.learnWord(in[0], true, in[1]);
		
		for(int i = 1; i < in.length -1 ; i++)
		{
			brain.learnWord(in[i], false, in[ i + 1]);
		}
		brain.learnWord(in [ in.length -1 ], false, ".");
	
	}
	
	public String formatfix(String in)
	{
		return in.toLowerCase()
				.replaceAll("[?!]", ".")
				.replace("[_+-,@#$%^&*();\\/|<>\"']", "")
				;
	}
}
