package action;

import Interface.Action;
import character.Character;

public class guard implements Action{
	String name="���";
	@Override
	public void Action(Character ch, Character ch2) {
		if(ch2.getChraction().toString().equals("����")) {
			System.out.println(ch.name+"(��)�� �� �����ߴ�!");
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
