package com.maximus.jwd;

import  com.maximus.jwd.console.EnRuDictionaryConsoleApplication;
import  com.maximus.jwd.service.impl.EnRuDictionaryImpl;

public class Main {

    public static void main(String[] args) {
        EnRuDictionaryImpl dictionary = new EnRuDictionaryImpl();
        dictionary.initializeDictionary();
        EnRuDictionaryConsoleApplication app = new EnRuDictionaryConsoleApplication(dictionary);
        app.start();
    }
}
