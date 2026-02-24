package core.basesyntax.data;

import core.basesyntax.Operation;
import core.basesyntax.fileservice.reader.CsvReaderImpl;
import core.basesyntax.fileservice.reader.FileReader;

import java.util.Collection;
import java.util.List;

public class DataServiceImpl implements BalanceProvider,
        Purchaser, ReturnHandler, Supplier {

    private final List<List<String>> recordsFromCsv =
            new CsvReaderImpl("input_data.csv").readFile();

    @Override
    public int getStartBalance(String fruit) {
        return recordsFromCsv
                .stream()
                .filter(list -> list.get(0).equals(Operation.BALANCE.getCode())
                        && list.get(1).equals(fruit.toLowerCase()))
                .mapToInt(inner -> Integer.parseInt(inner.get(2)))
                .sum();
    }

    @Override
    public void getPurchases(String fruit) {

    }

    @Override
    public void processReturn(String productId, int quantity) {

    }

    @Override
    public void supply(String productId, int quantity) {

    }
}
