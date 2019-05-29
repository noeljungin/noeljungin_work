package part4_108;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import part4_104.CardUtil;
import part4_105.Card;
import part4_107.CardComp;
import part4_107.CardRomp;

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
	
	public void sort() {
		Comparator<Card> cmp = new Comparator<Card>() {
			
			@Override
			public int compare(Card c1, Card c2) {
				return c1.getCardVal().compareTo(c2.getCardVal());
			}
		};
		cards.sort(cmp);
	}
	
	public void rsort() {
		cards.sort(new Comparator<Card>() {
			
			@Override
			public int compare(Card c1, Card c2) {
				return -c1.getCardVal().compareTo(c2.getCardVal());
			}
		});
	}
	
	public void lambdasort() {
		cards.sort((c1, c2) -> {return c1.getCardVal().compareTo(c2.getCardVal());});
	}
	
	public void lambdarsort() {
		cards.sort(
				(c1, c2) -> {return -c1.getCardVal().compareTo(c2.getCardVal());}
				);
	}
}
