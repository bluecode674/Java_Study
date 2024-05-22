
// 4/16 ���丵 �ڷ� ����2 ���� 



package testStudy;

import java.util.Scanner;
import java.util.Arrays;

abstract class Calculator{
	
	public abstract int add(int a, int b);
	public abstract int substract(int a, int b);
	public abstract double average(int[] a); // ����� �ؾ��մϴ�. ����� �Ǽ��̱� ������
	public abstract int getMax(int[] a);
	public abstract int getMin(int[] a);
	public abstract int getMedian(int[] a);

}



public class study5 extends Calculator{
	
	public int add(int a, int b) { 
		return a + b; 
		}
	public int substract(int a, int b) { 
		if (a>b) {
			return a - b;
			}
		else {
			return b - a;
			}
		}
	public double average(int[] a) { //�ڵ尡 �� �� �� (�迭�� ����ؾ� �Ѵ�.)
		int sum = 0;
		for(int i=0; i<5; i++) {
			sum += a[i];
		}
		return sum / 5;
	}
	public int getMax(int[] a) { 
		int max = a[0];
		for(int i=1; i<5; i++) {
			if (max < a[i]) {
				max = a[i];
			}
		}
		return max;
	}
	public int getMin(int[] a) { 
		int min = a[0];
		for(int i=1; i<5; i++) {
			if (min > a[i]) {
				min = a[i];
			}
		}
		return min;
	}
	
	public int getMedian(int[] a) { 
		Arrays.sort(a);
		return a[2];
	}
	public static void main(String[] args) {
		
		int[] nums = new int[5];
		Scanner scan = new Scanner(System.in);
		System.out.print("���� 5���� �Է��ϼ��� : "); // for �ϴ°� ȿ����
		for (int i=0; i<5; i++) {
			nums[i] = scan.nextInt();
		}
		
		study5 gc = new study5();
		System.out.println(gc.add(nums[0], nums[1]));
		System.out.println(gc.substract(nums[0], nums[1]));
		System.out.println(gc.average(nums));
		System.out.println(gc.getMax(nums));
		System.out.println(gc.getMin(nums));
		System.out.println(gc.getMedian(nums));
	}


}
