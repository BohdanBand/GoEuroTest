package com.goeuro.test.util;


import java.text.SimpleDateFormat;
import java.util.Date;

public final class GenerateCsvFileName {

    public static final String CSV_FILE_EXTENSION = ".csv";

    private GenerateCsvFileName() {
    }

    public static String getFileName() {

        StringBuilder fileNameGenerator = new StringBuilder();
        fileNameGenerator.append("CSV_Report_");
        fileNameGenerator.append(new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss_S").format(new Date()));
        fileNameGenerator.append(CSV_FILE_EXTENSION);

        return fileNameGenerator.toString();
    }

}
