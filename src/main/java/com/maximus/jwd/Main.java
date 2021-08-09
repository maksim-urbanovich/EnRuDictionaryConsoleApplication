package main.java.com.maximus.jwd;

import main.java.com.maximus.jwd.console.EnRuDictionaryConsoleApplication;
import main.java.com.maximus.jwd.service.EnRuDictionaryImpl;

public class Main {

    public static void main(String[] args) {
        EnRuDictionaryImpl dictionary = new EnRuDictionaryImpl();
        dictionary.initializeDictionary();
        EnRuDictionaryConsoleApplication app = new EnRuDictionaryConsoleApplication(dictionary);
        app.start();
    }
}
