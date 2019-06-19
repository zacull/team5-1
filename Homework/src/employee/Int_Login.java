package employee;

import java.util.Scanner;

public interface Int_Login {
	/*
	 * 로그인 클래스는 아이디를 받아 아이디 글자수를 검사하여 10개보다 크면 다시 받는다.
	 * 아이디 글자수가 10보다 작으면 비번을 받고 아이디가 존재하는지 확인한다.
	 * 아이디가 존재하면 비번을 확인하고 로그인 되면 관리자인지 확인하여 다른 클래스들을 생성한다.
	 * 각 조건에서 false가 되면 처음으로 다시 돌아간다.
	*/
	//아이디 입력받고 글자수 확인 메소드
	
	
	String inputId(Scanner sc);
	String inputPW(Scanner sc);
	boolean check(String id, String pw);
	
	boolean checkManage(String id); 
	
	
	
}