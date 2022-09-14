package hoyitt.calendar;

import java.util.Scanner;

public class Sum {
	public static void main(String[] args) {
		//입력 : 키보드로 두 수의 입력을 받는다.
		Scanner scanner = new Scanner(System.in);
		System.out.println("두 숫자를 입력하세요");
		
		int first = scanner.nextInt();
		int second = scanner.nextInt();
		
		//출력 : 화면에 두 수의 합을 출력한다.
		//System.out.println("합은 " + (first + second) + " 입니다.");
		System.out.printf("%d와 %d의 합은 %d입니다.", first, second, first + second);
		
		scanner.close();
	}
}
