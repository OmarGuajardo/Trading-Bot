
public class Portfolio {

	private int max_stocks = 100;
	private int current_index = 0;
	private Stock[] stocks = new Stock[this.max_stocks];
	
	public Portfolio(Stock[] stocks) {
		current_index = stocks.length;
		this.stocks = stocks;
	}
	
	
	public void showPortofolio() {
		//TODO:Show portfolio
//		System.out.println(" ");
//		System.out.printf("%-11s %-9s %-9s %-9s %-9s %-9s %-11s %-9s %-9s\n",
//				"Ticker","Shares","Bought","Current Price","Earnings");
//		
//		System.out.printf("%-11s %-9i %-9d %-9d %-9d",
//				s.getTickerNumber(),
//				s.getShares(),
//				s.getBought(),
//				s.getPriceOfPurchase(),
//				s.getCurrentPrice(),
//				s.getEarnings()
//				);
//		System.out.println(" ");
	}
	
	//Iterates through all the stocks available
	//Total value is equal to the current price of the stock times it's number of shares
	public double getPortfolioValue() {
		double total_value = 0.0;
		for(Stock s : this.stocks) {
			//TODO: Merge 
			// total_value = s.getCurrentPrice() * s.getShares();
		}
		return total_value;
	}
	//Adding a Stock
	public void addStock(Stock stock) {
		stocks[current_index] = stock;
	}
	
	//Removing a Stock
	public void removeStock(Stock stock) {
		int empty_index = 0;
		
		//Find the stock that we want to remove
		for(int i = 0 ; i < max_stocks; i++) {
			if(stocks[i] == stock) {
				stocks[i] = null;
				empty_index = i;
			}
		}
		
		//Shift the array to cover up the 'hole'
		for(int i = empty_index ; i < max_stocks-1; i++) {
			
			//The next item in the array will be null once the 'hole' has been covered
			//when that happens then we can just break out of the loop
			if(stocks[i+1] == null) {
				break;
			}
			stocks[i] = stocks[i+1];
			stocks[i+1] = null;
		}
		
		this.current_index -= 1;
	}
}
