public class Stock {
    /**
     * (E) Earnings of the company as a dollar value as a double.
     */
    private double earnings;

    /**
     * (N) The total number of shares of this stock traded on the exchange as a
     * positive integer less than 1 billion.
     */
    private long numberOfShares;

    /**
     * (D) Percentage of earnings paid as dividends as a double between 0 and 1.
     * One share will receive earnings*dividends/numberOfShares each period.
     * This will be a dollar amount as a double. Dividends paid out decrease at
     * a constant rate each turn on a per stock basis. If you sell all of a
     * stock and buy some back, the divident will be reset to full.
     */
    private double dividendRatio;

    /**
     * (I) The cost to buy one share before anybody else has, a dollar amount as
     * as a double.
     */
    private double initialPrice;

    /**
     * (S) This will be recalculated every time a trade is made. If the trade
     * price is p and number of shares traded is n, it will be recalculated as
     * (n/N)*A*p + ((N - n)/N)*A*S + (1 - A)*S
     */
    private double marketValuePerShare;

    /**
     * (V) A double between 0 and 1. Each period, a volatility v between -V and
     * V will be chosen. The earnings will be recalculated as E*(1/(1 + v)). The
     * distribution we pick V from may or may not be uniform, and it may or may
     * not be the same for different stocks. It will however always be the same
     * for the given stock. Figuring out the distribution will give you and
     * edge.
     */
    private double volatility;

    /**
     * (K) A text string of length 1-10 representing the stock.
     */
    private String ticker;

    public Stock() {
	// not necessary
    }

    public double getEarnings() {
	return earnings;
    }

    public void setEarnings(double earnings) {
	this.earnings = earnings;
    }

    public long getNumberOfShares() {
	return numberOfShares;
    }

    public void setNumberOfShares(long numberOfShares) {
	this.numberOfShares = numberOfShares;
    }

    public double getDividendRatio() {
	return dividendRatio;
    }

    public void setDividendRatio(double dividendRatio) {
	this.dividendRatio = dividendRatio;
    }

    public double getInitialPrice() {
	return initialPrice;
    }

    public void setInitialPrice(double initialPrice) {
	this.initialPrice = initialPrice;
    }

    public double getMarketValuePerShare() {
	return marketValuePerShare;
    }

    public void setMarketValuePerShare(double marketValuePerShare) {
	this.marketValuePerShare = marketValuePerShare;
    }

    public double getVolatility() {
	return volatility;
    }

    public void setVolatility(double volatility) {
	this.volatility = volatility;
    }

    public String getTicker() {
	return ticker;
    }

    public void setTicker(String ticker) {
	this.ticker = ticker;
    }
}
