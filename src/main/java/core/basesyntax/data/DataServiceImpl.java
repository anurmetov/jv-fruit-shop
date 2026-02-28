package core.basesyntax.data;

import core.basesyntax.Operation;
import core.basesyntax.fileservice.reader.CsvReaderImpl;

import java.util.Collection;
import java.util.List;

public class DataServiceImpl implements QuantityProvider, FruitNamesProvider{

    private final List<String> recordsFromCsv =new CsvReaderImpl().readFile("input_data.csv");

    @Override
    public List<String> getAllFruitNames() {
        return List.of();
    }

    @Override
    public int getQuantity(String fruit, Operation operation) {
        return 0;
    }

//    @Override
//    public int getQuantity(String fruit, Operation operation) {
//        return recordsFromCsv
//                .stream()
//                .filter(list -> list.get(0).equals(operation.getCode())
//                        && list.get(1).equals(fruit.toLowerCase()))
//                .mapToInt(inner -> Integer.parseInt(inner.get(2)))
//                .sum();
//    }
//
//    @Override
//    public List<String> getAllFruitNames() {
//        return recordsFromCsv
//                .stream()
//                .skip(1)
//                .map(list -> list.get(1))
//                .distinct()
//                .toList();
//    }
}
