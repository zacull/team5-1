package employee;

import java.util.Scanner;

public class Select implements Int_Select {

	@Override

	public boolean selectP(Scanner sc) {


		int select;

		do {

			System.out.println("어떤 정보에 접근하시겠습니까? \n 1. 개인정보, 2. 급여정보");
			select = sc.nextInt();


			switch(select) {

			case 1 : 
				return true;
			case 2 : 
				return false;
			default : System.out.println("잘못입력하셨습니다. 보기 중 해당되는 숫자를 입력해주세요.");
			}
		}while(true);

	}
}

//		do {
//			System.out.println("어떤 정보에 접근하시겠습니까? \n 1. 개인정보, 2. 급여정보");
//			select = sc.next();
//			
//			if(!select.equals("개인정보")||!select.equals("급여정보")||!select.equals("1")||!select.equals("2")) {
//				System.out.println("잘못입력하셨습니다. 주어진 항목 중에서 선택해주세요.");
//			}
//			
//		}while(!select.equals("개인정보")||!select.equals("급여정보")||!select.equals("1")||!select.equals("2"));
//
//		//System.out.println("해당 목록 중에서 다시 입력하세요.");
//
//		if(select.equals("개인정보") || select.equals("1")) {
//			//개인정보로 보내는 메소드? 
//			Search_C sec= new Search_C();			 //Search_C의 클래스를 sec라고 내가 별명을 지음.
//			sec.choice(); 							//Search_C에 있는 choice메소드를 사용하겠다?,가겠다?
//		}else if(select.equals("급여정보") || select.equals("2")){
//			Wage_C wac = new Wage_C();
//			wac.viewTotal();
//		}

//
//		return false;
//	}
//}