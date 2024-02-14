package splitwise.strategies.printer;

import java.util.Map;

public interface BalancePrinter {
    public void print(Map<String, Map<String, Float>> balanceSheet, String userId);
}
