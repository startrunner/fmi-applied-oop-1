package problem01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StockTest {
    @Test
    void properConstructor() {
        var stock = new Stock("Pesho", "Gosho");
        Assertions.assertAll(
            () -> Assertions.assertEquals(stock.getSymbol(), "Pesho"),
            () -> Assertions.assertEquals(stock.getName(), "Gosho")
        );
    }

    @Test
    void properGetters() {
        var stock = new Stock("_", "_");
        stock.setCurrentPrice(10);
        stock.setPreviousClosingPrice(5);
        Assertions.assertAll(
            () -> Assertions.assertEquals(stock.getCurrentPrice(), 10),
            () -> Assertions.assertEquals(stock.getPreviousClosingPrice(), 5)
        );
    }

    @Test
    void properPercentage() {
        var stock = new Stock("a", "b");
        stock.setPreviousClosingPrice(5);
        stock.setCurrentPrice(10);
        Assertions.assertEquals(stock.changePercent(), 100);
    }
}
