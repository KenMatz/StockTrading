public class APICommands {

    public APICommands() {
	// not necessary

	// OFFERS <ticker> = will list all offers on the exchange for a ticker
	// BID <ticker> <price> <shares> = place a new bid
	// ASK <ticker> <price> <shares> = place a new ask
	// CLEAR_BID <ticker> = clear your bid
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

    public String getListAllOffersOnTheExchangeForATicker(int ticker) {
	return "OFFERS " + ticker;
    }

}
