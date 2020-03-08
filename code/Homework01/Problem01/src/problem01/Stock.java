package problem01;

public class Stock {
    private final String symbol;
    private final String name;
    private double previousClosingPrice;
    private double currentPrice;

    public Stock(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public double getPreviousClosingPrice() {
        return previousClosingPrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setPreviousClosingPrice(double price) {
        previousClosingPrice = price;
    }

    public void setCurrentPrice(double price) {
        currentPrice = price;
    }

    public double changePercent() {
        double change = currentPrice - previousClosingPrice;
        double changePercent = change / (previousClosingPrice / 100.0);

        return changePercent;
    }
}
