package core.basesyntax;

import core.basesyntax.data.DataServiceImpl;
import core.basesyntax.fileservice.reader.CsvReaderImpl;
import core.basesyntax.fileservice.reader.FileReader;
import core.basesyntax.fileservice.writer.FileWriter;
import core.basesyntax.transaction.FruitTransaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Feel free to remove this class and create your own.
 */
public class Test {
    public static void main(String[] args) {
        DataServiceImpl dataService = new DataServiceImpl();
        List<String> fruitNames = dataService.getAllFruitNames();


        // TODO: 1. В списка iменi фруктов до балансу (початок змiни) додати або вiдняти значення з кожного Purchase, Supply, Return та зробити
        //  мапу: fruitName -> finalQuantity Stream API

        // TODO: 2. Експортувати данi з мапи до нового CSV File, як?



    }
}
