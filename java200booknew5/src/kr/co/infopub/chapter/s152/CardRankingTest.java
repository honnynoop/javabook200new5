package kr.co.infopub.chapter.s152;
public class CardRankingTest {
 public static void main(String[] args) {
	CardCase cc=new CardCase();
	cc.make();
	cc.print();
    // 테스트용 
    Card[] cd=new Card[5];
	cd[0]=new Card("SA");
	cd[1]=new Card("S3");
	cd[2]=new Card("S2");
	cd[3]=new Card("S5");
	cd[4]=new Card("S4");
	
	Card[] cc0=cc.makeFiveCards(0); // 02468 짝수 5장
	Card[] cc1=cc.makeFiveCards(1); //  13579 홀수 5장
	CardRanking.print(cd);
	CardRanking.print(cc0);
	CardRanking.print(cc1);
	// 족보확인
	System.out.printf("1. isStraightFlush %s\n",CardRanking.isStraightFlush(cd));
	System.out.printf("1. isStraightFlush %s\n",CardRanking.isStraightFlush(cc0));
	System.out.printf("1. isStraightFlush %s\n",CardRanking.isStraightFlush(cc1));
	String sd=CardRanking.toRankName(cd);
	String s0=CardRanking.toRankName(cc0);
	String s1=CardRanking.toRankName(cc1);
	System.out.println(sd);
	System.out.println(s0);
	System.out.println(s1);
 }
}
