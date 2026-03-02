package core.basesyntax.handler;

import core.basesyntax.db.StorageImpl;
import core.basesyntax.transaction.FruitTransaction;

public class PurchaseOperation implements OperationHandler{
    @Override
    public void process(FruitTransaction fruitTransaction) {
        int current = StorageImpl.FRUIT_STORAGE.get(fruitTransaction.getFruit());

        StorageImpl.FRUIT_STORAGE.put(fruitTransaction.getFruit(), current - fruitTransaction.getQuantity());
    }
}
