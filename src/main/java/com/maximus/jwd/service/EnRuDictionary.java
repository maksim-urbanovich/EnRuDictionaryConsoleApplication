package main.java.com.maximus.jwd.service;

import main.java.com.maximus.jwd.entity.EnRuPairOfWords;
import main.java.com.maximus.jwd.exception.DictionaryWordNotFoundException;

import java.util.List;

public interface EnRuDictionary {
    void initializeDictionary();
    void addPairOfWordsToDictionary(final EnRuPairOfWords pairOfWords);
    String translateEnWord(String input) throws DictionaryWordNotFoundException;
    String translateRuWord(String input) throws DictionaryWordNotFoundException;
    int getNumberOfWords();
    void printAllPairsOfWords();
    void startQuiz();
    List<EnRuPairOfWords> getListForQuiz();
}
