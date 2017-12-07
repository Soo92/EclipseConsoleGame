package action;

import Interface.Action;
import character.Character;

public class escape implements Action{
	String name="도망";
	@Override
	public void Action(Character ch, Character ch2) {
		if(ch2.getChraction().toString().equals("도망")) {
			System.out.println(ch2.name+"(이)가 따라와서 "+ch.name+"(이)가 도망가지 못했다!");
			ch2.setChraction(ch, new Action() {
				@Override
				public void Action(Character ch, Character ch2) {
				}
			});
		}
		else if(ch.getHp()>0){
			System.out.println(ch.name+"(이)가 도망에 성공했다!");
			ch2.setX_position(ch2.getX_position()-1);
		}
	}
	@Override
	public String toString() {
		return name;
	}
}
