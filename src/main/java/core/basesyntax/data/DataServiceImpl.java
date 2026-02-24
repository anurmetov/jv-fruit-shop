package core.basesyntax.data;

import core.basesyntax.fileservice.reader.CsvReaderImpl;
import core.basesyntax.fileservice.reader.FileReader;

import java.util.Collection;
import java.util.List;

public class DataServiceImpl implements BalanceProvider,
        Purchaser, ReturnHandler, Supplier {

    private FileReader fileReader = new CsvReaderImpl("input_data.csv");
    @Override
    public int getBalance(String fruit) {
        List<List<String>> recordsFromCsv = fileReader.readFile();
        return recordsFromCsv
                .stream()
                .filter(list -> list.get(0).equals("b") && list.get(1).equals(fruit.toLowerCase()))
                .mapToInt(inner -> Integer.parseInt(inner.get(2)))
                .sum();
    }

    @Override
    public void purchase(String productId, int quantity) {

    }

    @Override
    public void processReturn(String productId, int quantity) {

    }

    @Override
    public void supply(String productId, int quantity) {

    }
}
