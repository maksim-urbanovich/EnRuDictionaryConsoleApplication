package com.urb.maximus.jwd04.console;

import com.urb.maximus.jwd04.service.EnRuDictionary;
import com.urb.maximus.jwd04.service.EnRuDictionaryImpl;
import com.urb.maximus.jwd04.service.InputProcessor;

import java.util.Locale;
import java.util.Scanner;

public class EnRuDictionaryConsoleApplication {
    public static final String WELCOME_MESSAGE = "Press:" +
            "\n 0 - Exit" +
            "\n 1 - Add pair of words" +
            "\n 2 - Find translation of english word" +
            "\n 3 - Find translation of russian word" +
            "\n 4 - Show number of words" +
            "\n 5 - Show all pairs of words" +
            "\n 6 - Quiz"
            ;
    public static final int EXIT = 0, ADD_PAIR_OF_WORDS = 1, EN_WORD_TRANSLATION = 2, RU_WORD_TRANSLATION = 3, SHOW_NUMBER_OF_WORDS = 4,
            SHOW_ALL_PAIRS_OF_WORDS = 5, QUIZ = 6, RESTART_VALUE = 999;
    public static final String DELIMITER = "\n==============================================\n";

    private final EnRuDictionary enRuDictionary;
    private final InputProcessor inputProcessor;
    private final Scanner scanner;
    {
        inputProcessor = new InputProcessor();
        scanner = new Scanner(System.in);
    }

    public EnRuDictionaryConsoleApplication(EnRuDictionary enRuDictionary) {
        this.enRuDictionary = enRuDictionary;
    }

    public void start() {
        boolean isRunning = true;

        while(isRunning) {
            printConsole(WELCOME_MESSAGE);
            printConsole(DELIMITER);

            int consoleChoise = inputProcessor.getChoise();
            switch (consoleChoise) {
                case EXIT:
                    isRunning = false;
                    printConsole("App closes.");
                    break;
                case ADD_PAIR_OF_WORDS:
                    addPairOfWords();
                    break;
                case EN_WORD_TRANSLATION:
                    translateEnWord();
                    break;
                case RU_WORD_TRANSLATION:
                    translateRuWord();
                    break;
                case SHOW_NUMBER_OF_WORDS:
                    showNumberOfWords();
                    break;
                case SHOW_ALL_PAIRS_OF_WORDS:
                    showAllPairsOfWords();
                    break;
                case QUIZ:
                    startQuiz();
                    break;

                default:
                    printConsole("Invalid choice. Restarting app." + DELIMITER);
            }
        }
    }

    private void translateEnWord() {
    }

    private void addPairOfWords() {
    }

    private void translateRuWord() {
    }

    private void showNumberOfWords() {
    }

    private void showAllPairsOfWords() {
    }

    private void startQuiz() {
    }

    private int getConsoleChoise() {
        return inputProcessor.getChoise();
    }

    private void printConsole(final String message) {
        System.out.println(message);
    }
}
