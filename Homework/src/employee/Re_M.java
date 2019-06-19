package employee;

import java.util.Scanner;

public class Re_M  extends Re_C implements Int_Re_M{
	
	public Re_M() {
		super();
	}
	public void choice(Scanner sc, String emNum) {
		int choiceNum;

		System.out.println("\n\n\n\t목록");
		for(int i=0;i<list.length;i++) {
			System.out.println((i+1)+". "+list[i]);
		}
		System.out.println("\n수정할 목록을 선택하세요.");
		choiceNum = sc.nextInt();
		switch(choiceNum) {
		case 1:
			System.out.println("사원번호 수정 선택\n 수정할 값을 입력하세요");
			changeEmNum(emNum,sc);
			break;
		case 2:
			System.out.println("생년월일 수정 선택\n 수정할 값을 입력하세요");
			changeBirth(emNum,sc);
			break;
		case 3:
			System.out.println("성별 수정 선택\n 수정할 값을 입력하세요");
			changeSex(emNum,sc);
			break;
		case 4:
			System.out.println("이메일 수정 선택\n 수정할 값을 입력하세요");
			changeEMail(emNum,sc);
			break;
		case 5:
			System.out.println("주소 수정 선택\n 수정할 값을 입력하세요");
			changeAddress(emNum,sc);
			break;
		case 6:
			System.out.println("휴대폰번호 수정 선택\n 수정할 값을 입력하세요");
			changePhone(emNum,sc);
			break;
		case 7:
			System.out.println("비밀번호 수정 선택\n 수정할 값을 입력하세요");
			changePW(emNum,sc);
			break;
		case 8:
			System.out.println("이름 수정 선택\n 수정할 값을 입력하세요");
			changeName(emNum,sc);
			break;
		case 9:
			System.out.println("직급 수정 선택\n 수정할 값을 입력하세요");
			changeLevel(emNum,sc);
			break;
		case 10:
			System.out.println("입사일 수정 선택\n 수정할 값을 입력하세요");
			changeSatD(emNum,sc);
			break;
		case 11:
			System.out.println("부서 수정 선택\n 수정할 값을 입력하세요");
			changeGroup(emNum,sc);
			break;
		case 12:
			System.out.println("아이디 수정 선택\n 수정할 값을 입력하세요");
			changeId(emNum,sc);
			break;
		case 13:
			System.out.println("관리자여부 수정 선택\n 수정할 값을 입력하세요");
			changeManage(emNum,sc);
			break;
		default:
			System.out.println("이상한거 넣지마세여 ㅡㅡ");

		}
	}


	@Override
	public void changeName(String emNum, Scanner sc) {
		String name;

		do{
			name = sc.next();
			System.out.println("이름을 10자 이하로 작성해주세요.");
		}while(name.length()>10);
		perDB.setName(emNum,name);
	}

	@Override
	public void changeEmNum(String emNum, Scanner sc) {
		String EmNum;
		do{
			EmNum = sc.next();
			System.out.println("사원 번호를 10자 이하로 작성해주세요.");
		}while(EmNum.length()>10);
		perDB.setEmNum(emNum,EmNum);
	}

	@Override
	public void changeSatD(String emNum, Scanner sc) {
		int staD;
		int max = 1000000000;
		do{
			staD = sc.nextInt();
			System.out.println("입사일을 다시 작성해주세요.");
		}while(staD>max);
		perDB.setStaD(emNum,staD);
	}

	@Override
	public void changeLevel(String emNum, Scanner sc) {
		String name;

		do{
			name = sc.next();
			System.out.println("직책을 40자 이하로 작성해주세요.");
		}while(name.length()>40);
		perDB.setLevel(emNum,name);
	}

	@Override
	public void changeGroup(String emNum, Scanner sc) {
		String group;

		do{
			group = sc.next();
			System.out.println("부서명을 40자 이하로 작성해주세요.");
		}while(group.length()>40);
		
		perDB.setGroup(emNum,group);
	}

	@Override
	public void changeId(String emNum, Scanner sc) {//10
		String id;

		do{
			id = sc.next();
			System.out.println("ID를 10자 이하로 작성해주세요.");
		}while(id.length()>10);
		
		perDB.setId(emNum,id);
	}

	@Override
	public void changeManage(String emNum, Scanner sc) { //1
		String manage;
		System.out.println("y. 권한부여  \nn. 권한 삭제");
		do{
			manage = sc.next();
			System.out.println("권한을 y, n로 작성해주세요.");
		}while(!manage.equals("y") || !manage.equals("n"));
		perDB.setManage(emNum,manage);
	}

}
