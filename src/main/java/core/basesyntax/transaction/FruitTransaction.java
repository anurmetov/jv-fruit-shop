package core.basesyntax.transaction;

import core.basesyntax.data.DataServiceImpl;
import core.basesyntax.fileservice.writer.FileWriter;
import core.basesyntax.fileservice.writer.CsvWriterImpl;
import core.basesyntax.fileservice.reader.CsvReaderImpl;
import core.basesyntax.fileservice.reader.FileReader;

public class FruitTransaction {
    private FileReader fileReader = new CsvReaderImpl("input_data.csv");
    private DataServiceImpl dataService = new DataServiceImpl();
    private FileWriter fileParser = new CsvWriterImpl();
}
