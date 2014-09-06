package com.goeuro.test.util;


import com.goeuro.test.util.exception.CommunicationException;

import java.io.IOException;

public final class MessageUtils {

    private MessageUtils(){}

    public static void showWrongParamMsg(){
        System.out.println("Oops. Incorrect number of parameters");
        System.out.println("java -jar GoEuroTest.jar Berlin ");
        System.out.println("OR");
        System.out.println("java -jar GoEuroTest.jar 52.52437 13.41053 ");
    }

    public static void showCommunicationErrorMsg(CommunicationException e) {
        System.out.println("Can't load data: "+e.getMessage());
    }

    public static void showIOExceptionErrorMsg(IOException e) {
        System.out.println("Can't save file: "+e.getMessage());
    }

    public static void showDoneMsg(String filePath) {
        System.out.println("Data has been successfully saved to file: "+filePath);
    }

    public static void showNoResultMsg() {
        System.out.println("Wasn't found any location. Nothing to save. Please check request parameter(s)");
    }
}
