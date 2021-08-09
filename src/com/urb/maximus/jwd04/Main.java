package com.urb.maximus.jwd04;

import com.urb.maximus.jwd04.console.EnRuDictionaryConsoleApplication;
import com.urb.maximus.jwd04.service.EnRuDictionaryImpl;

public class Main {

    public static void main(String[] args) {
        EnRuDictionaryImpl dictionary = new EnRuDictionaryImpl();
        dictionary.initializeDictionary();
        EnRuDictionaryConsoleApplication app = new EnRuDictionaryConsoleApplication(dictionary);
        app.start();
    }
}
