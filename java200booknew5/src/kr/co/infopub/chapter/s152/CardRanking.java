package kr.co.infopub.chapter.s152;
import java.util.Arrays;
public class CardRanking {
	// HDSDC 
	public static String fiveSuit(Card[] cd){
		String s="";
		for (int i = 0; i < cd.length; i++) {
			s=s+cd[i].getCard().charAt(0);
		}
		return s;
	}
	// 34824
	public static String fiveRank(Card[] cd){
		String s="";
		for (int i = 0; i < cd.length; i++) {
			s=s+cd[i].getCard().charAt(1);
		}
		return s;
	}
	// 5개의 카드에 CDHS가 각각 몇 개씩 있는가?
	public static int[] sameSuits(String s){
		int[] t=new int[4];
		Arrays.fill(t, 0);
		for (int i = 0; i < s.length(); i++) {
			switch(s.charAt(i)){
				case 'C': t[0]+=1;break;
				case 'D': t[1]+=1;break;
				case 'H': t[2]+=1;break;
				case 'S': t[3]+=1;break;
			}
		}
		return t;
	}
	public static int sameSuit(String s, char c){
		int t=0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)==c){
				t+=1;
			}
		}
		return t;
	}
	public static int sameRank(String s, char c){
		int t=0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)==c){
				t+=1;
			}
		}
		return t;
	}
	public static boolean isStraightFlush(Card[] cd){
		boolean isSF=false;
		if(isAllStraight(cd) && isAllFlush(cd)){
			isSF=true;
		}
		return isSF;
	}
	public static boolean isStraight(Card[] cd){
		boolean isSF=false;
		if(isAllStraight(cd) && !isAllFlush(cd)){
			isSF=true;
		}
		return isSF;
	}
	public static boolean isAllStraight(Card[] cd){
		boolean isSF=false;
		Card[] ccd=new Card[5];
		System.arraycopy(cd, 0, ccd, 0, cd.length);
		Arrays.sort(ccd,new CardRankComp());
		String fr= CardRanking.fiveRank(ccd);
		String basement="A23456789TJQK";
		for (int i = 0; i < 9; i++) {
			String ts=basement.substring(i,5+i);
			if(ts.equals(fr)){
				isSF=true;
				break;
			}
		}
		//TJQKA 일때 Royal Straight
		if("ATJQK".equals(fr)){
			isSF=true;
		}
		//System.out.println(fr);
		return isSF;
	}
	//모든 flush
	public static boolean isAllFlush(Card[] cd){
		boolean isSF=false;
		Card[] ccd=new Card[5];
		System.arraycopy(cd, 0, ccd, 0, cd.length);
		Arrays.sort(ccd,new CardSuitComp());
		String fs=  CardRanking.fiveSuit(ccd);
		int[] ss=sameSuits(fs);
		for (int i = 0; i < ss.length; i++) {
			if(ss[i]==5){
				isSF=true;
				break;
			}
		}
		return isSF;
	}
	//모든 flush 중에서 straight를 제거하면 flush
	public static boolean isFlush(Card[] cd){
		boolean isSF=false;
		if(!isAllStraight(cd) && isAllFlush(cd)){
			isSF=true;
		}
		return isSF;
	}
	
	public static boolean isFourKind(Card[] cd){
		boolean isSF=false;
		Card[] ccd=new Card[5];
		System.arraycopy(cd, 0, ccd, 0, cd.length);
		Arrays.sort(ccd,new CardRankComp());
		String fr= CardRanking.fiveRank(ccd);
		int[] ss=new int[CardUtil.RANK.length];
		for (int i = 0; i < ss.length; i++) {
			ss[i]=sameRank(fr,CardUtil.RANK[i].charAt(0));
		}			
		for (int i = 0; i < ss.length; i++) {
			if(ss[i]==4){
				isSF=true;
				break;
			}
		}
		return isSF;
	}
	public static boolean isThreeKind(Card[] cd){
		boolean isSF=false;
		if(!isAllOnePair(cd) && isAllThreeKind(cd)){
			isSF=true;
		}
		return isSF;
	}
	public static boolean isAllThreeKind(Card[] cd){
		boolean isSF=false;
		Card[] ccd=new Card[5];
		System.arraycopy(cd, 0, ccd, 0, cd.length);
		Arrays.sort(ccd,new CardRankComp());
		String fr= CardRanking.fiveRank(ccd);
		int[] ss=new int[CardUtil.RANK.length];
		for (int i = 0; i < ss.length; i++) {
			ss[i]=sameRank(fr,CardUtil.RANK[i].charAt(0));
		}			
		for (int i = 0; i < ss.length; i++) {
			if(ss[i]==3){
				isSF=true;
				break;
			}
		}
		return isSF;
	}
	public static boolean isFullHouse(Card[] cd){
		boolean isSF=false;
		if(isAllThreeKind(cd) && isAllOnePair(cd)){
			isSF=true;
		}
		return isSF;
	}
	public static boolean isOnePair(Card[] cd){
		boolean isSF=false;
		if(!isAllThreeKind(cd) && isAllOnePair(cd)){
			isSF=true;
		}
		return isSF;
	}
	public static boolean isAllOnePair(Card[] cd){
		int count=0;
		Card[] ccd=new Card[5];
		System.arraycopy(cd, 0, ccd, 0, cd.length);
		Arrays.sort(ccd,new CardRankComp());
		String fr= CardRanking.fiveRank(ccd);
		int[] ss=new int[CardUtil.RANK.length];
		for (int i = 0; i < ss.length; i++) {
			ss[i]=sameRank(fr,CardUtil.RANK[i].charAt(0));
		}
		for (int i = 0; i < ss.length; i++) {
			if(ss[i]==2){
				count++;
			}
		}
		return count==1?true:false;
	}
	public static boolean isTwoPairs(Card[] cd){
		int count=0;
		Card[] ccd=new Card[5];
		System.arraycopy(cd, 0, ccd, 0, cd.length);
		Arrays.sort(ccd,new CardRankComp());
		String fr= CardRanking.fiveRank(ccd);
		int[] ss=new int[CardUtil.RANK.length];
		for (int i = 0; i < ss.length; i++) {
			ss[i]=sameRank(fr,CardUtil.RANK[i].charAt(0));
		}
		for (int i = 0; i < ss.length; i++) {
			if(ss[i]==2){
				count++;
			}
		}
		return count==2?true:false;
	}
	
	public static boolean isNotThing(Card[] cd){
		if(!isStraightFlush(cd) && 
			!isFourKind (cd) &&
			!isFullHouse(cd) &&
			!isFlush(cd) &&
			!isStraight(cd)&&
			!isThreeKind (cd) &&
			!isTwoPairs(cd)&&
			!isOnePair(cd)){
			return true;
		}else return false;
	}
	public static void print(Card[] cd){
		for (int i = 0; i < cd.length; i++) {
			System.out.printf("%s \t",cd[i]);
		}
		System.out.println();
	}
	
	public static void cardRankKind(Card[] cd){
		System.out.printf("1. isStraightFlush %s\n",CardRanking.isStraightFlush(cd));
		System.out.printf("2. isFourKind %s\n",CardRanking.isFourKind(cd));
		System.out.printf("3. isFullHouse %s\n",CardRanking.isFullHouse(cd));
		System.out.printf("4. isFlush %s\n",CardRanking.isFlush(cd));
		System.out.printf("5. isStraight %s\n",CardRanking.isStraight(cd));
		System.out.printf("6. isThreeKind %s\n",CardRanking.isThreeKind(cd));
		System.out.printf("7. isTwoPairs %s\n",CardRanking.isTwoPairs(cd));
		System.out.printf("8. isOnePair %s\n",CardRanking.isOnePair(cd));
		System.out.printf("9. isNotThing %s\n",CardRanking.isNotThing(cd));
	}
	
	public static String toRankName(Card[] cd){
		String s="Nothing";
		if(isStraightFlush(cd)){
			s="StraightFlush";
		}else if(isFourKind (cd)){
			s="Four of Kinds";
		} else if(isFullHouse (cd)){
			s="FullHouse";
		} else if(isFlush (cd)){
			s="Flush";
		} else if(isStraight (cd)){
			s="Straight";
		} else if(isThreeKind (cd)){
			s="Three of Kinds";
		} else if(isTwoPairs (cd)){
			s="TwoPairs";
		} else if(isOnePair (cd)){
			s="OnePair ";
		} else {
			s="Nothing ";
		} 
		return s;
	}
	
}
