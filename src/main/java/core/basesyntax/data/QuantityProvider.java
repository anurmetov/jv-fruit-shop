package core.basesyntax.data;

import core.basesyntax.Operation;

public interface QuantityProvider {
    int getQuantity(String fruit, Operation operation);
}
