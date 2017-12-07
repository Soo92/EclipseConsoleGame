package character;

import Interface.Action;
import Interface.Weapon;

public class Character {
	Action chraction;
	Weapon chrweapon;
	Character ch2;

	protected int Hp;
	protected int demage;	
	protected int x_position=-1;
	
	public String name;
	
	public int getHp() {
		return this.Hp;
	}
	public void setHp(int hp) {
		this.Hp = hp;
	}
	
	public int getDemage() {
		return demage;
	}
	public void setDemage(int demage) {
		this.demage = demage;
	}
	
	public void attack(Character ch) {
		ch.setHp(ch.getHp()-demage);
	}
	
	public int getX_position() {
		return x_position;
	}
	public void setX_position(int x_position) {
		this.x_position = x_position;
	}
	
	public Action getChraction() {
		return chraction;
	}
	public Weapon getChrweapon() {
		return chrweapon;
	}

	public void setChraction(Character ch2, Action chraction) {
		this.chraction = chraction;
		this.ch2 = ch2;
	}
	public void setChrweapon(Weapon chrweapon) {
		this.chrweapon = chrweapon;
		chrweapon.Weapon(this);
	}
	public void actionPerfom() {
		chraction.Action(this,ch2);
	}
}