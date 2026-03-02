package core.basesyntax;

import core.basesyntax.data.Convertable;
import core.basesyntax.data.DataServiceImpl;
import core.basesyntax.db.StorageImpl;
import core.basesyntax.fileservice.reader.CsvReaderImpl;
import core.basesyntax.fileservice.reader.FileReader;
import core.basesyntax.fileservice.report.ReportGenerator;
import core.basesyntax.fileservice.report.ReportGeneratorImpl;
import core.basesyntax.fileservice.writer.CsvWriterImpl;
import core.basesyntax.fileservice.writer.FileWriter;
import core.basesyntax.handler.*;
import core.basesyntax.shop.ShopService;
import core.basesyntax.shop.ShopServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
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
        // 1. Read the data from the input CSV file
        FileReader fileReader = new CsvReaderImpl();
        List<String> inputReport = fileReader.readFile("input_data.csv");

        // 2. Convert the incoming data into FruitTransactions list
        Convertable dataConverter = new DataServiceImpl();
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        // 3. Create and feel the map with all OperationHandler implementations
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);


        System.out.println(StorageImpl.FRUIT_STORAGE);

        // 5.Generate report based on the current Storage state
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport();

        System.out.println(resultingReport);

        // 6. Write the received report into the destination file
        FileWriter fileWriter = new CsvWriterImpl();
        fileWriter.writeTo(resultingReport, "finalReport.csv");



        // TODO: 1. В списка iменi фруктов до балансу (початок змiни) додати або вiдняти значення з кожного Purchase, Supply, Return та зробити
        //  мапу: fruitName -> finalQuantity Stream API

        // TODO: 2. Експортувати данi з мапи до нового CSV File, як?



    }
}
