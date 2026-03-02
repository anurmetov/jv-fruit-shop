package core.basesyntax.handler;

import core.basesyntax.db.StorageImpl;
import core.basesyntax.transaction.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    @Override
    public void process(FruitTransaction fruitTransaction) {
        StorageImpl.FRUIT_STORAGE.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
