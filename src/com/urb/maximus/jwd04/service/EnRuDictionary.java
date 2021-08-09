package com.urb.maximus.jwd04.service;

import com.urb.maximus.jwd04.entity.EnRuPairOfWords;
import com.urb.maximus.jwd04.exception.DictionaryWordNotFoundException;

public interface EnRuDictionary {
    void initializeDictionary();
    void addPairOfWordsToDictionary(final EnRuPairOfWords pairOfWords);
    void findRuWordFromEnWord(final EnRuPairOfWords pairOfWords) throws DictionaryWordNotFoundException;
    void findEnWordFromRuWord(final EnRuPairOfWords pairOfWords) throws DictionaryWordNotFoundException;
    int getNumberOfWords();
    void printAllPairsOfWords();
}
