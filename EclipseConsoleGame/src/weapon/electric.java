package weapon;

import Interface.Weapon;
import character.Character;

public class electric implements Weapon{

	@Override
	public void Weapon(Character ch) {
		ch.setDemage(10);
	}

}
