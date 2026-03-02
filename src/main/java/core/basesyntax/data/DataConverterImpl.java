package core.basesyntax.data;

import core.basesyntax.transaction.FruitTransaction;

import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements Converter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 3; i < inputReport.size(); i += 3) {
            String type = inputReport.get(i);
            String fruit = inputReport.get(i + 1);
            int quantity = Integer.parseInt(inputReport.get(i + 2));

            transactions.add(new FruitTransaction(
                    FruitTransaction.Operation.fromCode(type),
                    fruit,
                    quantity
            ));
        }
        return transactions;
    }
}
