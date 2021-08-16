package com.maximus.jwd.service;

import  com.maximus.jwd.exception.DictionaryConsoleApplicationException;

public interface InputProcessor {
    public int getChoice();
    public String getEnWord() throws DictionaryConsoleApplicationException;
    public String getRuWord() throws DictionaryConsoleApplicationException;
}
