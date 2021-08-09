package main.java.com.maximus.jwd.service;

import main.java.com.maximus.jwd.console.EnRuDictionaryConsoleApplication;
import main.java.com.maximus.jwd.exception.DictionaryConsoleApplicationException;
import main.java.com.maximus.jwd.validator.DictionaryWordsValidator;

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
