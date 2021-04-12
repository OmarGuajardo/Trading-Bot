import java.util.ArrayList;

public class Portfolio {

	private int max_stocks = 100;
	private int current_index = 0;
	private ArrayList<Stock> stocks = new ArrayList<Stock>();

	
	public Portfolio(ArrayList<Stock> stocks) {
		current_index = stocks.size();
		this.stocks = stocks;
	}
	
	
	public void showPortofolio() {
		System.out.println(" ");
		System.out.printf("%-11s %-9s %-9s %-9s %-9s %-9s %-11s %-9s %-9s\n",
				"Ticker","Shares","Bought","Current Price","Earnings");
		for(Stock s : stocks) {
			if(s == null) {
				break;
			}
			System.out.printf("%-11s %-9i %-9d %-9d %-9d",
					s.getTickerNumber(),
					s.getShares(),
					s.getPriceOfPurchase(),
					s.getCurrentPrice(),
					s.getEarnings()
					);
		}
		
		System.out.println(" ");
	}
	
	//Iterates through all the stocks available
	//Total value is equal to the current price of the stock times it's number of shares
	public double getPortfolioValue() {
		double total_value = 0.0;
		for(Stock s : this.stocks) {
			 total_value = s.getCurrentPrice() * s.getShares();
		}
		return total_value;
	}
	
	//Adding a Stock
	public void addStock(Stock stock) {
		this.stocks.add(stock);
	}
	
	//Removing a Stock
	public void removeStock(Stock stock) {
		stocks.remove(stock);
		//TODO:
	}
}
