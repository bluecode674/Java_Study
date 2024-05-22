package testStudy;

public class study2 {
	public static void main(String[] args) {
		int n = 1;
		int sum = 0;
		while(n<=15) {
			if (n % 4 == 0) continue;
			sum += n;
			n++;
		}
		System.out.println(sum);
	}
}
