package main.java.com.maximus.jwd.service;

import main.java.com.maximus.jwd.exception.DictionaryConsoleApplicationException;

public interface InputProcessor {
    public int getChoice();
    public String getEnWord() throws DictionaryConsoleApplicationException;
    public String getRuWord() throws DictionaryConsoleApplicationException;
}
