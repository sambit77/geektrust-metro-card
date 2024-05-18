package com.geektrust.backend.commands;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.geektrust.backend.services.IStationService;

@DisplayName("PrintSummaryCommand Test")
@ExtendWith(MockitoExtension.class)
public class PrintsummaryCommandTest {
    
    @Mock
    private IStationService stationService;
    @InjectMocks
    private PrintSummaryCommand printSummaryCommand;

    @Test
    @DisplayName("print summary command should invoke printsummary method")
    public void testPrintSummaryCommand()
    {
    
        List<String> inputCommand = new ArrayList<String>();
        inputCommand.add("PRINT_SUMMARY");
        printSummaryCommand.execute(inputCommand);
        Mockito.verify(stationService,times(2)).printSummary(any());
    }
}
