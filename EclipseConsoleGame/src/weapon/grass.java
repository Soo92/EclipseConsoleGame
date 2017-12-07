package weapon;

import Interface.Weapon;
import character.Character;

public class grass implements Weapon{

	@Override
	public void Weapon(Character ch) {
		ch.setDemage(20);
	}

}
