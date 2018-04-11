package kr.co.infopub.chapter.s153;

public class CardUtil {

 public static final String[] 
   SUIT={"S","D","H","C"};
 public static final String[]
   RANK={"A","2","3","4","5",
	 "6","7","8","9",
	 "T","J","Q","K"};     
 
 public static int toVal(Card c){
	 return toVal(c.getCard().charAt(1));
 }
 public static int toVal(char cc){
	 int tot=0;
	 switch (cc) {
	 	case 'A':tot=1;break;
	 	case 'T':tot=10;break;
	 	case 'J':tot=11;break;
	 	case 'Q':tot=12;break;
	 	case 'K':tot=13;break;
	 	default: tot=cc-'0';break;
	}
	 return tot;
 }
 
 public static void printFive(Card[] cd){
	 for (int i = 0; i < cd.length; i++) {
		System.out.printf("%s\t",cd[i].toString());
	}
	 System.out.println();
 }
 
 
}
