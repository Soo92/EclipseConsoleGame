package action;

import Interface.Action;
import character.Character;

public class attack implements Action{
	String name="공격";
	@Override
	public void Action(Character ch, Character ch2) {
		if(ch2.getChraction().toString().equals("방어")) {
			System.out.println(ch.name+"(이)가 공격에 실패했다...");
			ch.setChraction(ch, new Action() {
				@Override
				public void Action(Character ch, Character ch2) {
				}
			});
		}else {
			ch2.setHp(ch2.getHp()-ch.getDemage());
			System.out.println(ch.name+"(이)가 "+ch.getDemage()+"의 피해를 입혔다!");
		}
	}
	@Override
	public String toString() {
		return name;
	}
}
