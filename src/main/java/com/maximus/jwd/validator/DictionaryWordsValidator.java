package main.java.com.maximus.jwd.validator;

import main.java.com.maximus.jwd.exception.DictionaryConsoleApplicationException;

public class DictionaryWordsValidator {
    private final String REG_EX_EN = "[a-zA-Z]+$";
    private final String REG_EX_RU = "[а-яА-Я]+$";

    public void validateEnWord(String word) throws DictionaryConsoleApplicationException {
        if (!word.matches(REG_EX_EN)) {
            throw new DictionaryConsoleApplicationException("You write not an english word");
        }
    }

    public void validateRuWord (String word) throws DictionaryConsoleApplicationException {
        if (!word.matches(REG_EX_RU)) {
            throw new DictionaryConsoleApplicationException("You write not a russian word");
        }
    }

}
