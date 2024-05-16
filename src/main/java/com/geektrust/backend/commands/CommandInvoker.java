package com.geektrust.backend.commands;

import java.util.*;

public class CommandInvoker {

    private static final Map<String,ICommand> commandMap = new HashMap<>();

    public void register(String commandName,ICommand command)
    {
        commandMap.put(commandName, command);
    }

    private ICommand getCommand(String commandName)
    {
        return commandMap.get(commandName);
    }

    public void executeCommand(String commandName,List<String> tokens)
    {
        ICommand command = getCommand(commandName);

        if(command == null)
        {
            //throw exception
            System.out.println("Command NNot Found");
        }

        command.execute(tokens);
    }


    
}
