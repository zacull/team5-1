package employee;

public class Wage_C implements Int_Wage_C {

	Wage_DB wage_m = new Wage_DB();
	Personal_DB pdb = new Personal_DB();
	@Override
	public void viewTotal(String emNum) {
		System.out.println("기본급\t\t: "+wage_m.getBasicM(emNum));
		System.out.println("직책급여\t\t: "+wage_m.getLevelM(emNum));
		System.out.println("식비\t\t: "+wage_m.getEatM(emNum));
		System.out.println("시간외 급여\t\t: "+wage_m.getTimeM(emNum));
		System.out.println("주민세\t\t: "+wage_m.getReTax(emNum));
		System.out.println("고용보험\t\t: "+wage_m.getEmTax(emNum));
		System.out.println("국민건강보험\t: "+wage_m.getHealth(emNum));
		System.out.println("국민연금\t\t: "+wage_m.getNaPen(emNum));
		System.out.println("지급합계\t\t: "+wage_m.getOriginM(emNum));
		System.out.println("공제금액\t\t: "+wage_m.getMinusM(emNum));
		System.out.println("실수령액\t\t: "+wage_m.getRealM(emNum));
	}
}
