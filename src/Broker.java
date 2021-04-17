import java.sql.SQLException;

public class Broker {

    private Portfolio p;
    private User u;

    public Broker(User u, Portfolio p ){
        this.p = p;
        this.u = u;
    }

    public void depositMoney(double money) throws SQLException {
        this.u.changeMoney(money);
        this.u.changeBalance(money);
        Database.changeMoney(this.u,this.u.getMoney(),this.u.getBalance());
    }

    public boolean buyStock(String ticker,int shares) throws SQLException {
        Double stockPrice = Yahoo.getStockPrice(ticker);
        if(stockPrice*shares > this.u.getBalance()){
            System.out.println("User CANNOT buy stock! ");
            return false;
        }else{

            Stock s = new Stock(
                    System.currentTimeMillis(),
                    ticker,
                    stockPrice,
                    stockPrice,
                    shares
            );
            System.out.println("User can buy stock! ");
            this.u.changeBalance(-1*stockPrice*shares);
            Database.changeMoney(this.u,this.u.getMoney(),this.u.getBalance());
            this.p.addStock(s);
            return true;
        }

        //TODO: Add Stock to portfolio
        //TODO: Withdraw money from User's balance
        //TODO: If user doesn't have enough money return false
    }
    public void sellStock(Stock s, int shares){
        //TODO: Check if stock is in User's portfolio
        //TODO: Calculate how much money they are going to get and add that do
        //TODO: User's 'bank'
        //TODO: Remove Stock amount from Portfolio
    }

    public Portfolio getPortfolio(){
        return  this.p;
    }
    public User getUser(){
        return this.u;
    }


}
