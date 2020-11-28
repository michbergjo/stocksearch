package stocks;

//
/******************************
	Student Name: Michelle Joseph
	Student ID: 3437300
	Semester: Summer 2020

	COSC-1436
	El Centro College
	Professor Keith

	Topic:Arrays of Objects
	*******************************/

import java.util.concurrent.ThreadLocalRandom;

public class StockPrices {

	static final int MAX_STOCK_COUNT = 24;
	static final int MIN_STOCK_PRICE = 10;
	static final int MAX_STOCK_PRICE = 100;

	// Create the array of Stock Objects
	Stock[] myStocks = new Stock[MAX_STOCK_COUNT];

	/**
	 * This constructor will load the values of the stock array. Nothing to change
	 * here.
	 */

	public StockPrices() {
		char startChar = 'A';
		String tmpSymbol = null;
		int startPrice = 0;
		int priceRightNow = 0;

		for (int idx = 0; idx < MAX_STOCK_COUNT; ++idx) {
			// Generate stock symbol for testing
			tmpSymbol = "" + (char) (startChar + idx) + (char) (startChar + idx + 1) + (char) (startChar + idx + 2);
			// Generate random data for pricing
			startPrice = ThreadLocalRandom.current().nextInt(MIN_STOCK_PRICE, MAX_STOCK_PRICE + 1);
			priceRightNow = ThreadLocalRandom.current().nextInt(MIN_STOCK_PRICE, MAX_STOCK_PRICE + 1);
			myStocks[idx] = new Stock(tmpSymbol, startPrice, priceRightNow);
			System.out.println(myStocks[idx]);
		}
	}

	public void demoMethod() {
		System.out.println("You can call this method if you want");
		System.out.println("First Stock price = " + myStocks[0].getCurrentPrice());
	}

	/**
	 * This method retrieves the stock with the lowest value for the day
	 */
	public void getLowestStockPrice() {
		String tmpSymbol = null;
		int lowestStockPrice = MAX_STOCK_PRICE;

		for (int idx = 0; idx < MAX_STOCK_COUNT; ++idx) {
			if (myStocks[idx].getCurrentPrice() < lowestStockPrice) {
				lowestStockPrice = myStocks[idx].getCurrentPrice();
				tmpSymbol = myStocks[idx].getStockSymbol();
			}

		}
		System.out.printf("The current lowest stock price is %s at %d \n", tmpSymbol, lowestStockPrice);
	}

	/**
	 * This method retrieves the stock with the highest value for the day
	 */
	public void getHighestStockPrice() {
		String tmpSymbol = null;
		int highestStockPrice = MIN_STOCK_PRICE;

		for (int idx = 0; idx < MAX_STOCK_COUNT; ++idx) {
			if (myStocks[idx].getCurrentPrice() > highestStockPrice) {
				highestStockPrice = myStocks[idx].getCurrentPrice();
				tmpSymbol = myStocks[idx].getStockSymbol();
			}

		}
		System.out.printf("The current highest stock price is %s at %d \n", tmpSymbol, highestStockPrice);
	}

	/**
	 * This method retrieves the stock with the largest increase for the day
	 */
	public void largestPriceGain() {
		String tmpSymbol = null;
		int priceDifference = 0;
		int largestPriceDifference = 0;

		for (int idx = 0; idx < MAX_STOCK_COUNT; ++idx) {
			priceDifference = myStocks[idx].getCurrentPrice() - myStocks[idx].getOpeningPrice();
			if (priceDifference > largestPriceDifference) {
				largestPriceDifference = priceDifference;
				tmpSymbol = myStocks[idx].getStockSymbol();
			}
		}
		System.out.printf("The stock %s had the largest price increase today at %d \n", tmpSymbol,
				largestPriceDifference);
	}

}
