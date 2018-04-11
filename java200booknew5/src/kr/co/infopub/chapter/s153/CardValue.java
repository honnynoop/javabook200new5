package kr.co.infopub.chapter.s153;
import java.util.Arrays;
// 족보를 값으로 환산하기
public class CardValue {
	public int toVal(Card[] cd){
		int tot=0;
		if(CardRanking.isStraightFlush(cd)){
			tot=toStraightFlush(cd);//calculate
		}else if(CardRanking.isFourKind(cd)){
			tot=toFourKind(cd);//calculate
		}else if(CardRanking.isFullHouse(cd)){
			tot=toFullHouse(cd);//calculate
		}else if(CardRanking.isFlush(cd)){
			tot=toFlush(cd);//calculate
		}else if(CardRanking.isStraight(cd)){
			tot=toStraight(cd);//calculate
		}else if(CardRanking.isThreeKind(cd)){
			tot=toThreeKind(cd);//calculate
		}else if(CardRanking.isTwoPairs(cd)){
			tot=toTwoPairs(cd);//calculate
		}else if(CardRanking.isOnePair(cd)){
			tot=toOnePair(cd);//calculate
		}else{
			tot=toNotThing(cd);//calculate
		}
		return tot;
	}
	public int toStraightFlush(Card[] cd){
		int tot=100000;
		Card[] ccd=new Card[5];
		System.arraycopy(cd, 0, ccd, 0, cd.length);
		Arrays.sort(ccd,new CardRankComp());
		String fr= CardRanking.fiveRank(ccd);
		String basement="A23456789TJQK";
		for (int i = 0; i < 9; i++) {
			String ts=basement.substring(i,5+i);
			if(ts.equals(fr)){
				tot+=CardUtil.toVal(ts.charAt(0))*200;
				break;
			}
		}
		//TJQKA 일때 Royal Straight
		if("ATJQK".equals(fr)){
			tot+=CardUtil.toVal('T')*200;//"TJQKA"
		}
		return tot;
	}
	public int toNotThing(Card[] cd) {
		int tot=0;
		Card[] ccd=new Card[5];
		System.arraycopy(cd, 0, ccd, 0, cd.length);
		Arrays.sort(ccd,new CardRankComp());
		for (int i = 0; i < ccd.length; i++) {
			tot+=CardUtil.toVal(ccd[i])*(i+1)*20;
		}
		return tot;
	}
	public int toOnePair(Card[] cd) {
		int tot=30000;
		Card[] ccd=new Card[5];
		System.arraycopy(cd, 0, ccd, 0, cd.length);
		Arrays.sort(ccd,new CardRankComp());
		String fr= CardRanking.fiveRank(ccd);
		int[] ss=new int[CardUtil.RANK.length];
		for (int i = 0; i < ss.length; i++) {
			ss[i]=CardRanking.sameRank(fr,CardUtil.RANK[i].charAt(0));
		}
		int[] mm=new int[3];
		int t=0;
		for (int i = 0; i < ss.length; i++) {
			if(ss[i]==2){
				tot+=(i+1)*200;
				//break;
			}else if(ss[i]==1){
				mm[t++]=(i+1);
			}
		}
		for (int i = 0; i < mm.length; i++) {
			//System.out.println(mm[i]);
			tot+= mm[i]*20*(i+1);//34
		}
		return tot;
	}
	public int toTwoPairs(Card[] cd) {
		int tot=40000;
		Card[] ccd=new Card[5];
		System.arraycopy(cd, 0, ccd, 0, cd.length);
		Arrays.sort(ccd,new CardRankComp());
		String fr= CardRanking.fiveRank(ccd);
		int[] ss=new int[CardUtil.RANK.length];
		for (int i = 0; i < ss.length; i++) {
			ss[i]=CardRanking.sameRank(fr,CardUtil.RANK[i].charAt(0));
		}
		int temp=0;
		for (int i = 0; i < ss.length; i++) {
			if(ss[i]==2){
				tot+=(i+1)*200;
			}else if(ss[i]==1){
				temp=(i+1);
			}
		}
		tot+= temp*20;//34
		return tot;
	}
	public int toThreeKind(Card[] cd) {
		int tot=50000;
		Card[] ccd=new Card[5];
		System.arraycopy(cd, 0, ccd, 0, cd.length);
		Arrays.sort(ccd,new CardRankComp());
		String fr= CardRanking.fiveRank(ccd);//2777K
		int[] ss=new int[CardUtil.RANK.length];
		for (int i = 0; i < ss.length; i++) {
			ss[i]=CardRanking.sameRank(fr,CardUtil.RANK[i].charAt(0));
		}
		int[] mm=new int[2];
		int t=0;
		for (int i = 0; i < ss.length; i++) {
			if(ss[i]==3){
				tot+=(i+1)*300;
			}else if(ss[i]==1){
				mm[t++]=(i+1);
			}
		}

		for (int i = 0; i < mm.length; i++) {
			//System.out.println(mm[i]);
			tot+= mm[i]*20*(i+1);//34
		}
		return tot;
	}
	public int toStraight(Card[] cd) {
		int tot=60000;
		Card[] ccd=new Card[5];
		System.arraycopy(cd, 0, ccd, 0, cd.length);
		Arrays.sort(ccd,new CardRankComp());
		String fr= CardRanking.fiveRank(ccd);
		String basement="A23456789TJQK";
		for (int i = 0; i < 9; i++) {
			String ts=basement.substring(i,5+i);
			if(ts.equals(fr)){
				tot+=CardUtil.toVal(ts.charAt(0))*200;
				break;
			}
		}
		//TJQKA 일때 Royal Straight
		if("ATJQK".equals(fr)){
			tot+=CardUtil.toVal('T')*200;//"TJQKA"
		}
		return tot;
	}

	public int toFlush(Card[] cd) {
		int tot=70000;
		Card[] ccd=new Card[5];
		System.arraycopy(cd, 0, ccd, 0, cd.length);
		Arrays.sort(ccd,new CardSuitComp());
		String fs=  CardRanking.fiveSuit(ccd);
		int[] ss=CardRanking.sameSuits(fs);//CDHS
		for (int i = 0; i < ss.length; i++) {
			if(ss[i]==5){
				tot+=  //값이 큰 숫자부터 값대입
						 CardUtil.toVal(ccd[4])*20*5
						+CardUtil.toVal(ccd[3])*20*4
						+CardUtil.toVal(ccd[2])*20*3
						+CardUtil.toVal(ccd[1])*20*2
						+CardUtil.toVal(ccd[0])*20*1;
				break;
			}
		}
		return tot;
	}


	public int toFullHouse(Card[] cd) {
		int tot=80000;
		Card[] ccd=new Card[5];
		System.arraycopy(cd, 0, ccd, 0, cd.length);
		Arrays.sort(ccd,new CardRankComp());
		String fr= CardRanking.fiveRank(ccd);
		int[] ss=new int[CardUtil.RANK.length];
		for (int i = 0; i < ss.length; i++) {
			ss[i]=CardRanking.sameRank(fr,CardUtil.RANK[i].charAt(0));
		}			
		for (int i = 0; i < ss.length; i++) {
			if(ss[i]==3){
				tot+=(i+1)*200;
				break;
			}
		}
		for (int i = 0; i < ss.length; i++) {
			if(ss[i]==2){
				tot+=(i+1)*20;
				break;
			}
		}
		return tot;
	}


	public int toFourKind(Card[] cd){
		int tot=90000;
		Card[] ccd=new Card[5];
		System.arraycopy(cd, 0, ccd, 0, cd.length);
		Arrays.sort(ccd,new CardRankComp());
		String fr= CardRanking.fiveRank(ccd);
		int[] ss=new int[CardUtil.RANK.length];
		for (int i = 0; i < ss.length; i++) {
			ss[i]=CardRanking.sameRank(fr,CardUtil.RANK[i].charAt(0));
		}			
		for (int i = 0; i < ss.length; i++) {
			if(ss[i]==4){
				tot+=200*(i+1);  //5가 네장-> 5*200
			}else if(ss[i]==1){
				tot+=10*(i+1);   //나머지 한장의 값 
			}
		}
		return tot;
	}
}
