package testStudy;

import java.util.Scanner;

public class study1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("(x, y) 좌료를 입력하세요");
		int x = scan.nextInt();
		int y = scan.nextInt();
		
		if (50<x && x<100 && 50<y && y<100){
			System.out.println("("+x+","+y+")는 사각형 내에 있습니다. ");
		}
		else {
			System.out.println("사각형 내에 있지 않습니다. ");
		}
			
		scan.close();
	}	
}
