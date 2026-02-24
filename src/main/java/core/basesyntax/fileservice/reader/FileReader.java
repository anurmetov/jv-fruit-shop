package core.basesyntax.fileservice.reader;

import java.io.FileNotFoundException;
import java.util.List;

public interface FileReader {
    List<List<String>> readFile();
}
