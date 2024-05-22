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
		System.out.print("인원수: ");
		int num = scan.nextInt();
		phone = new Phone[num];
		
		for(i=0; i<phone.length; i++) {
			System.out.print("이름과 전화번호: ");
			String name = scan.next();
			String tel = scan.next();
			phone[i] = new Phone(name, tel);
		}
		
		System.out.println("저장되었습니다 …");
		
		while(true) {
			System.out.print("검색할 이름: ");
			String name = scan.next();
			if(name.equals("exit")) {
				System.out.println("프로그램을 종료합니다 …");
				break;
			}
			for(i=0; i<num; i++) {
				if(name.equals((phone)[i].getName())) {
					System.out.println(name + "의 번호는 " + phone[i].getTel() + "입니다.");
					break;
				}
			}
		}
		scan.close();
	}
}
