package core.basesyntax.fileservice.impl;

import core.basesyntax.fileservice.ReportGenerator;
import core.basesyntax.fileservice.FileWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CsvWriterImpl implements FileWriter {
    @Override
    public void writeTo(String fromString, String toFilePath) {

        if (fromString == null) {
            throw new RuntimeException("String from which should be written from is empty.");
        }

        if (toFilePath == null || toFilePath.isEmpty()) {
            throw new RuntimeException("The File Path that should be written to is empty.");
        }

        File csvOutputFile = new File(toFilePath);
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            pw.write(reportGenerator.getReport());
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Input file was not found");
        }
    }
}
