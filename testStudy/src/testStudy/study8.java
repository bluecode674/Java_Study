package testStudy;

import java.util.Scanner;

class TimerThread extends Thread { // Thread를 상속받음으로써 TimerThread는 스레드로 동작
	private int count = 0;
	@Override
	public void run() { // start() 메소드가 호출되었을 때, JVM에 의해 호출
		while (true) {
			System.out.println(++count);
			try {
				Thread.sleep(1000); // 1000ms = 1sec간 sleep
			} catch(InterruptedException ex) { return; }
		}	
	}
}


class TimerThread2 extends Thread { // Thread를 상속받음으로써 TimerThread는 스레드로 동작
	private int count = 0;
	@Override
	public void run() { // start() 메소드가 호출되었을 때, JVM에 의해 호출
		while (true) {
			System.out.println(++count+ "-");
			try {
				Thread.sleep(2000); // 1000ms = 1sec간 sleep
			} catch(InterruptedException ex) { return; }
		}	
	}
}

public class study8 {
	public static void main(String[] args) {
		TimerThread timer1 = new TimerThread();
		timer1.start(); // JVM에 스레드 실행을 시작하도록 요청
		TimerThread2 timer2 = new TimerThread2();
		timer2.start(); // 두 개의 스레드가 동시에 실행
	}
}