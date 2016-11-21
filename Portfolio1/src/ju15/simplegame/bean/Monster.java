package ju15.simplegame.bean;

import java.io.Serializable;

public abstract class Monster implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int hp;
    int exp;
    int damage;
    
    public Monster(){}
    
    public Monster(int hp, int exp, int damage) {
		super();
		this.hp = hp;
		this.exp = exp;
		this.damage = damage;
	}
    
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
    public void attack(Monster m){
    	m.setHp(m.getHp()-this.getDamage());
    }
}
