package se.plushogskolan;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ScriptException;
import org.springframework.test.context.junit4.SpringRunner;

import se.plushogskolan.model.Team;
import se.plushogskolan.model.User;
import se.plushogskolan.service.ServiceException;
import se.plushogskolan.service.TeamService;
import se.plushogskolan.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase 
//@TestPropertySource(locations="classpath:application-test.properties")
public class DatabaseApplicationTests {
	@Autowired
	JdbcTemplate jdbc;

	@Autowired
	UserService userService;
	@Autowired
	TeamService teamService;
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Before 
	public void setUp(){
		Team team = new Team("team 1");
		team = teamService.createTeam(team);
		for (int i = 0; i < 2; i++) {
			String firstname = "firstname"+i;
			String lastname = "lastname"+i;
			String username = "username0"+i;
			User user = new User(firstname, lastname, username,team);
			userService.createUser(user);
		}
	}
	
	@Test
	public void canAddUser(){
		User user = new User("firstname3", "lastname3", "username03",teamService.findByName("team 1"));
	    user=userService.createUser(user);
	    assertNotNull(user);	
	    
	}
	
	
	@Test 
	public void usernameShouldHasMoreThan10Char(){
		thrown.expect(ServiceException.class);
	    thrown.expectMessage("Username must be at least 10 characters long!");
		User user = new User("firstname3", "lastname3", "username3",teamService.findByName("team 1"));
	    user=userService.createUser(user);
	}
	
	@Test
	public void canFindAllUsers() {	
		assertEquals(userService.findAllUsers(0,10).size(),2);
		
	}
	
	@After
	public void clean() throws ScriptException, SQLException{
		List<User> users = userService.getAllUsers();
	    userService.deleteAll(users);
	    Team team = teamService.findByName("team 1");
	    teamService.delete(team);
	    
//		ScriptUtils.executeSqlScript(jdbc.getDataSource().getConnection(),
//	    		   new ClassPathResource("script/drop.sql"));
	}
	


}
