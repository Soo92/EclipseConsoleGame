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
		
		System.out.println("��Ʈ�� ���ϸ��� �������ּ���.\n");
		for (int i = 0; i < Character.length; i++) {
			System.out.print((i + 1) + ". " + Character[i].name + "  "); ///
		}
		clearConsole(11);													// ------- ���� ���� ĳ���� ���
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
			}if (select) System.out.println("�ٽ� �Է��Ͻÿ�");
		} 																			// ------- while ĳ���� ����

		System.out.println("���ϸ� '" + mainCh.name + "'�� ��Ʈ�ʰ� �Ǿ����ϴ�.");
		for (int i = 0; i < enemy.length; i++) {
			System.out.print("'"+enemy[i].name + "'");
		}
		System.out.println("�� ���� �Ǿ����ϴ�.");										// ------- ���� ĳ���� �����ϰ� �� ����

		for (int i = 0; i < enemy.length; i++) {
			enemy[i].setX_position(i*map_end/enemy.length+(int)(Math.random()*map_end/enemy.length));
		}																			// ------- �� ��ġ ���� ��ġ
		
		boolean moving = (mainCh.getX_position() <= map_end);
		while (moving) {
			try {
				Thread.sleep(100);
				clearConsole(10);
				mainCh.setChraction(mainCh,action[3]);
				mainCh.actionPerfom();												// ------- ĳ���� �̵�
				for (int i = 0; i < map_end; i++) {
					if(mainCh.getX_position()==i) System.out.print("*");
					else if(enemy[0].getX_position()==i) System.out.print("a");
					else if(enemy[1].getX_position()==i) System.out.print("b");
					else if(enemy[2].getX_position()==i) System.out.print("c");
					else System.out.print("-");
				}
				System.out.println();												// ------- �� ���
				status(mainCh);	        										    // ------- ĳ���� ���� ���
				for (int i = 0; i < enemy.length; i++) {
					if (mainCh.getX_position() == enemy[i].getX_position()) {
			            System.out.println("�߻��� "+enemy[i].name+"�� �����ϼ̽��ϴ�. �ο�ðڽ��ϱ�?");
			            status(enemy[i]);
			            System.out.println("1.�ο�� /  2.����ģ��");
			            String meet = scanner.next();
						boolean fighting;											// ------- ���� ��Ȳ ����
						if (meet.equals("�ο��")||meet.equals("1")) {
							fighting=true;
							System.out.println("\n������ �����մϴ�.\n");
						} else {
							fighting=false;
							System.out.println("\n���� �����ƽ��ϴ�.\n");
						}
						while(fighting) {											// ------- ���� ��Ȳ
							if(mainCh.getX_position() != enemy[i].getX_position()) break;
							System.out.println(mainCh.name+"�� HP:"+mainCh.getHp()+" / "+enemy[i].name+"�� HP:"+enemy[i].getHp());
							for (int j = 0; j < action.length-1; j++) {				// ------- action ������ ���
								System.out.print((j+1)+"."+action[j]+"  ");
							}
							clearConsole(9);
							String fight = scanner.next();							// ------- character action ����� ����
							int enemychoice=(int)(Math.random()*(action.length-1)); // ------- enemy action ���� ����
							
							for (int k = 0; k < enemy.length; k++) {				// ------- ���� ��� ���
								if(enemy[i].getHp()<0) {
									System.err.println(enemy[i].name+"�� ��������!");
									fighting=false;
									enemy[i]=new Character();
									scanner.next();
									break;
								}
								else if(mainCh.getHp()<0) {
									System.err.println(mainCh.name+"�� ��������!");
									System.err.println("GameOver_SadEnding");
									mainCh=new Character();
									fighting=false;
									scanner.next();
									break;
								}
								else if (fight.equals(action[k].toString())||fight.equals((k+1)+"")) {
									mainCh.setChraction(enemy[i],action[k]);
									enemy[i].setChraction(mainCh,action[enemychoice]);
									System.out.print(mainCh.name + "�� "+action[k]+"!  /  ");
									System.out.println(enemy[i].name + "�� "+action[enemychoice]+"!\n");
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
           		+ "[ " +ch.name + " ]�� ���� \n"
           		+"Hp : " + ch.getHp() + " / Demage : " + ch.getDemage()
           		+"\n =========================== ");
	}

	public static void clearConsole(int num) {
		for (int i = 0; i < num; i++) {
			System.out.println();
		}
	}
}