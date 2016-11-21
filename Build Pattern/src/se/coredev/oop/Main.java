package se.coredev.oop;

public class Main {

	static {
		
	}
	
	{
		
	}
	public static void main(String[] args) {
		//build pattern,do not use constructor
		//User user = new User.UserBuilder("master", "secret").setRole("admin").build();
		//To understand code above better, we can use code below
		User user = User.builder("master", "secret").setRole("admin").build();
		

	}

}
