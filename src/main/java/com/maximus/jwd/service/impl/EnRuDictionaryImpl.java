package main.java.com.maximus.jwd.service.impl;

import main.java.com.maximus.jwd.entity.EnRuPairOfWords;
import main.java.com.maximus.jwd.exception.DictionaryWordNotFoundException;
import main.java.com.maximus.jwd.service.EnRuDictionary;

import java.util.*;

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
    public String translateEnWord(String input) throws DictionaryWordNotFoundException {
        String output = "";
        int index = enWords.indexOf(input);
        if (Integer.compare(index, -1) != 0) {
           output = ruWords.get(index);
        }
        else {
            throw new DictionaryWordNotFoundException("Word " + input + " is not in the dictionary");
        }
        return output;
    }

    @Override
    public List<String> translateRuWord(String input) throws DictionaryWordNotFoundException {
        List<String> listOfTranslations = new ArrayList<>();
        for (int i = 0; i < ruWords.size(); i++) {
            if (input.equals(ruWords.get(i))) {
                listOfTranslations.add(enWords.get(i));
            }
        }

        if (Integer.compare(listOfTranslations.size(), 0) == 0) {
            throw new DictionaryWordNotFoundException(input + " is not in the dictionary");
        }
        return listOfTranslations;
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

    @Override
    public void startQuiz(){

    }

    public List<EnRuPairOfWords> getListForQuiz() {
        List<Integer> listOfNumbersForQuiz = generateListOfNumbersForQuiz();
        List<EnRuPairOfWords> listOfWordsForQuiz = new ArrayList<>(5);
        for (Integer number: listOfNumbersForQuiz) {
            listOfWordsForQuiz.add(new EnRuPairOfWords(enWords.get(number), ruWords.get(number)));
        }
        return listOfWordsForQuiz;
    }

    private List<Integer> generateListOfNumbersForQuiz () {
        int numberOfWords = getNumberOfWords();
        Random random = new Random();
        Set<Integer> set = new HashSet<>(5);

        while (Integer.compare(set.size(), 5) != 0) {
            int number = random.nextInt(numberOfWords);
            set.add(number);
        }
        return new ArrayList<>(set);
    }
}
