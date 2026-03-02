package core.basesyntax.fileservice.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.fileservice.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String STRING_TITLE = "fruit,quantity" + System.lineSeparator();
    private static final String COMMA_DELIMITER = ",";

    @Override
    public String getReport() {
        if (Storage.FRUIT_STORAGE.isEmpty()) {
            throw new RuntimeException("The fruit storage is empty: " + Storage.FRUIT_STORAGE);
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(STRING_TITLE);

        for (Map.Entry<String, Integer> entry : Storage.FRUIT_STORAGE.entrySet()) {
            stringBuilder
                    .append(entry.getKey())
                    .append(COMMA_DELIMITER)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }

        return stringBuilder.toString().trim();
    }
}
