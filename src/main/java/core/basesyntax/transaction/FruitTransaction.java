package core.basesyntax.transaction;

import core.basesyntax.data.DataProcessor;
import core.basesyntax.data.DataProcessorImpl;
import core.basesyntax.fileservice.writer.FileWriter;
import core.basesyntax.fileservice.writer.CsvWriterImpl;
import core.basesyntax.fileservice.reader.CsvReaderImpl;
import core.basesyntax.fileservice.reader.FileReader;

public class FruitTransaction {
    private FileReader fileReader = new CsvReaderImpl();
    private DataProcessor dataProcessor = new DataProcessorImpl();
    private FileWriter fileParser = new CsvWriterImpl();
}
