package core.basesyntax.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.transaction.FruitTransaction;

public class PurchaseOperation implements OperationHandler{
    @Override
    public void process(FruitTransaction fruitTransaction) {
        int current = Storage.FRUIT_STORAGE.get(fruitTransaction.getFruit());
        Storage.FRUIT_STORAGE.put(fruitTransaction.getFruit(), current - fruitTransaction.getQuantity());
    }
}
