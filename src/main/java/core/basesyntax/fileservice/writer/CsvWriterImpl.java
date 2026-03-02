package core.basesyntax.fileservice.writer;

import core.basesyntax.fileservice.report.ReportGenerator;
import core.basesyntax.fileservice.report.ReportGeneratorImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class CsvWriterImpl implements FileWriter {
    @Override
    public void writeTo(String fromString, String toFilePath) {
        File csvOutputFile = new File(toFilePath);
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            pw.write(reportGenerator.getReport());
        } catch (IOException e) {
            return;
        }
    }
}
