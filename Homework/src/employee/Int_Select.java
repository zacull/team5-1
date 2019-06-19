package employee;

import java.util.Scanner;

public interface Int_Select {
	/* 
	 * 급여를 확인할건지 개인정보를 확인할건지 구분해주는 클래스
	 * 
	 * 참: 개인정보
	 * 거짓: 급여정보
	 * sysout "어떤 정보에 접근하시겠습니까? \n(1. 개인정보, 2. 급여정보) "
	 * 
	 * */
	
	boolean selectP(Scanner sc); 
	
}
