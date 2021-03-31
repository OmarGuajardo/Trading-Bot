
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
	}
	
	public void addStock(Stock stock) {
		stocks[current_index] = stock;
	}
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
