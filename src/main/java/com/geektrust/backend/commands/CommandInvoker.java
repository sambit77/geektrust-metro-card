package com.geektrust.backend.commands;

import java.util.*;

import com.geektrust.backend.exceptions.CommandNotFoundException;



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
            try {
               throw new CommandNotFoundException(commandName+" not found");
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            
        }
        else
        {
            command.execute(tokens);
        }

        
    }


    
}
