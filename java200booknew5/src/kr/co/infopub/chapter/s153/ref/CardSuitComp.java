package kr.co.infopub.chapter.s153.ref;

import java.util.Comparator;

public class CardSuitComp implements Comparator<Card> {
	@Override
	public int compare(Card o1, Card o2) {
		char c1=o1.getCard().charAt(0);
		char c2=o2.getCard().charAt(0);
		if(c1-c2>0){
			return 1;//asc
		}else if(c1-c2<0){
			return -1;
		}else{
			int cc1=toNum(o1.getCard().charAt(1));
			int cc2=toNum(o2.getCard().charAt(1));
			if(cc1-cc2>0){
				return 1;//asc
			}else if(cc1-cc2<0){
				return -1;
			}else{
				return 0;
			}
		}
	}
	private int toNum(char c){
		int tot=0;
		switch(c){
			case 'A': tot=1;break;
			case 'T': tot=10;break;
			case 'J': tot=11;break;
			case 'Q': tot=12;break;
			case 'K': tot=13;break;
			default : tot=c-'0'; break; //'9'-'0'
		}
		return tot;
	}
}
