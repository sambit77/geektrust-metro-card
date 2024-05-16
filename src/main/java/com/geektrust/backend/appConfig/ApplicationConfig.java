package com.geektrust.backend.appConfig;

import com.geektrust.backend.commands.BalanceCommand;
import com.geektrust.backend.commands.CheckInCommand;
import com.geektrust.backend.commands.CommandInvoker;
import com.geektrust.backend.commands.PrintSummaryCommand;
import com.geektrust.backend.repositories.CardRepository;
import com.geektrust.backend.repositories.ICardRepository;
import com.geektrust.backend.services.CardService;
import com.geektrust.backend.services.ICardService;
import com.geektrust.backend.services.IStationService;
import com.geektrust.backend.services.StationService;

public class ApplicationConfig {
    
    private final ICardRepository cardRepository = new CardRepository();

    private final ICardService cardService = new CardService(cardRepository);
    private final IStationService stationService = new StationService(cardRepository);

    private final BalanceCommand balanceCommand = new BalanceCommand(cardService);
    private final CheckInCommand checkInCommand = new CheckInCommand(cardService,stationService);
    private final PrintSummaryCommand printSummaryCommand = new PrintSummaryCommand(stationService);

    private final CommandInvoker commandInvoker = new CommandInvoker();

    public CommandInvoker getCommandInvoker()
    {
        commandInvoker.register("BALANCE", balanceCommand);
        commandInvoker.register("CHECK_IN", checkInCommand);
        commandInvoker.register("PRINT_SUMMARY", printSummaryCommand);

        return commandInvoker;
    }


}
