package hoyitt.calendar;

import java.text.ParseException;
import java.util.Scanner;

public class Prompt {
	
	public void printMenu() {
		System.out.println("+------------------+");
		System.out.println("| 1. 일정 등록");
		System.out.println("| 2. 일정 검색");
		System.out.println("| 3. 달력 보기");
		System.out.println("| h. 도움말 q. 종료");
		System.out.println("+------------------+");
	}
	
	/*
	 * 
	 * @param week 요일명
	 * @return 0 ~ 6 (0 = Sunday, 6 = Saturday)
	 * */
	public int parseDay(String week) {
		if (week.equals("SU")) return 0;
		else if(week.equals("MO")) return 1;
		else if(week.equals("TU")) return 2;
		else if(week.equals("WE")) return 3;
		else if(week.equals("TH")) return 4;
		else if(week.equals("FR")) return 5;
		else if(week.equals("SA")) return 6;
		else return 0;
	}
	
	public void runPrompt() throws ParseException {
		printMenu();
		
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		 
        while (true){
        	System.out.println("명령 (1, 2, 3, h, q)");
        	String cmd = scanner.next();
        	if (cmd.equals("1")) cmdRegister(scanner, cal);
            else if(cmd.equals("2")) cmdSearch(scanner, cal);
            else if(cmd.equals("3")) cmdCal(scanner, cal);
            else if(cmd.equals("h")) printMenu();
            else if(cmd.equals("q")) break;
        }
		
        System.out.println("Good Bye~~");
		scanner.close();
	}

	private void cmdCal(Scanner s,Calendar c) {
		int month  = 1;
        int year = 2022;
		System.out.println("년도를 입력하세요. (exit: -1)");
        System.out.print("YEAR> ");
        year = s.nextInt();
        
        System.out.println("달을 입력하세요.");
        System.out.print("MONTH> ");
        month = s.nextInt();
        
        
        if (1 > month || month > 12 ) {
        	System.out.println("잘못된 입력입니다.");
        	return;
        }
		c.printCalendar(year, month);
		
	}

	private void cmdSearch(Scanner s, Calendar c) {
		// TODO Auto-generated method stub
		System.out.println("[일정 검색]");
		System.out.println("날짜를 입력해주세요 (yyyy-MM-dd).");
		String date = s.next();
		String plan = "";
		try {
			plan = c.searchPlan(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("일정 검색 중 오류거 발생했습니다.");
		}
		System.out.println(plan);
		
	}

	private void cmdRegister(Scanner s, Calendar c) throws ParseException {
		// TODO Auto-generated method stub
		System.out.println("[새 일정 등록]");
		System.out.println("날짜를 입력해주세요 (yyyy-MM-dd).");
		String date = s.next();
		String text = "";
		System.out.println("일정을 입력해주세요.(문장의 끝에 ;를 입력해주세요.)");
		//단어를 합쳐 문장으로 저장(편법)
		while (true) {
			String word = s.next();
			text += word + " ";
			if (word.endsWith(";")) {
				break;
			}
		}

		c.registerPlan(date, text);
	}

	public static void main(String[] args) throws ParseException {
		Prompt p = new Prompt();
		p.runPrompt();
	}

}
