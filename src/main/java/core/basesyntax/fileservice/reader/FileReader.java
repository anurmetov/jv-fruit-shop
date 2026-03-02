package core.basesyntax.fileservice.reader;

import java.util.List;

public interface FileReader {
    List<String> readFile(String fileName);
}
