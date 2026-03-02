package core.basesyntax.fileservice.impl;

import core.basesyntax.fileservice.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CsvReaderImpl implements FileReader {
    private static final String COMMA_DELIMITER = ",";
    private static final String DEFAULT_ORDER_PATH = "src/main/resources/";

    @Override
    public List<String> readFile(String fileName) {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br =
                     new BufferedReader(new java.io.FileReader(DEFAULT_ORDER_PATH + fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                records.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            throw new RuntimeException("File was not found: " + fileName);
        }
        return records
                .stream()
                .flatMap(Collection::stream)
                .toList();
    }
}
