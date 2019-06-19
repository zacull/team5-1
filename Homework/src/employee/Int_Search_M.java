package employee;

import java.util.Scanner;

public interface Int_Search_M extends Int_Search_C{
	/*
	 * 사번과 이름 목록을 보고 어떤 사람의 정보를 볼 것인지 선택한다.
	 * 전체 조회를 할 것인지 부분 조회를 할 것인지 묻는다.
	 * 전체 조회면 viewTotal()을 실행하여 전체 정보를 출력
	 * 부분 조회면 속성들의 목록을 보고 속성를 선택한다.
	 * 선택한 속성의 정보를 출력
	 * */
	
	String selectMan(Scanner sc); // 선택한 사람의 사번을 반환
	
	void choice(Scanner sc);//전체, 부분 묻기
	
		//전체 조회
		void viewTotal(String emNum) ;
		
		//부분 조회
		void viewPW(String emNum);
		void viewManage(String emNum);
}
