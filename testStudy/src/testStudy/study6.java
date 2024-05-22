
package testStudy;

import java.util.Scanner;
import java.util.Arrays;


abstract class Calculator2{
	
	public abstract int add(int a, int b);
	public abstract int substract(int a, int b);
	public abstract double average(int[] a); // 더블로 해야합니다. 평균은 실수이기 때문에
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
	public double average(int[] a) { // 코드 알고리즘 실수
		int sum = 0;
		for(int i=0; i<5; i++) {
			sum += a[i];
		}
		return sum / 5;
	}
	public int getMax(int[] a) { // 코드 실수
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
	public int getMin(int[] a) { //코드 실수
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
		System.out.print("정수 5개를 입력하세요 : "); //for로 하는것이 효율적
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

