package com.goeuro.test;


import com.goeuro.test.connector.CsvConnector;
import com.goeuro.test.connector.RestDataConnector;
import com.goeuro.test.converter.JsonToObjectConverter;
import com.goeuro.test.model.GeoObject;
import com.goeuro.test.util.GenerateCsvFileName;
import com.goeuro.test.util.MessageUtils;
import com.goeuro.test.util.exception.CommunicationException;

import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {

        if (args.length != 1 && args.length != 2) {
            MessageUtils.showWrongParamMsg();
            return;
        }

        try {
            RestDataConnector restDataConnector = new RestDataConnector();

            String jsonString = "";
            if (args.length == 1) {
                jsonString = restDataConnector.requestData(args[0]);
            } else {
                jsonString = restDataConnector.requestData(args[0], args[1]);
            }

            List<GeoObject> geoObjects = JsonToObjectConverter.convert(jsonString);

            if (geoObjects.isEmpty()) {
                MessageUtils.showNoResultMsg();
                return;
            }

            String fileName = GenerateCsvFileName.getFileName();

            String filePath = CsvConnector.objectToCsv(geoObjects, fileName);

            MessageUtils.showDoneMsg(filePath);
        } catch (IOException e) {
            MessageUtils.showIOExceptionErrorMsg(e);
        } catch (CommunicationException e) {
            MessageUtils.showCommunicationErrorMsg(e);
        }

    }
}
