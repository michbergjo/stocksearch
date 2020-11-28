package stocks;

/******************************
 * 
 * Student Name: Michelle Joseph Student ID: 3437300 Semester: Summer 2020
 * 
 * COSC-1436 El Centro College Professor Keith 2019
 * 
 * Class to report high and low Stock prices.
 * 
 *******************************/

public class StockSearch {

	public static void main(String[] args) {
		StockPrices myStockPrices = new StockPrices();

		myStockPrices.getLowestStockPrice();
		myStockPrices.getHighestStockPrice();
		myStockPrices.largestPriceGain();

	}

}