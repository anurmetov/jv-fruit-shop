package core.basesyntax.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.transaction.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    @Override
    public void process(FruitTransaction fruitTransaction) {
        Storage.FRUIT_STORAGE.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
