package core.basesyntax;

import core.basesyntax.data.Converter;
import core.basesyntax.data.DataConverterImpl;
import core.basesyntax.fileservice.FileReader;
import core.basesyntax.fileservice.FileWriter;
import core.basesyntax.fileservice.ReportGenerator;
import core.basesyntax.fileservice.impl.CsvReaderImpl;
import core.basesyntax.fileservice.impl.CsvWriterImpl;
import core.basesyntax.fileservice.impl.ReportGeneratorImpl;
import core.basesyntax.handler.BalanceOperation;
import core.basesyntax.handler.OperationHandler;
import core.basesyntax.handler.PurchaseOperation;
import core.basesyntax.handler.ReturnOperation;
import core.basesyntax.handler.SupplyOperation;
import core.basesyntax.shop.ShopService;
import core.basesyntax.shop.ShopServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.transaction.FruitTransaction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static void main(String[] args) {
        FileReader fileReader = new CsvReaderImpl();
        List<String> inputReport = fileReader.readFile("src/main/resources/input_data.csv");

        Converter dataConverter = new DataConverterImpl();
        final List<FruitTransaction> transactions =
                dataConverter.convertToTransaction(inputReport);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport();

        FileWriter fileWriter = new CsvWriterImpl();
        fileWriter.writeTo(resultingReport, "src/main/resources/finalReport.csv");

    }
}
