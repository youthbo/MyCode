package se.coredev.oop;

public final class User {
	private final String username;  
	private final String password;
	private final String role;
	private final String firstname;
	private final String lastname;

	//no constructor for build pattern,change to private
	private User(String username, String password, String role, String firstname, String lastname) {
		this.username = username;
		this.password = password;
		this.role = role;
		this.firstname = firstname;
		this.lastname = lastname;  //must set value or null if it is final
	}
	
	public static UserBuilder builder(String username,String password){
		return new UserBuilder(username,password);
		
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}
	
    //Use build pattern for class which has a lot of variable
	//only setter
	public static final class UserBuilder{
		//required parameter
		private final String username;  
		private final String password;
		//optional parameter
		private String role;
		private String firstname;
		private String lastname;
		
		public UserBuilder(String username, String password) {
			super();
			this.username = username;
			this.password = password;
			this.role="guest";
			this.firstname="";
			this.lastname="";
		}
		public User build(){
			return new User(username,password,role,firstname,lastname);
		}
		//return class itself
		public UserBuilder setRole(String role){
			this.role=role;
			return this;
		}
		
		public UserBuilder setFirstname(String firstname){
			this.firstname=firstname;
			return this;
		}
		
		public UserBuilder setLastname(String lastname){
			this.lastname=lastname;
			return this;
		}
	}
}
