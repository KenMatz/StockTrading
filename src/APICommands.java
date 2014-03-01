public class APICommands {

    public APICommands() {
	// not necessary

	// MY_CASH = output your current cash
	// MY_SECURITIES = output all shares you own
	// MY_OFFERS = output all current offers BID & ASK on the exchange
	// SECURITIES = output all securities in the form <ticker> <net_worth>
	// <dividend> <volatility>

	// OFFERS <ticker> = will list all offers on the exchange for a ticker
	// BID <ticker> <price> <shares> = place a new bid
	// ASK <ticker> <price> <shares> = place a new ask
	// CLEAR_BID <ticker> = clear your bid
    }

    public String getCurrentCash() {
	return "MY_CASH";
    }

}
