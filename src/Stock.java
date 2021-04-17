
public class Stock {

	private double price_of_purchase;
	private double current_price;
	private String trend;
	private String ticker_number;
	private float rsi_index;
	private String suggested_move;
	int shares;
	long stock_id;
	public Stock() {}
	
	
	public Stock(
				long stock_id,
				String ticker_number,
				double price_of_purchase,
				double current_price,
//				String trend,
//				float rsi_index,
				int shares) {
		this.ticker_number = ticker_number;
		this.price_of_purchase = price_of_purchase;
		this.current_price = current_price;
		this.trend = "UP";
		this.rsi_index = 23;
		this.shares = shares;
		this.stock_id = stock_id;
	}
	
	public String getTickerNumber() {
		return this.ticker_number;
	}
	public double getCurrentPrice() {
		return this.current_price;
	}
	public double getPriceOfPurchase() {
		return this.price_of_purchase;
	}
	public double getEarnings() {
		Double real_val = (this.current_price - this.price_of_purchase)*this.shares;
		return Math.floor(real_val* 100) / 100;
	}
	public String getSuggestedMove() {
		//TODO:Calcualted Suggested move based on RSI Index
		return this.suggested_move;
	}
	public String getTrend() {
		return this.trend;
	}
	public int getShares() {
		return this.shares;
	}
	public long getID() {
		return this.stock_id;
	}

	public double sellShares(int s){
		if(s <= this.shares){
			double profit = (this.current_price - this.price_of_purchase)*s;
			this.shares -= s;
			return profit;
		}
		return 0.0;
	}
}
