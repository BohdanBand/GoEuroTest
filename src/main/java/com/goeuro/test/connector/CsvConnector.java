package com.goeuro.test.connector;


import com.csvreader.CsvWriter;
import com.goeuro.test.model.GeoObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvConnector {

    public static String objectToCsv(List<GeoObject> geoObjects, String fileName) throws IOException {

        File fileToSave = new File(fileName);

        CsvWriter csvOutput = new CsvWriter(new FileWriter(fileToSave, true), ',');

        addHeaders(csvOutput);

        fillData(geoObjects, csvOutput);

        csvOutput.close();
        return fileToSave.getAbsolutePath();
    }

    private static void fillData(List<GeoObject> geoObjects, CsvWriter csvOutput) throws IOException {

        for (GeoObject geoObject : geoObjects) {
            csvOutput.write(geoObject.getId());
            csvOutput.write(geoObject.getName());
            csvOutput.write(geoObject.getType());
            csvOutput.write(geoObject.getGeoPosition().getLatitude());
            csvOutput.write(geoObject.getGeoPosition().getLongitude());
//            csvOutput.write(geoObject.getCoreCountry());
//            csvOutput.write(geoObject.getCountry());
//            csvOutput.write(geoObject.getDistance());
//            csvOutput.write(geoObject.getFullName());
//            csvOutput.write(geoObject.getIataAirportCode());
//            csvOutput.write(geoObject.getInEurope());
//            csvOutput.write(geoObject.getKey());
//            csvOutput.write(geoObject.getLocationId());
            csvOutput.endRecord();
        }
    }

    private static void addHeaders(CsvWriter csvOutput) throws IOException {
        csvOutput.write("_id");
        csvOutput.write("name");
        csvOutput.write("type");
        csvOutput.write("latitude");
        csvOutput.write("longitude");
//        csvOutput.write("coreCountry");
//        csvOutput.write("country");
//        csvOutput.write("countryCode");
//        csvOutput.write("distance");
//        csvOutput.write("fullName");
//        csvOutput.write("iataAirportCode");
//        csvOutput.write("inEurope");
//        csvOutput.write("key");
//        csvOutput.write("locationId");
        csvOutput.endRecord();
    }
}
