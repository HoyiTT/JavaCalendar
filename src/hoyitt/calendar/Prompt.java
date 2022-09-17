package hoyitt.calendar;

import java.util.Scanner;

public class Prompt {
	
	private final static String PROMPT="cal> ";
	
	public void runPrompt() {

		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		
        int month  = 1;
        
        while (true){
            System.out.println("달을 입력하세요");
            System.out.print(PROMPT);
            month = scanner.nextInt();
            if (1 > month || month > 12 ) {
            	break;
            }
			cal.printCalendar(2022, month);
        }
		
        System.out.println("Bye~~");
		scanner.close();
	}

	public static void main(String[] args) {
		Prompt p = new Prompt();
		p.runPrompt();
	}

}
