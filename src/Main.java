
public class Main {
	
	public static void main(String[] args) {
		Yahoo client = new Yahoo();
		System.out.println(client.getStockPrice("TSLA"));
		System.out.println(client.getSharesShorted("TSLA"));
		System.out.println(client.getRecommendation("TSLA"));
		
		
	}

}
