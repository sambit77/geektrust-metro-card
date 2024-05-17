package com.geektrust.backend;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.geektrust.backend.appConfig.ApplicationConfig;
import com.geektrust.backend.commands.CommandInvoker;

public class App {

	public static void main(String[] args) {
		//System.out.println("Welcome to Geektrust Backend Challenge!");
        /*Sample code to read from file passed as command line argument*/
		List<String> inputCommands = new ArrayList<String>();
        try {
            // the file to be opened for reading
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis); // file to be scanned
            // returns true if there is another line to read
            while (sc.hasNextLine()) {
               //Add your code here to process input commands
			   String line = sc.nextLine();
			   inputCommands.add(line);
            }
            sc.close(); // closes the scanner
        } catch (IOException e) {
        }

		run(inputCommands);
        
	}

	//respective comannds are invoked by command invoker
	public static void run(List<String> inputsCommands)
	{
		ApplicationConfig applicationConfig = new ApplicationConfig();
		CommandInvoker commandInvoker = applicationConfig.getCommandInvoker();

		for(String singleCommand: inputsCommands)
		{
			List<String> tokens = Arrays.asList(singleCommand.split(" "));
			commandInvoker.executeCommand(tokens.get(0), tokens);

		}


	}	
	

}
