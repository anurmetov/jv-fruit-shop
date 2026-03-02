package core.basesyntax.strategy;

import core.basesyntax.handler.OperationHandler;
import core.basesyntax.transaction.FruitTransaction;

import java.util.List;

public interface OperationStrategy {

    OperationHandler getHandler(FruitTransaction.Operation operation);
}
