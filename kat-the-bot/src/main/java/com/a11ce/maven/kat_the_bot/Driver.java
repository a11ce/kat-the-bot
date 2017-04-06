package com.a11ce.maven.kat_the_bot;

import java.io.IOException;

public class Driver {
	
	static Trainer train;
	static Generator gen;
	static String workDir;
	
	public static void main(String[] args) throws IOException {

		workDir = System.getProperty("user.dir") + "/memory";
		System.out.println(workDir);
		train = new Trainer(workDir);
		gen = new Generator(workDir);
		
		train.trainSentence("Hi my name is kat");
		System.out.println(gen.makeSent());
		
	}

}
