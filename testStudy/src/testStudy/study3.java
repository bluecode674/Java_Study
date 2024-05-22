package testStudy;

import java.util.Scanner; //Scanner 함수를 사용하기 위해 import

public class study3 {
	public static void main(String[] args) {
		double rand = Math.random();
		int ans = (int)(rand*1000);
		int i = 0;
		
		Scanner scan = new Scanner(System.in);
		do {
			System.out.print("0~999 사이의 수를 입력사에요: ");
			int n = scan.nextInt();
			if (n == ans) {
				System.out.println("정답입니다.");
				break;
			}
			else if (n>ans) {
				System.out.println(n+"보다 작은수입니다.");
			}
			else if (n<ans) {
				System.out.println(n+"보다 큰수입니다.");
			}
			i++;
		}while(i<20);
	}
}
