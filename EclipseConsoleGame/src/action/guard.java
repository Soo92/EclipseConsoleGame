package action;

import Interface.Action;
import character.Character;

public class guard implements Action{
	String name="방어";
	@Override
	public void Action(Character ch, Character ch2) {
		if(ch2.getChraction().toString().equals("공격")) {
			System.out.println(ch.name+"(이)가 방어에 성공했다!");
			ch2.setChraction(ch2, new Action() {
				@Override
				public void Action(Character ch, Character ch2) {
				}
			});
		}
	}
	@Override
	public String toString() {
		return name;
	}
}
