package core.basesyntax.handler;

import core.basesyntax.transaction.FruitTransaction;

public interface OperationHandler {
    void process(FruitTransaction fruitTransaction);
}
