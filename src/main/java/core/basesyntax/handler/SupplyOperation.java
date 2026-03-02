package core.basesyntax.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.transaction.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    @Override
    public void process(FruitTransaction fruitTransaction) {
        canBeProcessed(fruitTransaction);
        int currentQuantity = Storage.getAll().get(fruitTransaction.getFruit());
        int shouldQuantity = currentQuantity + fruitTransaction.getQuantity();
        Storage.put(fruitTransaction.getFruit(), shouldQuantity);
    }
}
