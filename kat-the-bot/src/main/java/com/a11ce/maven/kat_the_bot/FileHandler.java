package com.a11ce.maven.kat_the_bot;

import java.io.*;

public class FileHandler {

	private String workDir;

	FileHandler() throws Exception
	{
		throw new Exception ("filepath.not.given.to.handler");
	}
	FileHandler(String s)
	{
		workDir = s;
	}
	public Word readMem(String word)

	{
		try{


			FileInputStream fileIn = new FileInputStream(workDir + "/" + word + ".kat");
		//	@SuppressWarnings("resource")
			ObjectInputStream in = new ObjectInputStream(fileIn);
			Word rObj = (Word) in.readObject();
			in.close();
			return rObj;
		}
		
		catch(Exception ex)
		{
			ex.printStackTrace();//TODO what should go here
		}
		return null;
	}
	
	public void writeMem(Word testObj) throws IOException
	{
		String fileDir = workDir + "/" + testObj.getWord() + ".kat";
		System.out.println(fileDir);
		FileOutputStream fout = new FileOutputStream(fileDir);
		
		//@SuppressWarnings("resource")
		ObjectOutputStream out = new ObjectOutputStream(fout);
		out.writeObject(testObj);
		out.close();
	}
	public boolean exists(String word)
	{
		return new File(workDir + "/" + word + ".kat").isFile();
	}

}
