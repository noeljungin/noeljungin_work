package part4_107;

import java.util.Comparator;

import part4_104.CardUtil;
import part4_105.Card;

public class CardComp implements Comparator<Card>{
	
	@Override
	public int compare(Card c1, Card c2) {
		
		if(c1.getCardVal().charAt(0) > c2.getCardVal().charAt(0)) {
			return 1;
		}
		else if(c1.getCardVal().charAt(0) < c2.getCardVal().charAt(0)){
			return -1;
		}
		else {
			if(CardUtil.toVal(c1.getCardVal().charAt(1)) > CardUtil.toVal(c2.getCardVal().charAt(1))) {
				return 1;
			}
			else if(CardUtil.toVal(c1.getCardVal().charAt(1)) < CardUtil.toVal(c2.getCardVal().charAt(1))) {
				return -1;
			}
			else return 0;
		}
	}
}
