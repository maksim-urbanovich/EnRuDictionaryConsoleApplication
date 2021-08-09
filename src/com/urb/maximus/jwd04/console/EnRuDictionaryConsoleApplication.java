package com.urb.maximus.jwd04.console;

import com.urb.maximus.jwd04.entity.EnRuPairOfWords;
import com.urb.maximus.jwd04.exception.DictionaryConsoleApplicationException;
import com.urb.maximus.jwd04.exception.DictionaryWordNotFoundException;
import com.urb.maximus.jwd04.service.EnRuDictionary;
import com.urb.maximus.jwd04.service.EnRuDictionaryImpl;
import com.urb.maximus.jwd04.service.InputProcessor;

import java.util.*;

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

    private final EnRuDictionary dictionary;
    private final InputProcessor inputProcessor;

    {
        inputProcessor = new InputProcessor();
    }

    public EnRuDictionaryConsoleApplication(EnRuDictionary enRuDictionary) {
        dictionary = enRuDictionary;
    }

    public void start() {
        boolean isRunning = true;

        while(isRunning) {
            printConsole(WELCOME_MESSAGE);
            printConsole(DELIMITER);

            int consoleChoice = getConsoleChoice();
            switch (consoleChoice) {
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

    private void addPairOfWords() {
        try {
            printConsole("Add pair of words.");
            String enWord = inputProcessor.getEnWord();
            String ruWord = inputProcessor.getRuWord();
            EnRuPairOfWords pairOfWords = new EnRuPairOfWords(enWord, ruWord);
            dictionary.addPairOfWordsToDictionary(pairOfWords);
            printConsole(pairOfWords.toString() + " was added to the dictionary");
        }
        catch (DictionaryConsoleApplicationException e) {
            printCaughtException(e);
        }
    }

    private void translateEnWord() {
        try {
            printConsole("Translation of english word");
            String enWord = inputProcessor.getEnWord();
            EnRuPairOfWords pairOfWords = new EnRuPairOfWords(enWord, null);
            dictionary.findRuWordFromEnWord(pairOfWords);
            printConsole("Translation of " + pairOfWords.getEnWord() + " is " + pairOfWords.getRuWord());
        }
        catch (DictionaryConsoleApplicationException | DictionaryWordNotFoundException e) {
            printCaughtException(e);
        }
    }


    private void translateRuWord() {
        try {
            printConsole("Translation of english word");
            String ruWord = inputProcessor.getRuWord();
            EnRuPairOfWords pairOfWords = new EnRuPairOfWords(null, ruWord);
            dictionary.findRuWordFromEnWord(pairOfWords);
            printConsole("Translation of " + pairOfWords.getRuWord() + " is " + pairOfWords.getEnWord());
        }
        catch (DictionaryConsoleApplicationException | DictionaryWordNotFoundException e) {
            printCaughtException(e);
        }
    }

    private void showNumberOfWords() {
        printConsole("Number of words in the dictionary is " + dictionary.getNumberOfWords());
    }

    private void showAllPairsOfWords() {
        dictionary.printAllPairsOfWords();
    }

    private void startQuiz() {
    }

    private int getConsoleChoice() {
        return inputProcessor.getChoice();
    }

    private void printConsole(final String message) {
        System.out.println(message);
    }

    private void printCaughtException(Exception e) {
        // здесь e.getMessage() возвращает сообщение, которое мы оставили, когда выбрасывали свою ошибку
        printConsole("Exception: Exception message is " + e.getMessage());
    }
}
