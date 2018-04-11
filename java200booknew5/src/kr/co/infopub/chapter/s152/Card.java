package kr.co.infopub.chapter.s152;

public class Card {
	private String card; //H8
	public String getCard() {
		return card;
	}
	public Card() {
		//0~3
		int suit=(int)(Math.random()*CardUtil.SUIT.length);
		//0~12
		int rank=(int)(Math.random()*CardUtil.RANK.length);
		//임의의 카드 값을 갖는다. H6
		card=CardUtil.SUIT[suit]+CardUtil.RANK[rank];
	}
	//테스트 할때 사용
	public Card(String s) {
		this.card=s;
	}
	//복사 생성자  테스트 할때 사용
	public Card(Card s) {
		this(s.getCard());
	}
	@Override
	public String toString() {
		return "[" + card + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((card == null) ? 0 : card.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		Card cb=(Card)obj;
		if(card.equals(cb.getCard())){
			return true;
		}else{
			return false;
		}
	}
}//
