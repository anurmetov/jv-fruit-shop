package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.transaction.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    @Override
    public void process(FruitTransaction fruitTransaction) {
        canBeProcessed(fruitTransaction);
        Storage.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
