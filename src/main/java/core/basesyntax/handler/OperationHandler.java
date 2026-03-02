package core.basesyntax.handler;

import core.basesyntax.transaction.FruitTransaction;

public interface OperationHandler {
    void process(FruitTransaction fruitTransaction);

    default boolean canBeProcessed(FruitTransaction fruitTransaction) {

        if (fruitTransaction.getFruit().isEmpty()) {
            throw new RuntimeException("Fruit name is null: " + fruitTransaction.getFruit());
        }

        if (fruitTransaction.getQuantity() < 0) {
            throw new
                    RuntimeException("Fruit quantity is lower than zero: "
                    + fruitTransaction.getQuantity());

        }
        return true;
    }
}
