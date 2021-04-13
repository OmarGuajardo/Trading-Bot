import java.sql.SQLException;
import java.util.ArrayList;

public class Members {
	
	ArrayList<User> users = new ArrayList<User>();
	User curr_user;
	
	
	public Members(ArrayList<User> users) {
		this.users = users;
		this.curr_user = null;
	}
	
	
	
	public void showUsers() {
		System.out.println(" ");
		System.out.printf("%-15s %-12s %-12s %-12s\n",
				"User ID","First Name","Last Name","Email");
		for(User s : this.users) {
			System.out.printf("%-15s %-12s %-12s %-12s \n",
					s.getUserId(),
					s.getFirstName(),
					s.getLastName(),
					s.getEmail()
					);
		}
		
		System.out.println(" ");
	}
	
	
	public void logInUser(String email, String password) {
		for(User u : this.users) {
			//TODO:Look for an user that has a matching
			//email and password and set this.curr_user 
			//equal to that
		}
	}
	
	//Adds User to the users ArrayList
	public void addUser(User u) throws SQLException {
		this.users.add(u);
		Database.addUserDB(u);
		//TODO: Add the user in the database as well
	}
	
	//Will set curr_user equal to null
	//and will help us identify if someone
	//is logged in or not
	public void logOutUser() {
		this.curr_user = null;
	}
	
	//Returns current user logged in
	public User getCurrentUser() {
		return this.curr_user;
	}
	
	

}
