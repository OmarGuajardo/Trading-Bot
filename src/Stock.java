
public class Stock {

	private double price_of_purchase;
	private double current_price;
	private String trend;
	private String ticker_number;
	private float rsi_index;
	private String suggested_move;
	
	public Stock() {}
	public Stock(String ticker_number,
				 double price_of_purchase,
				 double current_price,
				 String trend,
				 float rsi_index
				 ) {
		this.ticker_number = ticker_number;
		this.price_of_purchase = price_of_purchase;
		this.current_price = current_price;
		this.trend = trend;
		this.rsi_index = rsi_index;
	}
	
	public String getTickerNumber() {
		return this.ticker_number;
	}
	public double getEarnings() {
		return (current_price - price_of_purchase);
	}
	public String getSuggestedMove() {
		//TODO:Calcualted Suggested move based on RSI Index
		return this.suggested_move;
	}
	public String getTrend() {
		return this.trend;
	}
}
