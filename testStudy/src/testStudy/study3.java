package testStudy;

import java.util.Scanner; //Scanner �Լ��� ����ϱ� ���� import

public class study3 {
	public static void main(String[] args) {
		double rand = Math.random();
		int ans = (int)(rand*1000);
		int i = 0;
		
		Scanner scan = new Scanner(System.in);
		do {
			System.out.print("0~999 ������ ���� �Է»翡��: ");
			int n = scan.nextInt();
			if (n == ans) {
				System.out.println("�����Դϴ�.");
				break;
			}
			else if (n>ans) {
				System.out.println(n+"���� �������Դϴ�.");
			}
			else if (n<ans) {
				System.out.println(n+"���� ū���Դϴ�.");
			}
			i++;
		}while(i<20);
	}
}
