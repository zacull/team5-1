package employee;

import java.util.Scanner;

public interface Int_Search_C {
	/*
	 * 전체 조회를 할 것인지 부분 조회를 할 것인지 묻는다.
	 * 전체 조회면 viewTotal()을 실행하여 전체 정보를 출력
	 * 부분 조회면 속성들의 목록을 보고 속성를 선택한다.
	 * 선택한 속성의 정보를 출력
	 * */
	
	// 속성의 목록
	static final String[] list = {"사원번호", "생년월일", "성별", "이메일", "주소", "휴대폰 번호", "이름", "직급", "입사일", "부서", "비밀번호", "아이디", "관리자 여부"};
	
	void choice(Scanner sc, String emNum); // 전체, 부분 묻기
		//다	른것 넣으면 다시
		
		// 전체 출력
		void viewTotal(String emNum); 		
		
		//부분 출력
		void viewName(String emNum);
		void viewId(String emNum);
		void viewEmNum(String emNum);
		void viewBirth(String emNum); //나이도 계산 후 출력
		void viewSex(String emNum);
		void viewLevel(String emNum);
		void viewStaD(String emNum);
		void viewGroup(String emNum);
		void viewEMail(String emNum);
		void viewAddress(String emNum);
		void viewPhone(String emNum);
		
}
