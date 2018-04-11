package kr.co.infopub.chapter.s153.ref;

import java.util.ArrayList;
/*
 * 모든 카드의 경우수를 만들러 족보를 파악한다.
 */
public class CardKinds {
	int count=0;
	int straightflush=0;
	int fourKind=0;
	int fullhouse=0;
	int flush=0;
	int straight=0;
	int threeKind=0;
	int twoPairs=0;
	int onePair=0;
	ArrayList<Card[]> straightflushcardlist=new ArrayList<>();
	ArrayList<Card[]> fourKindcardlist=new ArrayList<>();
	ArrayList<Card[]> fullhousecardlist=new ArrayList<>();
	ArrayList<Card[]> flushcardlist=new ArrayList<>();
	ArrayList<Card[]> straightcardlist=new ArrayList<>();
	ArrayList<Card[]> threeKindcardlist=new ArrayList<>();
	ArrayList<Card[]> twoPairscardlist=new ArrayList<>();
	ArrayList<Card[]> onePaircardlist=new ArrayList<>();

	
	
	public ArrayList<Card[]> getStraightflushcardlist() {
		return straightflushcardlist;
	}



	public ArrayList<Card[]> getFourKindcardlist() {
		return fourKindcardlist;
	}



	public ArrayList<Card[]> getFullhousecardlist() {
		return fullhousecardlist;
	}



	public ArrayList<Card[]> getFlushcardlist() {
		return flushcardlist;
	}



	public ArrayList<Card[]> getStraightcardlist() {
		return straightcardlist;
	}



	public ArrayList<Card[]> getThreeKindcardlist() {
		return threeKindcardlist;
	}



	public ArrayList<Card[]> getTwoPairscardlist() {
		return twoPairscardlist;
	}

	public ArrayList<Card[]> getOnePaircardlist() {
		return onePaircardlist;
	}

	int iallstraight=0;
	ArrayList<Card[]> allstraight=new ArrayList<>();
	
	Card [] result=new Card[5];
	
	
	public CardKinds() {
		straightflushcardlist.clear();
		fourKindcardlist.clear();
		fullhousecardlist.clear();
		flushcardlist.clear();
		straightcardlist.clear();
		threeKindcardlist.clear();
		twoPairscardlist.clear();
		onePaircardlist.clear();
	}

	
	
	public void cardmake(){
		int col=CardUtil.RANK.length;
		int row=CardUtil.SUIT.length;
		Card[] cards=new Card[row*col];
		for (int i = 0; i < row; i++) {//4
			for (int j = 0; j < col; j++) {//13
				cards[i*col+j]=new Card(CardUtil.SUIT[i]+CardUtil.RANK[j]);
			}
		}
		
		CardSaveToHtml csth=new CardSaveToHtml();
		//카드 52장
		//csth.save(cards, "cards.html");
		System.out.println("-------------------");
		
		//straight flush 
		//Card[] cd=new Card[5];
		//comb(row*col,row*col,5,5,cards,cd);
		comb(row*col,row*col,5,5,cards);
		csth.save(straightflushcardlist, "straightflush.html");
        csth.save(fourKindcardlist, "fourkind.html");
//		csth.save(fullhousecardlist, "fullhouse.html");
//		csth.save(flushcardlist, "flush.html");
//		csth.save(straightcardlist, "straight.html");
//		csth.save(threeKindcardlist, "threeKind.html");
//		csth.save(twoPairscardlist, "twoPairs.html");//너무 많아서 안돌리는 것이 좋을 듯
//		csth.save(onePaircardlist, "onePair.html");//너무 많아서 안돌리는 것이 좋을 듯
		System.out.println("--경우수--------------------------------");
                   System.out.println("1.straightflush \t"+straightflush);
		System.out.println("2.fourKind \t\t"+fourKind);
		System.out.println("3.fullhouse \t\t"+fullhouse);
		System.out.println("4.flush \t\t"+flush);
		
		System.out.println("5.straight \t\t"+straight);
		System.out.println("6.threeKind \t\t"+threeKind);
		System.out.println("7.twoPairs \t\t"+twoPairs);
		System.out.println("8.onePair \t\t"+onePair);
		int nothing=count-(straightflush+fourKind
				+fullhouse+flush+straight
				+threeKind+twoPairs+onePair);
		
		System.out.println("9.nothing \t\t"+nothing);
		System.out.println("전체 \t\t\t"+count);
		System.out.println("---확률-----------------");
        System.out.printf("1.straightflush \t%.9f\n",1.0*straightflush/count);
		System.out.printf("2.fourKind \t\t%.9f\n",1.0*fourKind/count);
		System.out.printf("3.fullhouse \t\t%.9f\n",1.0*fullhouse/count);
		System.out.printf("4.flush \t\t%.9f\n",1.0*flush/count);
		System.out.printf("5.straight \t\t%.9f\n",1.0*straight/count);
		System.out.printf("6.threeKind \t\t%.9f\n",1.0*threeKind/count);
		System.out.printf("7.twoPairs \t\t%.9f\n",1.0*twoPairs/count);
		System.out.printf("8.onePair \t\t%.9f\n",1.0*onePair/count);
		System.out.printf("9.nothing \t\t%.9f\n",1.0*nothing/count);
		System.out.printf("----------------------------------------\n");
	}
	public void comb(int n, int N, int  r, int  R, Card [] src){
	//public void comb(int n, int N, int  r, int  R, Card [] src,Card [] result){
	       if ( r == 0 ){
	             //showCards(result, R);
	    	     if(CardRanking.isStraightFlush(result)){
	    	    	 Card[]temp=new Card[5];
	    	    	 System.arraycopy(result, 0, temp, 0, result.length);
	    	    	 straightflushcardlist.add(temp);
	    	    	 //CardRanking.print(result);
	    	    	 straightflush++;
	    	     }
	    	     if(CardRanking.isFourKind(result)){
	    	    	 Card[]temp=new Card[5];
	    	    	 System.arraycopy(result, 0, temp, 0, result.length);
	    	    	 fourKindcardlist.add(temp);
	    	    	 //CardRanking.print(result);
	    	    	 fourKind++;
	    	     }
	    	     if(CardRanking.isFullHouse(result)){
	    	    	 Card[]temp=new Card[5];
	    	    	 System.arraycopy(result, 0, temp, 0, result.length);
	    	    	 fullhousecardlist.add(temp);
	    	    	 //CardRanking.print(result);
	    	    	 fullhouse++;
	    	     }
	    	     if(CardRanking.isFlush(result)){
	    	    	 Card[]temp=new Card[5];
	    	    	 System.arraycopy(result, 0, temp, 0, result.length);
	    	    	 flushcardlist.add(temp);
	    	    	 //CardRanking.print(result);
	    	    	 flush++;
	    	     }
	    	     if(CardRanking.isStraight(result)){
	    	    	 Card[]temp=new Card[5];
	    	    	 System.arraycopy(result, 0, temp, 0, result.length);
	    	    	 straightcardlist.add(temp);
	    	    	 //CardRanking.print(result);
	    	    	 straight++;
	    	     }
	    	     if(CardRanking.isThreeKind(result)){
	    	    	 Card[]temp=new Card[5];
	    	    	 System.arraycopy(result, 0, temp, 0, result.length);
	    	    	 threeKindcardlist.add(temp);
	    	    	 //CardRanking.print(result);
	    	    	 threeKind++;
	    	     }
	    	     if(CardRanking.isTwoPairs(result)){
		  	    	 Card[]temp=new Card[5];
		  	    	 System.arraycopy(result, 0, temp, 0, result.length);
		  	    	 twoPairscardlist.add(temp);
		  	    	 //CardRanking.print(result);
		  	    	 twoPairs++;
	  	         }
	    	     if(CardRanking.isOnePair(result)){
		  	    	 Card[]temp=new Card[5];
		  	    	 System.arraycopy(result, 0, temp, 0, result.length);
		  	    	 onePaircardlist.add(temp);
		  	    	 //CardRanking.print(result);
		  	    	 onePair++;
	  	         }
	             count++; //전체 카운트
	             return;
	       }else if ( n < r ){
	             return;
	       }else{
	             result[R-r] = src[N-n];
	             //comb(n-1, N, r-1, R, src, result);
	             //comb(n-1, N, r, R, src, result);
	             comb(n-1, N, r-1, R, src);
	             comb(n-1, N, r, R, src);
	       }
	}
	
	void showCards(Card [] r, int size){
	       int n = 0;
	       int i = 0;
	       if ( n != 0 ) System.out.printf("%d / ", n);
	       for (; i < size - 1; i++ ){
	    	   System.out.printf("%s, ", r[i]);
	       }
	       System.out.printf("%s\n", r[i]);
	       n++;
	}
	
	
}
