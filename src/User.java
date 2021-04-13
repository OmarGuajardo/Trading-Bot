
public class User {

	private long user_id;
	private String first_name;
	private String last_name;
	private String password;
	private String email;
	
	public User(long user_id, String first_name, String last_name, String password , String email) {
		this.user_id = user_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.password = password;
		this.email = email;
	}
	
	public boolean checkCredentials(String email, String password) {
		return (this.email == email && this.password == password);
	}
	
	public String getFirstName() {
		return this.first_name;
	}
	public String getLastName() {
		return this.last_name;
	}
	public String getEmail() {
		return this.email;
	}
	public long getUserId() {
		return this.user_id;
	}

	public String getPassword() {
		return this.password;
	}
}
