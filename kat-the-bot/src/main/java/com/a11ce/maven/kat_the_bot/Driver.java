package com.a11ce.maven.kat_the_bot;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Driver {
	
	static Trainer train;
	static Generator gen;
	static String workDir;
	
	public static void main(String[] args) throws IOException {

		workDir = System.getProperty("user.dir") + "/memory";
		System.out.println(workDir);
		train = new Trainer(workDir);
		gen = new Generator(workDir);
		
		String longString =  new String(Files.readAllBytes(Paths.get(  System.getProperty("user.dir")+ "/paris.txt")));
		
	//	train.trainLong(longString);
		
		System.out.println(gen.makeSent());
		
	}

}
