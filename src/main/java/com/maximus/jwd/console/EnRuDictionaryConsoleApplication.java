package main.java.com.maximus.jwd.console;

import main.java.com.maximus.jwd.entity.EnRuPairOfWords;
import main.java.com.maximus.jwd.exception.DictionaryConsoleApplicationException;
import main.java.com.maximus.jwd.exception.DictionaryWordNotFoundException;
import main.java.com.maximus.jwd.service.EnRuDictionary;
import main.java.com.maximus.jwd.service.InputProcessor;

import java.util.ArrayList;
import java.util.List;

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
    public static final String DELIMITER = "==============================================";

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
                    printConsole("Invalid choice. Restarting app.\n" + DELIMITER);
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
            printConsole(pairOfWords + " was added to the dictionary");
        }
        catch (DictionaryConsoleApplicationException e) {
            printCaughtException(e);
        }
    }

    private void translateEnWord() {
        try {
            String enWord = inputProcessor.getEnWord();
            String ruWord = dictionary.translateEnWord(enWord);
            printConsole("Translation of " + enWord + " is " + ruWord);
        }
        catch (DictionaryConsoleApplicationException | DictionaryWordNotFoundException e) {
            printCaughtException(e);
        }
    }

    private void translateRuWord() {
        try {
            String ruWord = inputProcessor.getRuWord();
            List<String> listOfTranslations = dictionary.translateRuWord(ruWord);
            printConsole("Translation of " + ruWord + " is " + listOfTranslations);
        }
        catch (DictionaryConsoleApplicationException | DictionaryWordNotFoundException e) {
            printCaughtException(e);
        }
    }

    private void showNumberOfWords() {
        printConsole("Number of words in the dictionary is " + dictionary.getNumberOfWords());
        printConsole(DELIMITER);
    }

    private void showAllPairsOfWords() {
        dictionary.printAllPairsOfWords();
        printConsole(DELIMITER);
    }

    private void startQuiz() {
        List<EnRuPairOfWords> listOfWordsForQuiz = dictionary.getListForQuiz(); //todo:  add variable number of words in quiz
        printConsole("Translate following words into russian:");
        printWordsForQuiz(listOfWordsForQuiz);

        List<EnRuPairOfWords> listOfWrongWords = new ArrayList<>();
        double percentOfRightAnswers = 0.0;

        for (int i = 0; i < 5; i++) {
            try {
                String ruWord = inputProcessor.getRuWord();
                if (ruWord.equals(listOfWordsForQuiz.get(i).getRuWord())) {
                    percentOfRightAnswers += 20;
                }
                else {
                    listOfWrongWords.add(listOfWordsForQuiz.get(i));
                }
            }
            catch (DictionaryConsoleApplicationException e) {
                printCaughtException(e);
            }
        }
        printResultOfQuiz(percentOfRightAnswers, listOfWrongWords);
    }

    private void printWordsForQuiz(List<EnRuPairOfWords> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).getEnWord() + " | ");
        }
        System.out.println();
    }

    private void printResultOfQuiz(double percentOfRightAnswers, List<EnRuPairOfWords> listOfWrongAnswers) {
        if (Double.compare(percentOfRightAnswers, 100.0) == 0){
            printConsole("Well done! You are rock!!");
        }
        else {
            printConsole(DELIMITER);
            printConsole("You have " + percentOfRightAnswers + "% of right answers");
            printConsole("You wrong in next words:");
            for (int i = 0; i < listOfWrongAnswers.size(); i++) {
                printConsole(listOfWrongAnswers.get(i).toString());
            }
        }
        printConsole(DELIMITER);
    }

    private int getConsoleChoice() {
        return inputProcessor.getChoice();
    }

    private void printConsole(final String message) {
        System.out.println(message);
    }

    private void printCaughtException(Exception e) {
        // здесь e.getMessage() возвращает сообщение, которое мы оставили, когда выбрасывали свою ошибку
        printConsole("Exception: " + e.getMessage());
    }


}
