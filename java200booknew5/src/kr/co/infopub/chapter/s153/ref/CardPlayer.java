package kr.co.infopub.chapter.s153.ref;

public class CardPlayer {

	private Card[] card;
	public CardPlayer(int n) {
		card=new Card[n];
	}
	public Card[] getCard() {
		return card;
	}

	public void setCard(Card[] cd) {
		System.arraycopy(cd, 0, card, 0, cd.length);
	}
	
	public void setCard(Card cd, int index){
		card[index]=new Card(cd.getCard());
	}
	public void print(){
		System.out.printf("[");
		for (int i = 0; i < card.length; i++) {
			System.out.printf("%s ",card[i]);
		}
		System.out.println("]");
	}
	//
}
