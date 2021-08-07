package com.urb.maximus.jwd04.entity;

import java.util.Objects;

public class EnRuPairOfWords {
    private String enWord;
    private String ruWord;

    public EnRuPairOfWords(String enWord, String ruWord) {
        this.enWord = enWord;
        this.ruWord = ruWord;
    }

    public String getEnWord() {
        return enWord;
    }

    public void setEnWord(String enWord) {
        this.enWord = enWord;
    }

    public String getRuWord() {
        return ruWord;
    }

    public void setRuWord(String ruWord) {
        this.ruWord = ruWord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnRuPairOfWords that = (EnRuPairOfWords) o;
        return enWord.equals(that.enWord) && ruWord.equals(that.ruWord);
    }

    @Override
    public int hashCode() {
        return hashCodeForString(enWord) + hashCodeForString(ruWord);
    }

    public int hashCodeForString(String str) {
        int hash = 5381;

        for (int i = 0; i < str.length(); i++) {
            hash = ((hash << 5) + hash) + str.charAt(i); // hash * 33 + char[i]
        }

        return hash;
    }

    @Override
    public String toString() {
        return "EnRuPairOfWords{" +
                "enWord='" + enWord + '\'' +
                "- ruWord='" + ruWord + '\'' +
                '}';
    }
}
