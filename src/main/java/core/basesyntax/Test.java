package core.basesyntax;

import core.basesyntax.fileservice.reader.CsvReaderImpl;
import core.basesyntax.fileservice.reader.FileReader;
import core.basesyntax.fileservice.writer.FileWriter;
import core.basesyntax.transaction.FruitTransaction;

/**
 * Feel free to remove this class and create your own.
 */
public class Test {
    public static void main(String[] args) {
        FruitTransaction fruitTransaction = new FruitTransaction();

        FileReader fileReader = new CsvReaderImpl();

        System.out.println(fileReader.readFile("input_data.csv"));
    }
}
