package core.basesyntax.data;

import core.basesyntax.transaction.FruitTransaction;

import java.util.List;

public interface Convertable {
    List<FruitTransaction> convertToTransaction(List<String> inputReport);
}
