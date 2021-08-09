package com.urb.maximus.jwd04.service;

import com.urb.maximus.jwd04.entity.EnRuPairOfWords;
import com.urb.maximus.jwd04.exception.DictionaryWordNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EnRuDictionaryImpl implements EnRuDictionary {
    private List<String> enWords = new ArrayList<>();
    private List<String> ruWords = new ArrayList<>();


    @Override
    public void initializeDictionary() {
        enWords.addAll(Arrays.asList("mother", "father", "son", "java", "word", "lesson", "house", "dot", "I", "do"));
        ruWords.addAll(Arrays.asList("мама", "папа", "сын", "джава", "слово", "урок", "дом", "точка", "я", "делать"));
    }

    @Override
    public void addPairOfWordsToDictionary(final EnRuPairOfWords pairOfWords) {
        int index = enWords.indexOf(pairOfWords.getEnWord());
        if (Integer.compare(index, -1) != 0) {
            ruWords.set(index, pairOfWords.getRuWord());
        }
        else {
            enWords.add(pairOfWords.getEnWord());
            ruWords.add(pairOfWords.getRuWord());
        }
    }

    @Override
    public void findRuWordFromEnWord(final EnRuPairOfWords pairOfWords) throws DictionaryWordNotFoundException {
        int index = enWords.indexOf(pairOfWords.getEnWord());
        if (Integer.compare(index, -1) != 0) {
           pairOfWords.setRuWord(pairOfWords.getRuWord());
        }
        else {
            throw new DictionaryWordNotFoundException("Word " + pairOfWords.getEnWord() + " is not in the dictionary");
        }
    }

    @Override
    public void findEnWordFromRuWord(final EnRuPairOfWords pairOfWords) throws DictionaryWordNotFoundException {
        int index = ruWords.indexOf(pairOfWords.getRuWord());
        if (Integer.compare(index, -1) != 0) {
            pairOfWords.setEnWord(pairOfWords.getRuWord());
        }
        else {
            throw new DictionaryWordNotFoundException("Word " + pairOfWords.getRuWord() + " is not in the dictionary");
        }
    }

    @Override
    public int getNumberOfWords() {
        return enWords.size();
    }

    @Override
    public void printAllPairsOfWords() {
        for (int i = 0; i < enWords.size(); i++) {
            //System.out.println(enWords.get(i) + " - " + ruWords.get(i));
            System.out.println(new EnRuPairOfWords(enWords.get(i), ruWords.get(i)));
        }
    }
}
