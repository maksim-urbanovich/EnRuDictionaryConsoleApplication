package com.urb.maximus.jwd04.service;

import com.urb.maximus.jwd04.console.EnRuDictionaryConsoleApplication;
import com.urb.maximus.jwd04.exception.DictionaryConsoleApplicationException;
import com.urb.maximus.jwd04.validator.DictionaryWordsValidator;

import java.util.Scanner;

public class InputProcessor {
    private final Scanner scanner;
    private DictionaryWordsValidator validator;

    {
        scanner = new Scanner(System.in);
        validator = new DictionaryWordsValidator();
    }

    public int getChoice() {
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

    public String getEnWord() throws DictionaryConsoleApplicationException {
        String word = "";
        try {
            if (scanner.hasNext()) {
                word = scanner.nextLine();
            }
            validator.validateEnWord(word);
        }
        catch (DictionaryConsoleApplicationException e) {
            throw e;
        }

        return word;
    }

    public String getRuWord() throws DictionaryConsoleApplicationException {
        String word = "";
        try {
            if (scanner.hasNext()) {
                word = scanner.nextLine();
            }
            validator.validateRuWord(word);
        }
        catch (DictionaryConsoleApplicationException e) {
            throw e;
        }

        return word;
    }
}
