package employee;

import java.util.Scanner;

public class Search_M extends Search_C implements Int_Search_M  {

	
	String emNum ;
	int choice ;
	int detail ;
	Personal_DB pdb;
	public Search_M() {
		pdb = new Personal_DB();
		emNum = null ;
		choice = 0 ;
		detail = 0 ;
	}
	
	
	@Override
	public String selectMan(Scanner sc) {
		String[] name = pdb.getName();
		String[] emn = pdb.getEmNum();
		boolean check = true;
		
		System.out.println("    사번 \t 이름");
		for(int i=0;i<name.length;i++) {

			System.out.println((i+1) + ". " + emn[i] +"\t"+name[i]);
		}
			
		System.out.println("조회할 사원의 사원번호를 입력하세요");
		emNum = sc.next();							//selectMan에 받은 사원번호가 저장됨!그번호는나중에처리하자!
		
		do {  //사번 목록에 맞게 사번을 입력했는데 확인하는 do-while문

			for(int i =0;i<emn.length;i++) {
				if(emn[i].equals(emNum)) {
					check = false;
					break;
				}
			}
			if(check){
				System.out.println("사번을 잘못입력했습니다. ");
			}
		}while(check);
		
		return emNum;
	}

	@Override
	public void choice(Scanner sc) {
		System.out.println("무엇을 조회하시겠습니까? \n 1. 전체조회, 2. 부분조회 \n");
		choice = sc.nextInt();

		switch (choice) {
		case 1:
			viewTotal(emNum);
			;
			break;
		case 2:
			System.out.println("무엇을 조회하시겠습니까? \n1. 이름\t   2. 아이디\t3. 사원번호\t4. 생년월일\t5. 성별\t\t6. 직급\t      7. 입사일\n8. 부서 \t   9. e-mail\t10.주소\t\t11. 휴대폰 번호\t12. 비밀번호\t13. 관리자 여부\n");
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
			case 12:
				viewPW(emNum);
				break;
			case 13:
				viewManage(emNum);
				break;
			default:
				System.out.println("잘못입력하셨습니다. 보기 중 해당되는 숫자를 입력해주세요.\n");
			}
			break;
		default:
			System.out.println("잘못입력하셨습니다. 보기 중 해당되는 숫자를 입력해주세요. \n");
		}

	}// end method choice

	public void viewTotal(String emNum) {
		super.viewTotal(emNum);
		viewPW(emNum);
		viewManage(emNum);
	}
	
	@Override
	public void viewPW(String emNum) {
		System.out.println("비밀번호 : " + pdb.getPW(emNum));
		
	}

	@Override
	public void viewManage(String emNum) {
		String manage = null;
		if (pdb.getManage(emNum)) {
			manage = "예";
		} else {
			manage = "아니오";
		}
		
		System.out.println("관리자 여부 : " + manage);
		
	}


}
