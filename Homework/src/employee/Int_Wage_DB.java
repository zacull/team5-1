package employee;

public interface Int_Wage_DB {
	/*
	 *  set함수들은 DB에 값을 수정하거나 추가한다.(사원번호를 받아 수정한다.)
	 * 
	 *  get함수들은 DB에서 값을 가져온다.(사원 번호를 받아 값을 가져온다.)
	 */
	
	/*
	 * int basicM : 기본급여
	 * int levelM : 직책수당
	 * int eatM : 식비
	 * int timeM : 시간외 급여
	 * int reTax : 주민세
	 * int emTax : 고용보험
	 * 
	 */
	
	public void setBasicM(String emNum, int basicM) ;
	public void setLevelM(String emNum, int levelM) ;
	public void setEatM(String emNum, int eatM) ;
	public void setTimeM(String emNum, int timeM) ;
	public void setReTax(String emNum, int reTax) ; // 주민세 
	public void setEmTax(String emNum, int emTax) ; // 고용보험 
	
	public int getBasicM(String emNum) ;
	public int getLevelM(String emNum) ;
	public int getEatM(String emNum) ;
	public int getTimeM(String emNum) ;
	public int getReTax(String emNum) ; // 주민세 
	public int getEmTax(String emNum) ; // 고용보험 
	public String[] getEmNum() ; // 전체 사원번호 조회
	
	public int getHealth(String emNum) ; // 국민건강보험 - 지급합계에서 6%
	public int getNaPen(String emNum) ; // 국민연금 - 10%
	public int getOriginM(String emNum) ; // 지급합계 - 계산
	public int getMinusM(String emNum) ; // 공제금액 - 계산
	public int getRealM(String emNum) ; // 실수령액 - 계산
	
	
}
