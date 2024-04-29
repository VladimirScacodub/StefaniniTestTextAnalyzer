package com.stefaninitest;

import com.stefaninitest.exceptions.ParameterException;

import java.io.IOException;

public class App {

    public static void main(String[] args) {
        TextHandler textHandler;
        try {
            Parameters parameters = Parameters.of(args);
            textHandler = new TextHandler(parameters.getTextFromFile());
            String info = textHandler.showInfo(parameters.getTop(), parameters.getPhraseSize());
            System.out.println(info);
        } catch (IOException | ParameterException e) {
            System.out.println(e.getMessage());
        }
    }

}
