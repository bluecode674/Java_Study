package testStudy;

import java.util.Scanner;

class Phone{
	private String name;
	private String tel;
	
	Phone(String n, String tel){
		name = n; this.tel = tel;
	}
	String getName() {
		return name;
		
	}
	String getTel() {
		return tel;
	}
}



public class study4 {
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		
		Phone phone[];
		int i;
		System.out.print("�ο���: ");
		int num = scan.nextInt();
		phone = new Phone[num];
		
		for(i=0; i<phone.length; i++) {
			System.out.print("�̸��� ��ȭ��ȣ: ");
			String name = scan.next();
			String tel = scan.next();
			phone[i] = new Phone(name, tel);
		}
		
		System.out.println("����Ǿ����ϴ� ��");
		
		while(true) {
			System.out.print("�˻��� �̸�: ");
			String name = scan.next();
			if(name.equals("exit")) {
				System.out.println("���α׷��� �����մϴ� ��");
				break;
			}
			for(i=0; i<num; i++) {
				if(name.equals((phone)[i].getName())) {
					System.out.println(name + "�� ��ȣ�� " + phone[i].getTel() + "�Դϴ�.");
					break;
				}
			}
		}
		scan.close();
	}
}
