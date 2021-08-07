package com.urb.maximus.jwd04.service;

import com.urb.maximus.jwd04.entity.EnRuPairOfWords;

public interface EnRuDictionary {
    void addPairOfWordsInDictionary(final EnRuPairOfWords);
    void findRuWordFromEnWord(String enWord);
    void findEnWordFromRuWord(String ruWord);
    void printNumberOfWords();
    void printAllPairsOfWords();
}
