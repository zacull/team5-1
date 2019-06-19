package employee;

import java.util.Scanner;

public interface Int_Wage_M extends Int_Wage_C {
	/*
	 * 조회를 할 것인지 수정을 할 것인지 묻는다.
	 * 모든 사번,이름 목록을 보고 사람을 선택
	 * 조회면 전체 급여 정보를 출력
	 * 수정이면 급여정보 속성 목록을 보고 수정할 속성을 선택 후 수정
	 */
	
	static final String[] list = {"기본급여", "직책수당", "식대", "시간외 급여", "주민세", "고용보험"}; // 급여명세서에서 수정할 목록
	
	void choice(Scanner sc);
	String selectMan(Scanner sc);
	
	void changeBasicM(String emNum, Scanner sc);
	void changeLevelM(String emNum, Scanner sc);
	void changeEatM(String emNum, Scanner sc);
	void changeTimeM(String emNum, Scanner sc);
	void changeReTax(String emNum, Scanner sc);
	void changeEmTax(String emNum, Scanner sc);
}
