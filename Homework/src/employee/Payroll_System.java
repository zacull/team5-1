package employee;

import java.util.Scanner;

public class Payroll_System {
	
	String emNum;
	
	public Payroll_System() {
		emNum = null;
	}

	boolean start(Scanner sc) {
		Login login = new Login();
		boolean yes = false; // 로그인 성공 여부
		boolean manage = false; // 관리자 여부
		String id = null;
		String pw = null;
		
		System.out.println("안녕하세요. 반갑습니다.");
		
		do {
			id = login.inputId(sc);
			pw = login.inputPW(sc);
			yes = login.check(id, pw);
			if(!yes) {
				System.out.println("패스워드 또는 아이디가 틀렸습니다.");
			}
		} while (!yes);
		
		manage = login.checkManage(id);
		
		Personal_DB pdb = new Personal_DB();
		
		emNum = pdb.getEmNum(id);
		
		return manage;
	}
	
	boolean select(Scanner sc) {
		Select gaein = new Select();
		return gaein.selectP(sc);
	}
	
	void end(boolean manage, Scanner sc) {
		
		boolean sel = false;
		
		if (manage) { // 관리자 일 경우 실행하는 영역
			System.out.println("사원을 삭제 또는 생성을 하시겠습니까?\n(Yes : y, No : n)");
			if(sc.next().toLowerCase().equals("y")) {
				Create_Employee ce = new Create_Employee();
				
				System.out.println("어떤 작업을 하시겠습니까?(번호를 입력)\n1. 삭제\t2. 생성");
				if(sc.nextInt() == 1) {
					ce.delete(sc);
				}else {
					ce.create(sc);
				}
				
				return;
			}
			
			sel = select(sc); // 개인정보, 급여정보 접근 결정
			
			if (sel) { // 개인정보일 경우 영역
				Search_M scm = new Search_M();
				scm.selectMan(sc);
				scm.choice(sc);
			} else { // 급여정보일 경우 영역
				Wage_M wm = new Wage_M();
				wm.choice(sc);
				
			}
		} else { // 일반 사용자일 경우 실행하는 영역
			
			sel = select(sc); // 개인정보, 급여정보 접근 결정
			
			if (sel) { // 개인정보일 경우 영역
				Search_C scc = new Search_C();
				scc.choice(sc, emNum);
			} else { // 급여정보일 경우 영역
				Wage_C wc = new Wage_C();
				wc.viewTotal(emNum);
			}
		}
	}
	

	public static void main(String[] args) {
		boolean manage = false; // 관리자 여부
		boolean repeat = false; // 다시 반복에 대한 값
		
		Scanner sc = new Scanner(System.in);
		Payroll_System ps = new Payroll_System();
		
		// 로그인 
				manage = ps.start(sc);
		
		do {
			//실제 수정및 조회
			ps.end(manage, sc);
			
			System.out.println("다시 이용하시겠습니까?\n(Yes : y, No : n)");
			repeat = sc.next().toLowerCase().equals("y"); 
			// yes면 true로 개인 정보를 볼지 부터 묻는다. 
			
		} while (repeat);
		
		System.out.println("이용해 주셔서 감사합니다.");

		
	}// end method main

}// end class Payroll_System
