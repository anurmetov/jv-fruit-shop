package core.basesyntax.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.transaction.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void process(FruitTransaction fruitTransaction) {
        if (canBeProcessed(fruitTransaction)) {
            int currentQuantity = Storage.FRUIT_STORAGE.get(fruitTransaction.getFruit());
            int shouldQuantity = currentQuantity - fruitTransaction.getQuantity();
            Storage.FRUIT_STORAGE.put(fruitTransaction.getFruit(), shouldQuantity);
        }
    }
}
