package core.basesyntax.fileservice.report;

import core.basesyntax.db.Storage;

import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator{
    @Override
    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit").append(", quantity").append(System.lineSeparator());

        for (Map.Entry<String, Integer> entry : Storage.FRUIT_STORAGE.entrySet()) {
            stringBuilder
                    .append(entry.getKey())
                    .append(", ")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }

        return stringBuilder.toString().trim();
    }
}
