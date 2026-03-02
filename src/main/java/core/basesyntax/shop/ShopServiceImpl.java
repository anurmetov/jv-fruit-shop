package core.basesyntax.shop;

import core.basesyntax.handler.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.transaction.FruitTransaction;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        if (transactions.isEmpty()) {
            throw new RuntimeException("Transaction list is empty: " + transactions);
        }
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = operationStrategy.getHandler(transaction.getOperation());
            handler.process(transaction);
        }
    }
}
