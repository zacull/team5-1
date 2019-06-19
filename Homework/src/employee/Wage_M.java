package employee;

import java.util.Scanner;

public class Wage_M extends Wage_C implements Int_Wage_M {
	/*
	 * 조회를 할 것인지 수정을 할 것인지 묻는다. 모든 사번,이름 목록을 보고 사람을 선택 조회면 전체 급여 정보를 출력 수정이면 급여정보 속성
	 * 목록을 보고 수정할 속성을 선택 후 수정
	 */

	@Override
	public void choice(Scanner sc) {

		int choiceNum;
		String emNum;
		System.out.println("어떤 정보에 접근하시겠습니까? \n1.사원급여조회 2.사원급여수정");
		choiceNum = sc.nextInt();

		if (choiceNum == 1) {
			emNum = selectMan(sc); // 사원선택 메소드 호출
			viewTotal(emNum);
		} else if (choiceNum == 2) {

			emNum = selectMan(sc);

			System.out.println("\t목록");
			for (int i = 0; i < list.length; i++) { // 급여 목록 출력
				System.out.println((i + 1) + ". " + list[i]);
			}
			System.out.println("수정할 목록을 선택하세요.(번호를 입력)");
			choiceNum = sc.nextInt();
			switch (choiceNum) {
			case 1:
				System.out.println("기본급여 수정 선택\n 수정할 값을 입력하세요");
				changeBasicM(emNum, sc);
				break;
			case 2:
				System.out.println("직책수당 수정 선택\n 수정할 값을 입력하세요");
				changeLevelM(emNum, sc);
				break;
			case 3:
				System.out.println("식대 수정 선택\n 수정할 값을 입력하세요");
				changeEatM(emNum, sc);
				break;
			case 4:
				System.out.println("시간외 급여 수정 선택\n 수정할 값을 입력하세요");
				changeTimeM(emNum, sc);
				break;
			case 5:
				System.out.println("주민세 수정 선택\n 수정할 값을 입력하세요");
				changeReTax(emNum, sc);
				break;
			case 6:
				System.out.println("고용보험 수정 선택\n 수정할 값을 입력하세요");
				changeEmTax(emNum, sc);
				break;

			}
		}

	}

	@Override
	public String selectMan(Scanner sc) {
		String[] emnum = pdb.getEmNum();
		String[] name = pdb.getName();
		boolean check = true;
		String emNum;

		for (int i = 0; i < name.length; i++) {
			System.out.println((i + 1) + ". " + emnum[i] + "\t" + name[i]);
		}
		System.out.println("목록을 보고 사번을 입력해주세요.");

		do { // 사번 목록에 맞게 사번을 입력했는데 확인하는 do-while문
			emNum = sc.next(); // 사번 입력
			for (int i = 0; i < emnum.length; i++) {
				if (emnum[i].equals(emNum)) {
					check = false;
					break;
				}
			}

			if (check) {
				System.out.println("사번을 잘못입력했습니다.");
			}

		} while (check);
		return emNum;
	}

	@Override
	public void changeBasicM(String emNum, Scanner sc) {
		int bm;
		int max = 1000000000;
		System.out.println("기본급\t: " + wage_m.getBasicM(emNum));
		do {
			bm = sc.nextInt();

			if (bm > max) { // 반복 조건
				System.out.println("기본급을 다시 작성해주세요.");
				continue;
			}
			
			break;
		} while (true);
		wage_m.setBasicM(emNum, bm);

	}

	@Override
	public void changeLevelM(String emNum, Scanner sc) {
		int lm;
		int max = 1000000000;

		System.out.println("직책급여\t: " + wage_m.getLevelM(emNum));
		do {
			lm = sc.nextInt();

			if (lm > max) { // 반복 조건
				System.out.println("직책급여를 다시 작성해주세요.");
				continue;
			}
			
			break;
		} while (true);
		wage_m.setLevelM(emNum, lm);
	}

	@Override
	public void changeEatM(String emNum, Scanner sc) {
		int em;
		int max = 1000000000;

		System.out.println("식비\t: " + wage_m.getEatM(emNum));
		do {
			em = sc.nextInt();

			if (em > max) { // 반복 조건
				System.out.println("식비를 다시 작성해주세요.");
				continue;
			}

			break;
		} while (true);
		wage_m.setEatM(emNum, em);
	}

	@Override
	public void changeTimeM(String emNum, Scanner sc) {
		int tm;
		int max = 1000000000;

		System.out.println("시간외 급여\t: " + wage_m.getTimeM(emNum));
		do {
			tm = sc.nextInt();
			if (tm > max) { // 반복 조건
				System.out.println("시간외 급여를 다시 작성해주세요.");
				continue;
			}
			break;
		} while (true);
		wage_m.setTimeM(emNum, tm);
	}

	@Override
	public void changeReTax(String emNum, Scanner sc) {
		int rt;
		int max = 1000000000;

		System.out.println("주민세\t: " + wage_m.getReTax(emNum));
		do {
			rt = sc.nextInt();
			
			if (rt > max) { // 반복 조건
				System.out.println("주민세를 다시 작성해주세요.");
				continue;
			}
			break;
		} while (true);
		wage_m.setReTax(emNum, rt);
	}

	@Override
	public void changeEmTax(String emNum, Scanner sc) {
		int et;
		int max = 1000000000;

		System.out.println("고용보험\t: " + wage_m.getEmTax(emNum));
		do {
			et = sc.nextInt();

			if (et > max) { // 반복 조건
				System.out.println("고용보험을 다시 작성해주세요.");
				continue;
			}
			break;
		} while (true);
		wage_m.setEmTax(emNum, et);
	}
}
