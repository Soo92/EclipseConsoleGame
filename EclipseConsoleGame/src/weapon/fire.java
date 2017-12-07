package weapon;

import Interface.Weapon;
import character.Character;

public class fire implements Weapon{

	@Override
	public void Weapon(Character ch) {
		ch.setDemage(15);
	}

}
