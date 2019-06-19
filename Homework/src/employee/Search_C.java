package employee;

import java.util.Scanner;

public class Search_C implements Int_Search_C {
	Personal_DB pdb;
	
	public Search_C() {
		pdb = new Personal_DB();
	}
	
	@Override
	public void choice(Scanner sc, String emNum) {
		
		int choice;
		int detail;
		
		
		System.out.println("무엇을 조회하시겠습니까? \n 1. 전체조회, 2. 부분조회\n");
		choice = sc.nextInt();

		switch (choice) {

		case 1:
			viewTotal(emNum);
			break;
		case 2:
			System.out.println("무엇을 조회하시겠습니까? \n1. 이름\t   2. 아이디\t3. 사원번호\t4. 생년월일\t5. 성별\t\t6. 직급\n7. 입사일\t   8. 부서 \t9. e-mail\t10.주소\t\t11. 휴대폰 번호\n");
			detail = sc.nextInt();

			switch (detail) {
			case 1:
				viewName(emNum);
				break;
			case 2:
				viewId(emNum);
				break;
			case 3:
				viewEmNum(emNum);
				break;
			case 4:
				viewBirth(emNum);
				break;
			case 5:
				viewSex(emNum);
				break;
			case 6:
				viewLevel(emNum);
				break;
			case 7:
				viewStaD(emNum);
				break;
			case 8:
				viewGroup(emNum);
				break;
			case 9:
				viewEMail(emNum);
				break;
			case 10:
				viewAddress(emNum);
				break;
			case 11:
				viewPhone(emNum);
				break;
			default:
				System.out.println("잘못입력하셨습니다. 보기 중 해당되는 숫자를 입력해주세요.\n");
			}
			break;
		default:
			System.out.println("잘못입력하셨습니다. 보기 중 해당되는 숫자를 입력해주세요.\n");
		}
//		do {
//			System.out.println("무엇을 조회하시겠습니까? \n 1. 전체조회, 2. 부분조회");
//			choice = sc.next();
//
//			if(!choice.equals("전체조회")||!choice.equals("부분조회")||!choice.equals("1")||!choice.equals("2")) {
//				System.out.println("");
//			}
//		} while(!choice.equals("전체조회")||!choice.equals("부분조회")||!choice.equals("1")||!choice.equals("2"));
//
//		if(choice.equals("전체조회")||choice.equals("1")) {
//			sec.viewTotal(emNum);
//		}else if(choice.equals("부분조회")||choice.equals("2")) {
//			
//			do {
//			System.out.println("무엇을 조회하시겠습니까? \n 1. 이름, 2. 아이디, 3. 사원번호, 4. 생년월일, 5. 성별, 6. 직급, 7. 입사일, 8.부서, 9. 이메일, 10.주소, 11. 휴대폰 번호");
//			if()
//			}while();
//			
//		}
		//sec.veiwTotal(emNum);
		

	}

	@Override
		public void viewTotal(String emNum) {
			System.out.println("이름 : " + pdb.getName(emNum));
			System.out.println("아이디 : " + pdb.getId(emNum));
			System.out.println("사원번호 : " + emNum);
			System.out.println("생년월일 : " + pdb.getBirth(emNum));
			System.out.println("성별 : " + pdb.getSex(emNum));
			System.out.println("직급 : " + pdb.getLevel(emNum));
			System.out.println("입사일 : " + pdb.getStaD(emNum));
			System.out.println("부서 : " + pdb.getGroup(emNum));
			System.out.println("이메일 : " + pdb.getEMail(emNum));
			System.out.println("주소 : " + pdb.getAddress(emNum));
			System.out.println("휴대폰 번호 : " + pdb.getPhone(emNum));
		
	}

	@Override
	public void viewName(String emNum) {
		System.out.println("이름 : " + pdb.getName(emNum));

	}

	@Override
	public void viewId(String emNum) {
		System.out.println("아이디 : " + pdb.getId(emNum));

	}

	@Override
	public void viewEmNum(String emNum) {
		System.out.println("사원번호 : " + emNum);

	}

	@Override
	public void viewBirth(String emNum) {
		System.out.println("생년월일 : " + pdb.getBirth(emNum));

	}

	@Override
	public void viewSex(String emNum) {
		System.out.println("성별 : " + pdb.getSex(emNum));

	}

	@Override
	public void viewLevel(String emNum) {
		System.out.println("직급 : " + pdb.getLevel(emNum));

	}

	@Override
	public void viewStaD(String emNum) {
		System.out.println("입사일 : " + pdb.getStaD(emNum));

	}

	@Override
	public void viewGroup(String emNum) {
		System.out.println("부서 : " + pdb.getGroup(emNum));

	}

	@Override
	public void viewEMail(String emNum) {
		System.out.println("e-mail : " + pdb.getEMail(emNum));

	}

	@Override
	public void viewAddress(String emNum) {
		System.out.println("주소 : " + pdb.getAddress(emNum));

	}

	@Override
	public void viewPhone(String emNum) {
		System.out.println("휴대폰 번호 : " + pdb.getPhone(emNum));

	}

}
