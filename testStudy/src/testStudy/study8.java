package testStudy;

import java.util.Scanner;

class TimerThread extends Thread { // Thread�� ��ӹ������ν� TimerThread�� ������� ����
	private int count = 0;
	@Override
	public void run() { // start() �޼ҵ尡 ȣ��Ǿ��� ��, JVM�� ���� ȣ��
		while (true) {
			System.out.println(++count);
			try {
				Thread.sleep(1000); // 1000ms = 1sec�� sleep
			} catch(InterruptedException ex) { return; }
		}	
	}
}


class TimerThread2 extends Thread { // Thread�� ��ӹ������ν� TimerThread�� ������� ����
	private int count = 0;
	@Override
	public void run() { // start() �޼ҵ尡 ȣ��Ǿ��� ��, JVM�� ���� ȣ��
		while (true) {
			System.out.println(++count+ "-");
			try {
				Thread.sleep(2000); // 1000ms = 1sec�� sleep
			} catch(InterruptedException ex) { return; }
		}	
	}
}

public class study8 {
	public static void main(String[] args) {
		TimerThread timer1 = new TimerThread();
		timer1.start(); // JVM�� ������ ������ �����ϵ��� ��û
		TimerThread2 timer2 = new TimerThread2();
		timer2.start(); // �� ���� �����尡 ���ÿ� ����
	}
}