package com.maximus.jwd.service;

import  com.maximus.jwd.entity.EnRuPairOfWords;
import  com.maximus.jwd.exception.DictionaryWordNotFoundException;

import java.util.List;

public interface EnRuDictionary {
    void initializeDictionary();
    void addPairOfWordsToDictionary(final EnRuPairOfWords pairOfWords);
    String translateEnWord(String input) throws DictionaryWordNotFoundException;
    List<String> translateRuWord(String input) throws DictionaryWordNotFoundException;
    int getNumberOfWords();
    void printAllPairsOfWords();
    void startQuiz();
    List<EnRuPairOfWords> getListForQuiz();
}
