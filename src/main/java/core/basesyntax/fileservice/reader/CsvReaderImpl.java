package core.basesyntax.fileservice.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvReaderImpl implements FileReader {
    public static final String COMMA_DELIMITER = ",";

    private String filePath;

    public CsvReaderImpl(String filePath) {
        this.filePath = filePath;
    }

    private String getFilePath() {
        return filePath;
    }

    @Override
    public List<List<String>> readFile() {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(getFilePath()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                records.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return records;
    }
}
