package ju15.simplegame.bean;

public class Troll extends Monster {

	public Troll() {
		super(100,50,(int)(1+Math.floor(24*Math.random())));
	}
	
	public int getDamage() {
		return (int)(1+Math.floor(24*Math.random()));
	}


}
