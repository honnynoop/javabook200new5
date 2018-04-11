package kr.co.infopub.chapter.s124;
public class MoneyDeposit {
	//적금
	public static double saveUs(int money, int month, double ratio){
		double tot=0.0;
		double r=ratio/100/12;
		double a=money;
		for (int i = 0; i < month; i++) {
			a=a*(1+r);
			tot+=a;
		}
		return tot;
	}
	public static void main(String[] args) {
		double tot=MoneyDeposit.saveUs(800000, 36 , 1.5);
		System.out.printf("적금 :%.0f \n",tot);
	}
}
