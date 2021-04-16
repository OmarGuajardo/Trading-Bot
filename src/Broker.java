import java.sql.SQLException;

public class Broker {

    private Portfolio p;
    private User u;

    public Broker(User u, Portfolio p ){
        this.p = p;
        this.u = u;
    }

    public void depositMoney(double money) throws SQLException {
        //TODO: User needs to have an option to increase money
        this.u.changeMoney(money);
        Database.changeMoney(this.u,this.u.getMoney());
    }

    public boolean buyStock(Stock s){
        boolean canBuyStock = true;
        //TODO: Add Stock to portfolio
        //TODO: Withdraw money from User's 'bank'
        //TODO: If user doesn't have enough money return false
        return canBuyStock;
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
