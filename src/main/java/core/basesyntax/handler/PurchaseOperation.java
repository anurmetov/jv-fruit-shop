package core.basesyntax.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.transaction.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void process(FruitTransaction fruitTransaction) {
        canBeProcessed(fruitTransaction);
        int currentQuantity = Storage.getAll().get(fruitTransaction.getFruit());
        int shouldQuantity = currentQuantity - fruitTransaction.getQuantity();

        if (shouldQuantity < 0) {
            throw new RuntimeException("Can not be added to the storage, " +
                    "quantity can not be lower that zero: " + shouldQuantity);
        }

        Storage.put(fruitTransaction.getFruit(), shouldQuantity);
    }
}
