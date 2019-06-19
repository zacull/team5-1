package employee;

import java.util.Scanner;

public class Login implements Int_Login{

	Personal_DB db = new Personal_DB();	
	
	@Override
	public String inputId(Scanner sc) {
		
		String idstore;


		do{
			System.out.println("ID를 입력해주세요. : ");
			idstore = sc.next();
			
			if(idstore.length()>10) {  //아이디를 입력받고 10글자보다 크면 다시입력하게끔 하는 것 
				System.out.println("ID가 10글자 이상입니다.");
			}
			
		}while(idstore.length()>10);
		
		return idstore;    //호출하는 곳으로 보내주는 것
	}

	@Override
	public String inputPW(Scanner sc) {  //비밀번호를 입력

		String pwstore;

		System.out.println("PW를 입력해주세요. : ");
		pwstore = sc.next();
		
		return pwstore;
	}

	@Override
	public boolean check(String id, String pw) { //로그인 확인
		
		String[] ids = db.getId();
		boolean yes = false;
		
		for(int i=0;i<ids.length;i++) {
		
			if(ids[i].equals(id)) {
				String dbPW = db.getPW(db.getEmNum(id));
				if(dbPW.equals(pw)) {
					yes = true;
				}
			}
		}
		return yes;
	}

	@Override
	public boolean checkManage(String id) {
		
		boolean m = db.getManage(db.getEmNum(id));
		
		return m;
	}
}
