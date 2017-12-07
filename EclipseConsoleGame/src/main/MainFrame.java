package main;

import java.util.Scanner;

import Interface.Action;
import action.attack;
import action.escape;
import action.guard;
import action.move;
import character.Character;
import character.EsangHeaSea;
import character.Fairi;
import character.Ggobuggi;
import character.Pikachu;

public class MainFrame {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Character Character[] = {new Pikachu(), new Fairi(), new Ggobuggi(), new EsangHeaSea()};
		Action action[] = {new attack(), new guard(), new escape(), new move()};
		Character enemy[] = new Character[3];
		Character mainCh = new Character();
		
		int map_end=100;
		
		System.out.println("파트너 포켓몬을 선택해주세요.\n");
		for (int i = 0; i < Character.length; i++) {
			System.out.print((i + 1) + ". " + Character[i].name + "  "); ///
		}
		clearConsole(11);													// ------- 선택 가능 캐릭터 출력
		System.out.print(":");
		
		boolean select = true;
		while (select) {
			String chSelect = scanner.next();
			for (int i = 0; i < Character.length; i++) {
				if (chSelect.equals(Character[i].name) || chSelect.equals(i + 1 + "")) {
					mainCh = Character[i];
					mainCh.setHp(mainCh.getHp()*10);
					select = false;
				}else {
					int a=i;
					if(!select) a=i-1;
					enemy[a]=Character[i];
				}
			}if (select) System.out.println("다시 입력하시오");
		} 																			// ------- while 캐릭터 선택

		System.out.println("포켓몬 '" + mainCh.name + "'와 파트너가 되었습니다.");
		for (int i = 0; i < enemy.length; i++) {
			System.out.print("'"+enemy[i].name + "'");
		}
		System.out.println("가 적이 되었습니다.");										// ------- 선택 캐릭터 제외하고 적 생성

		for (int i = 0; i < enemy.length; i++) {
			enemy[i].setX_position(i*map_end/enemy.length+(int)(Math.random()*map_end/enemy.length));
		}																			// ------- 적 위치 랜덤 배치
		
		boolean moving = (mainCh.getX_position() <= map_end);
		while (moving) {
			try {
				Thread.sleep(100);
				clearConsole(10);
				mainCh.setChraction(mainCh,action[3]);
				mainCh.actionPerfom();												// ------- 캐릭터 이동
				for (int i = 0; i < map_end; i++) {
					if(mainCh.getX_position()==i) System.out.print("*");
					else if(enemy[0].getX_position()==i) System.out.print("a");
					else if(enemy[1].getX_position()==i) System.out.print("b");
					else if(enemy[2].getX_position()==i) System.out.print("c");
					else System.out.print("-");
				}
				System.out.println();												// ------- 맵 출력
				status(mainCh);	        										    // ------- 캐릭터 정보 출력
				for (int i = 0; i < enemy.length; i++) {
					if (mainCh.getX_position() == enemy[i].getX_position()) {
			            System.out.println("야생의 "+enemy[i].name+"와 마주하셨습니다. 싸우시겠습니까?");
			            status(enemy[i]);
			            System.out.println("1.싸운다 /  2.지나친다");
			            String meet = scanner.next();
						boolean fighting;											// ------- 전투 상황 결정
						if (meet.equals("싸운다")||meet.equals("1")) {
							fighting=true;
							System.out.println("\n결투를 시작합니다.\n");
						} else {
							fighting=false;
							System.out.println("\n적을 지나쳤습니다.\n");
						}
						while(fighting) {											// ------- 전투 상황
							if(mainCh.getX_position() != enemy[i].getX_position()) break;
							System.out.println(mainCh.name+"의 HP:"+mainCh.getHp()+" / "+enemy[i].name+"의 HP:"+enemy[i].getHp());
							for (int j = 0; j < action.length-1; j++) {				// ------- action 선택지 출력
								System.out.print((j+1)+"."+action[j]+"  ");
							}
							clearConsole(9);
							String fight = scanner.next();							// ------- character action 사용자 지정
							int enemychoice=(int)(Math.random()*(action.length-1)); // ------- enemy action 랜덤 생성
							
							for (int k = 0; k < enemy.length; k++) {				// ------- 전투 결과 출력
								if(enemy[i].getHp()<0) {
									System.err.println(enemy[i].name+"가 쓰러졌다!");
									fighting=false;
									enemy[i]=new Character();
									scanner.next();
									break;
								}
								else if(mainCh.getHp()<0) {
									System.err.println(mainCh.name+"가 쓰러졌다!");
									System.err.println("GameOver_SadEnding");
									mainCh=new Character();
									fighting=false;
									scanner.next();
									break;
								}
								else if (fight.equals(action[k].toString())||fight.equals((k+1)+"")) {
									mainCh.setChraction(enemy[i],action[k]);
									enemy[i].setChraction(mainCh,action[enemychoice]);
									System.out.print(mainCh.name + "가 "+action[k]+"!  /  ");
									System.out.println(enemy[i].name + "가 "+action[enemychoice]+"!\n");
									mainCh.actionPerfom();
									enemy[i].actionPerfom();
									clearConsole(8);
									Thread.sleep(1000);
								}
							}
						}
					}
				}
				if (mainCh.getX_position() == map_end) {
					System.err.println("GameOver_HappyEnding");
					moving = false;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void status(Character ch) {
        System.out.println(" =========================== \n"
           		+ "[ " +ch.name + " ]의 정보 \n"
           		+"Hp : " + ch.getHp() + " / Demage : " + ch.getDemage()
           		+"\n =========================== ");
	}

	public static void clearConsole(int num) {
		for (int i = 0; i < num; i++) {
			System.out.println();
		}
	}
}