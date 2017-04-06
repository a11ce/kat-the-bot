package com.a11ce.maven.kat_the_bot;

import java.io.IOException;

public class Generator {
	KatBrain brain;
	
	Generator(String wd) throws IOException
	{
		brain = new KatBrain(wd);
	}
	
	public String makeSent()
	{
		String tempW = brain.pickFirst();
		String fullOut = tempW;
		
		do{
			fullOut += " ";
			tempW = brain.pickNext(tempW);
			fullOut += tempW;
			
		//	if(tempW.)
			
		}while(!tempW.equals("."));
		ENDOFWHILE:
		return fullOut;
	}
	
}
