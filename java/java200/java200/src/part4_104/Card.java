package part4_104;

public class Card {
	private String cardVal;
	public String getCardVal() {
		return cardVal;
	}
	
	public Card() {
		int suit = (int)(Math.random() * CardUtil.SUIT.length);
		
		int valu = (int)(Math.random() * CardUtil.VALU.length);
		
		cardVal = CardUtil.SUIT[suit] + CardUtil.VALU[valu];
	}
	
	public Card(String s) {
		this.cardVal = s;
	}
	
	public Card(Card c) {
		this(c.getCardVal());
	}
	
	@Override
	public String toString() {
		return "[" + cardVal + "]";
	}

}
