package core.basesyntax.fileservice;

import java.util.Map;

public interface ReportGenerator {
    String getReport(Map<String, Integer> fruitData);
}
