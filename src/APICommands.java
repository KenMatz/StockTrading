/**
 * @author Quinn Liu (quinnliu@vt.edu)
 * @version Feb 28, 2014
 */
public class APICommands {

    public APICommands() {
	// not necessary
    }

    public String getCurrentCash() {
	return "MY_CASH";
    }

    public String getAllSharesYouOwn() {
	return "MY_SECURITIES";
    }

    public String getAllCurrentOffersBIDandASKonTheExchange() {
	return "MY_OFFERS";
    }

    public String getAllSecuritiesInTheForm_ticker_netWorth_divident_volatility() {
	return "SECURITIES";
    }

    public String listAllOffersOnTheExchangeForATicker(int ticker) {
	return "OFFERS " + ticker;
    }

    public String placeNewBid(int ticker, int price, int shares) {
	return "BID " + ticker + " " + price + " " + shares;
    }

    public String placeNewAsk(int ticker, int price, int shares) {
	return "ASK " + ticker + " " + price + " " + shares;
    }

    public String clearYourBid(int ticker) {
	return "CLEAR_BID " + ticker;
    }

    public String clearYourAsk(int ticker) {
	return "CLEAR_ASK " + ticker;
    }

    /**
     * this is the only command which will cause writes socket asynchronously
     */
    public String subscribeToAnyTradesYouMakeAsWellAsAnyBidsTheMarketMayAutomaticallyWithdrawDueToLackOfFunds() {
	return "SUBSCRIBE";
    }

    public String unsubscribeFromUpdates() {
	return "UNSUBSCRIBE";
    }

    public String closeConnectionToAPI() {
	return "CLOSE_CONNECTION";
    }
}
