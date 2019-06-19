package employee;

import java.util.Scanner;

public interface Int_Re_M extends Int_Re_C {
	
	/*
	 * 속성들의 목록을 보여주며 어떤것을  수정할 것인지 묻는다.
	 */
	
	void choice(Scanner sc, String emNum); // 전체, 부분 묻기

		void changeName(String emNum, Scanner sc);
		void changeEmNum(String emNum, Scanner sc);
		void changeSatD(String emNum, Scanner sc);
		void changeLevel(String emNum, Scanner sc);
		void changeGroup(String emNum, Scanner sc);
		void changeId(String emNum, Scanner sc);
		void changeManage(String emNum, Scanner sc);
}
