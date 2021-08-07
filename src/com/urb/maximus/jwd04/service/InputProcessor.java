package com.urb.maximus.jwd04.service;

import com.urb.maximus.jwd04.console.EnRuDictionaryConsoleApplication;

import java.util.Scanner;

public class InputProcessor {
    private final Scanner scanner;

    {
        scanner = new Scanner(System.in);
    }

    public int getChoise() {
        int choice = 0;

        if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
        } else {
            cleanScannerNextEnteredValue();
            choice = EnRuDictionaryConsoleApplication.RESTART_VALUE;
        }

        return choice;
    }

    private void cleanScannerNextEnteredValue() {
        final String next = scanner.next();
        printConsole("Entered next=[" + next + "].");
    }

    private void printConsole(final String message) {
        System.out.println(message);
    }


}
