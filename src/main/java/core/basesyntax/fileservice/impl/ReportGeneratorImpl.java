package core.basesyntax.fileservice.impl;

import core.basesyntax.fileservice.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String STRING_TITLE = "fruit,quantity" + System.lineSeparator();
    private static final String COMMA_DELIMITER = ",";

    @Override
    public String getReport(Map<String, Integer> fruitData) {
        if (fruitData == null) {
            throw new RuntimeException("The fruit storage is null");

        }

        if (fruitData.isEmpty()) {
            throw new RuntimeException("The fruit storage is empty");
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(STRING_TITLE);

        for (Map.Entry<String, Integer> entry : fruitData.entrySet()) {
            stringBuilder
                    .append(entry.getKey())
                    .append(COMMA_DELIMITER)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }

        return stringBuilder.toString().trim();
    }
}
