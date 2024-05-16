package com.geektrust.backend.commands;

import java.util.*;

public interface ICommand {
    void execute(List<String> tokens);
}
