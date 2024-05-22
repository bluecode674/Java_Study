
package testStudy;

import java.util.Scanner;
import java.util.Arrays;


abstract class Calculator2{
	
	public abstract int add(int a, int b);
	public abstract int substract(int a, int b);
	public abstract double average(int[] a); // ����� �ؾ��մϴ�. ����� �Ǽ��̱� ������
	public abstract int getMax(int[] a);
	public abstract int getMin(int[] a);
	public abstract int getMedian(int[] a);

}



public class study6 extends Calculator2{
	
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
	public double average(int[] a) { // �ڵ� �˰��� �Ǽ�
		int sum = 0;
		for(int i=0; i<5; i++) {
			sum += a[i];
		}
		return sum / 5;
	}
	public int getMax(int[] a) { // �ڵ� �Ǽ�
		int max = 0;
		for(int i=0; i<4; i++) {
			if (a[i] < a[i+1]) {
				max = a[i+1];
			}
			else {
				max = a[i];
			}
		}
		return max;
	}
	public int getMin(int[] a) { //�ڵ� �Ǽ�
		int min = 0;
		for(int i=0; i<4; i++) {
			if (a[i] < a[i+1]) {
				min = a[i];
			}
			else {
				min = a[i+1];
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
		System.out.print("���� 5���� �Է��ϼ��� : "); //for�� �ϴ°��� ȿ����
		nums[0] = scan.nextInt();
		nums[1] = scan.nextInt();
		nums[2] = scan.nextInt();
		nums[3] = scan.nextInt();
		nums[4] = scan.nextInt();
		
		study6 gc = new study6();
		System.out.println(gc.add(nums[0], nums[1]));
		System.out.println(gc.substract(nums[0], nums[1]));
		System.out.println(gc.average(nums));
		System.out.println(gc.getMax(nums));
		System.out.println(gc.getMin(nums));
		System.out.println(gc.getMedian(nums));
	}


}

