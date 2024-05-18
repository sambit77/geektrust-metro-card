package com.geektrust.backend.commands;

import static org.mockito.ArgumentMatchers.anyList;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.geektrust.backend.exceptions.CommandNotFoundException;

@DisplayName("Command Invoker Test")
@ExtendWith(MockitoExtension.class)
public class CommandInvokerTest {

    private CommandInvoker commandInvoker;

    @Mock
    private BalanceCommand balanceCommand;
    @Mock
    private CheckInCommand checkInCommand;
    @Mock
    private PrintSummaryCommand printSummaryCommand;

    @BeforeEach
    public void setup()
    {
        commandInvoker = new CommandInvoker();
        commandInvoker.register("BALANCE", balanceCommand);
        commandInvoker.register("CHECK_IN", checkInCommand);
        commandInvoker.register("PRINT_SUMMARY", balanceCommand);
    }
    
    @Test
    @DisplayName("All the known commands should get invoked successfully")
    public void executeAnyGiveCommand() throws CommandNotFoundException
    {
        commandInvoker.executeCommand("BALANCE", anyList());
        commandInvoker.executeCommand("CHECK_IN", anyList());
        commandInvoker.executeCommand("PRINT_SUMMARY", anyList());
    }

    @Test
    @DisplayName("any invalid command should be handled by exception handlers")
    public void testExceptionForInvalidCommands()
    {
        Assertions.assertThrows( CommandNotFoundException.class, () -> commandInvoker.executeCommand("Random_command", new ArrayList<String>()));
    }
}
