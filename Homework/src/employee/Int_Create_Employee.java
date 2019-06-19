package employee;

import java.util.Scanner;

public interface Int_Create_Employee {
	// 생성과 제거를 담당
	
	void create(Scanner sc); // 사번만 가지는 사람을 생성
	void delete(Scanner sc); // 사번을 조회하여 그사람 제거
}
