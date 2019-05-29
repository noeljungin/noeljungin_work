package part4_106;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import part4_104.CardUtil;
import part4_105.Card;

public class CardCase {
	private List<Card> cards = new ArrayList<Card>();
	
	public CardCase() {
		cards.clear();
	}
	
	public List<Card> getCards(){
		return cards;
	}
	
	public int count() {
		return cards.size();
	}
	
	public Card getCard(int index) {
		return cards.get(index);
	}
	
	public void make() {
		cards.clear();
		int suit = CardUtil.SUIT.length;
		int value = CardUtil.VALU.length;
		int count = 0;
		
		while(count != value * suit) {
			Card c = new Card();
			if(!cards.contains(c)) {
				cards.add(c);
				count++;
			}
		}
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public void print() {
		int valu = CardUtil.VALU.length;
		for (int i=0; i < cards.size(); i++) {
			Card c = cards.get(i);
			System.out.printf("%s ", c.toString());
			
			if((i + 1) % valu == 0) {
				System.out.println();
			}
		}
	}
	
}
