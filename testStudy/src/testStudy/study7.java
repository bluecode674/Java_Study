package testStudy;

import java.util.Scanner;

public class study7 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String a = "a";
		System.out.println((char)70);
		int x = scan.nextInt();
		int y = scan.nextInt();
		
		if (50<x && x<100 && 50<y && y<100){
			System.out.println("("+x+","+y+")�� �簢�� ���� �ֽ��ϴ�. ");
		}
		else {
			System.out.println("�簢�� ���� ���� �ʽ��ϴ�. ");
		}
			
		scan.close();
	}	
}
