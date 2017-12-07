package action;

import Interface.Action;
import character.Character;

public class move implements Action{
	String name="¿Ãµø";
	@Override
	public void Action(Character ch, Character ch2) {
		ch.setX_position(ch.getX_position()+1);
	}
	@Override
	public String toString() {
		return name;
	}
}
