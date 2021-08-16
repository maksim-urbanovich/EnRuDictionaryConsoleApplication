package com.maximus.jwd.service.impl;

import  com.maximus.jwd.console.EnRuDictionaryConsoleApplication;
import  com.maximus.jwd.exception.DictionaryConsoleApplicationException;
import  com.maximus.jwd.service.InputProcessor;
import  com.maximus.jwd.validator.DictionaryWordsValidator;

import java.util.Scanner;

public class InputProcessorImpl implements InputProcessor {
    private final Scanner scanner;
    private DictionaryWordsValidator validator;

    {
        scanner = new Scanner(System.in);
        validator = new DictionaryWordsValidator();
    }

    @Override
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
        final String next = scanner.nextLine();
        printConsole("Entered next=[" + next + "].");
    }

    private void printConsole(final String message) {
        System.out.println(message);
    }

    @Override
    public String getEnWord() throws DictionaryConsoleApplicationException {
        System.out.print("Enter english word: ");
        String word = "";
        try {
            if (scanner.hasNext()) {
                word = scanner.next();
            }
            validator.validateEnWord(word);
        }
        catch (DictionaryConsoleApplicationException e) {
            throw e;
        }
        return word;
    }

    @Override
    public String getRuWord() throws DictionaryConsoleApplicationException {
        System.out.print("Enter russian word: ");
        String word = "";
        try {
            if (scanner.hasNext()) {
                word = scanner.next();
            }
            validator.validateRuWord(word);
        }
        catch (DictionaryConsoleApplicationException e) {
            throw e;
        }
        return word;
    }
}
