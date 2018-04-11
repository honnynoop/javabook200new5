package kr.co.infopub.chapter.s153.ref;
import java.util.ArrayList;
import java.util.Collections;
public class CardCase {
	private final static int numOfCards ;
	static{ //static »ý¼ºÀÚ
		numOfCards = 
			CardUtil.SUIT.length * CardUtil.RANK.length;
	}
	private ArrayList<Card> cards;
	
	public CardCase(){ 
		make(); 
	}
	public void make(){
		init();
		makeInit();
	}
	private void makeInit(){
		int count = 0;
		while (count!=numOfCards) {
			Card cc = new Card();
			if (!cards.contains(cc)) {
				cards.add(cc);
				count++;
			}
		}
	}
	public void shuffle(){
		Collections.shuffle(cards);
	}
	public int size(){
		return cards.size();
	}	
	public void init(){
		cards = new ArrayList<Card>();
		cards.clear();
	}
	
	public ArrayList<Card> getAllCard(){
		return cards;
	}
	public Card getCard(int i) {
		return cards.get(i);
	}
	public void print(){
		int rank=CardUtil.RANK.length;
		for (int i = 0; i < cards.size(); i++) {
			Card c=cards.get(i);
			System.out.printf("%s ",c.toString());
			if((i+1)%rank==0){
				System.out.println();
			}
		}
	}
	public static void print(Card[] cd){
		for (int i = 0; i < cd.length; i++) {
			System.out.printf("%s \t",cd[i]);
		}
		System.out.println();
	}
	public Card[] makeFiveCards(){
		Card[] cd=new Card[5];
		for (int i = 0; i < cd.length; i++) {
			cd[i]=getCard(i);
		}
		return cd;
	}
	//0Â¦¼ö5°³, 1 È¦¼ö 5°³
	public Card[] makeFiveCards(int index){
		Card[] cd=new Card[5];
		if(index%2==0){ //0,2,4,6,8
			for (int i = 0,j=0; i < cd.length; i++, j+=2) {
				cd[i]=getCard(j);
			}
		}else{  //1,3,5,7,9
			for (int i = 0,j=1; i < cd.length; i++, j+=2) {
				cd[i]=getCard(j);
			}
		}
		return cd;
	}
}
