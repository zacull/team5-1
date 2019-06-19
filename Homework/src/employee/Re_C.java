package employee;

import java.util.Scanner;

public class Re_C implements Int_Re_C{

	Personal_DB perDB;
	Re_C(){perDB= new Personal_DB();}
	@Override
	public void choice(Scanner sc, String emNum) {
		// TODO Auto-generated method stub
		int choiceNum;
		System.out.println("\t목록");
		for(int i=1;i<=6;i++) {
			System.out.println(i+list[i]);
		}
		System.out.println("수정할 목록을 선택하세요.");
		choiceNum = sc.nextInt();
		switch(choiceNum) {
		case 1:
			System.out.println("생년월일 수정 선택\n 수정할 값을 입력하세요");
			changeBirth(emNum,sc);
			break;
		case 2:
			System.out.println("성별 수정 선택\n 수정할 값을 입력하세요");
			changeSex(emNum,sc);
			break;
		case 3:
			System.out.println("이메일 수정 선택\n 수정할 값을 입력하세요");
			changeEMail(emNum,sc);
			break;
		case 4:
			System.out.println("주소 수정 선택\n 수정할 값을 입력하세요");
			changeAddress(emNum,sc);
			break;
		case 5:
			System.out.println("휴대폰번호 수정 선택\n 수정할 값을 입력하세요");
			changePhone(emNum,sc);
			break;
		case 6:
			System.out.println("비밀번호 수정 선택\n 수정할 값을 입력하세요");
			changePW(emNum,sc);
			break;
		
		}
	}

	@Override
	public void changePW(String emNum, Scanner sc) { //20
		String pw;

		do{
			pw = sc.next();
			System.out.println("PW를 20자 이하로 작성해주세요.");
		}while(pw.length()>20);
		
		perDB.setPW(emNum,pw);
	}

	@Override
	public void changeBirth(String emNum, Scanner sc) { //38
		int staD;
		int max = 1000000000;
		do{
			staD = sc.nextInt();
			System.out.println("입사일을 다시 작성해주세요.");
		}while(staD>max);
		perDB.setBirth(emNum,staD);		
	}

	@Override
	public void changeSex(String emNum, Scanner sc) { //1
		String sex;
		do {
		System.out.println("m : 남자  w : 여자");
		sex = sc.next();
		}while(!sex.equals("m") || !sex.equals("w"));
		perDB.setSex(emNum,sex);
	}

	@Override
	public void changeEMail(String emNum, Scanner sc) { //100
		String email = null;

		do{
			email = sc.next();
			System.out.println("EMail을 200자 이하로 작성해주세요.");
		}while(email.length()>200);
		
		perDB.setEMail(emNum,email);
	}

	@Override
	public void changeAddress(String emNum, Scanner sc) { //200
		String address;

		do{
			address = sc.next();
			System.out.println("주소를 200자 이하로 작성해주세요.");
		}while(address.length()>200);
		
		perDB.setAddress(emNum,address);
	}

	@Override
	public void changePhone(String emNum, Scanner sc) { //13
		String phone;

		do{
			phone = sc.next();
			System.out.println("EMail을 200자 이하로 작성해주세요.");
		}while(phone.length()>13);
		
		perDB.setPhone(emNum,phone);
	}


}
