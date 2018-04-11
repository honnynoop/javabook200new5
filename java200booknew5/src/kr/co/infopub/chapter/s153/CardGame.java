package kr.co.infopub.chapter.s153;
public class CardGame {
	public static void main(String[] args) {
		CardCase deck=new CardCase();
		deck.make();
		deck.print();
		Card[] one=deck.makeFiveCards(0);
		Card[] two=deck.makeFiveCards(1);		
		
		CardUtil.printFive(one);
		CardUtil.printFive(two);
		
		CardValue cv=new CardValue();
		
		int n1=cv.toVal(one);
		int n2=cv.toVal(two);
		
		if(n1>n2){
			System.out.println("You Win!  "+n1+"  "+n2);
		}else if(n1<n2) {
			System.out.println("You Lose!  "+n1+"  "+n2);
		}else{
			System.out.println("You Same!  "+n1+"  "+n2);
		}
		System.out.println(CardRanking.toRankName(one));
		System.out.println("-------------------");
		System.out.println(CardRanking.toRankName(two));
	}
}