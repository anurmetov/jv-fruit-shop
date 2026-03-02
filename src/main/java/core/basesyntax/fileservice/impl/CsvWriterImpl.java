package core.basesyntax.fileservice.impl;

import core.basesyntax.fileservice.FileWriter;
import core.basesyntax.fileservice.ReportGenerator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CsvWriterImpl implements FileWriter {
    private static final String DEFAULT_ORDER_PATH = "src/main/resources/";

    @Override
    public void writeTo(String fromString, String toFilePath) {

        if (fromString == null || fromString.isEmpty()) {
            throw new
                    RuntimeException("String from which should be written from is empty: "
                    + fromString);
        }

        if (toFilePath == null || toFilePath.isEmpty()) {
            throw new
                    RuntimeException("The File Path that should be written to is empty: "
                    + toFilePath);
        }

        File csvOutputFile = new File(toFilePath);
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        try (PrintWriter pw = new PrintWriter(DEFAULT_ORDER_PATH + csvOutputFile)) {
            pw.write(reportGenerator.getReport());
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Input file was not found: " + toFilePath);
        }
    }
}
