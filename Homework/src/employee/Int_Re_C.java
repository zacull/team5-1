package employee;

import java.util.Scanner;

public interface Int_Re_C {
	/*
	 * 속성들의 목록을 보여주며 어떤것을  수정할 것인지 묻는다.
	 */
	
	static final String[] list = {"사원번호", "생년월일", "성별"
			, "이메일", "주소", "휴대폰 번호", "비밀번호","이름", "직급"
			, "입사일", "부서", "아이디", "관리자 여부"};
	
	void choice(Scanner sc,String emNum); // 어떤 속성을 수정할 것인지 묻는다.
	
	void changePW(String emNum, Scanner sc);
	void changeBirth(String emNum, Scanner sc);
	void changeSex(String emNum, Scanner sc);
	void changeEMail(String emNum, Scanner sc);
	void changeAddress(String emNum, Scanner sc);
	void changePhone(String emNum, Scanner sc);
}
