
import java.sql.SQLException;


public class Main {
	

	public static void main(String[] args) throws SQLException {
//		new Dashboard();	
		//
			Database db = new Database();
			Members m = db.fetchMembers();
			String email_entered = "omar@gmail.com";
			String password_entered = "password";
			m.logInUser(email_entered, password_entered);
			if(m.curr_user != null) {
				Portfolio user_portfolio = db.fetchPortfolio(m.curr_user);
				user_portfolio.showPortofolio();
				
			}
		//
	}

}
