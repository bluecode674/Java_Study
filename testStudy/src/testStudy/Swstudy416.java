package testStudy;

import java.util.Scanner;

interface StackInf {
	int length();
	String pop();
	boolean push(String word);
}

class StringStack implements StackInf {
	String stack[] = new String[5];
	int count = 0;
	
	public int length() {
		return count;
	}
	public String pop() {
		return stack[--count]; //stack[4] stack[3] stack[2] stack[1] stack[0]
	}
	public boolean push(String word){
		if(count<5) {
			stack[count]=word;
			count++;
			return true;
		}
		else {
			return false;
			
		}
	}
}


public class Swstudy416{
	public static void main(String[] args) {
		StringStack Ststack = new StringStack();
		Scanner scan = new Scanner(System.in);
		System.out.println("5개의 단어를 입력하세요: ");
		for (int i=0;i<5;i++) {
			Ststack.push(scan.next());
		}
		for (int i=0;i<5;i++) {
			System.out.print(Ststack.pop()+" ");
		}
	}
}


