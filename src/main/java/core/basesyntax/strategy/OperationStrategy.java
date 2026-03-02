package core.basesyntax.strategy;

import core.basesyntax.transaction.FruitTransaction;

public interface OperationStrategy {
    OperationHandler getHandler(FruitTransaction.Operation operation);
}
