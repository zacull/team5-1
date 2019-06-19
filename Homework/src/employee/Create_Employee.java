package employee;

import java.util.Scanner;

public class Create_Employee implements Int_Create_Employee {
	private Personal_DB pdb;
	private String[] emNumList;
	private String[] nameList;
	private String[] idList;

	public Create_Employee() {
		pdb = new Personal_DB();
		emNumList = pdb.getEmNum();
		nameList = pdb.getName();
		idList = pdb.getId();
	}

	@Override
	public void create(Scanner sc) {
		String emNum = null;
		boolean logical = true;
		String id = null;
		System.out.println("생성할 사원의 사원번호를 입력해 주세요.");
		go: while (logical) {
			emNum = sc.next();

			for (String i : emNumList) {
				if (i.equals(emNum)) {
					System.out.println("동일한 사원번호가 존재합니다.\n 사원번호를 다시 입력해 주세요");
					logical = true;
					continue go;
				}
			}
			System.out.println("생성할 사원의 ID를 입력해 주세요.");
			id = sc.next();
			
			for (String i : idList) {
				if (i.equals(id)) {
					System.out.println("동일한 아이디가 존재합니다.\n ID를 다시 입력해 주세요");
					logical = true;
					id = sc.next();
				}
			}

			logical = false;
		}
		pdb.createEmNum(emNum, id);

	}

	@Override
	public void delete(Scanner sc) {
		String emNum = null;

		System.out.println("   사번\t이름");
		for (int i = 0; i < emNumList.length; i++) {
			System.out.println((i + 1) + ". " + emNumList[i] + "\t" + nameList[i]);
		}

		System.out.println("제거할 사원번호를 입력해 주세요.");
		emNum = sc.next();

		pdb.delete(emNum);

	}

}
