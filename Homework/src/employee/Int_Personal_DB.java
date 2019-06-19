package employee;


public interface Int_Personal_DB {

	/*
	 *  set함수들은 DB에 값을 수정하거나 추가한다.(사원번호를 받아 수정한다.)
	 * 
	 *  get함수들은 DB에서 값을 가져온다.(사원 번호를 받아 값을 가져온다.)
	 */
	
	/*
	 * String id : 아이디
	 * String emNum : 사원 번호
	 * String pw : 비밀 번호
	 * boolean manage : true면 관리자, false면 일반사원
	 * int birth : 생년월일
	 * String sex : 성별
	 * int staD : 입사일
	 * String level : 직급
	 * String group : 부서
	 * String eMail : 이메일 주소
	 * String address : 집 주소
	 * String phone : 휴대폰 번호
	*/
	
	// set함수
	public void setName(String emNum, String name) ;
	public void setId(String emNum, String id) ;
	public void setPW(String emNum, String pw) ;
	public void setManage(String emNum, String manage) ;
	public void setEmNum(String id,String emNum) ; // 사원번호를 수정하기 위해 id로 구분한다.
	public void createEmNum(String emNum,String id); // 사원번호로 생성
	public void setBirth(String emNum, int birth) ;
	public void setSex(String emNum,String sex) ;
	public void setStaD(String emNum, int staD ) ;
	public void setLevel(String emNum, String level) ;
	public void setGroup(String emNum,String group) ;
	public void setEMail(String emNum,String eMail) ;
	public void setAddress(String emNum, String address) ;
	public void setPhone(String emNum,String phone) ;
	
	// get함수
	public String[] getId() ; // 전체 아이디 조회
	public String[] getEmNum() ; // 전체 사원번호 조회
	public String[] getName() ; // 전체 이름
	public String getName(String emNum) ;
	public String getId(String emNum) ;
	public String getPW(String emNum) ;
	public boolean getManage(String emNum) ;
	public String getEmNum(String id) ;
	public int getBirth(String emNum) ;
	public String getSex(String emNum) ;
	public int getStaD(String emNum) ;
	public String getLevel(String emNum) ;
	public String getGroup(String emNum) ;
	public String getEMail(String emNum) ;
	public String getAddress(String emNum) ;
	public String getPhone(String emNum) ;
	
	// 제거하는 함수
	void delete(String emNum); // 사원 번호로 한 사람의 데이터를 제거한다.
}
