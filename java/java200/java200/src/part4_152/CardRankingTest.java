package part4_152;

import part4_108.CardCase;
import part4_109.Card;

public class CardRankingTest {
	public static void main(String[] args) {
		CardCase cc = new CardCase();
		cc.make();
		cc.print();
		
		Card[] cd = new Card[5];
		cd[0] = new Card("SA");
		cd[1] = new Card("S3");
		cd[2] = new Card("S2");
		cd[3] = new Card("S5");
		cd[4] = new Card("S4");
		
		Card[] cc0 = cc.makeFiveCards(0);
		Card[] cc1 = cc.makeFiveCards(1);
		CardRanking.print(cd);
		CardRanking.print(cc0);
		CardRanking.print(cc1);
		
		System.out.println("1.isStraightFlush %s \n", CardRanking.isStraightFlush(cd));
		System.out.println("1.isStraightFlush %s \n", CardRanking.isStraightFlush(cc0));
		System.out.println("1.isStraightFlush %s \n", CardRanking.isStraightFlush(cc1));
		String sd = CardRanking.toRankName(cd);
		String s0 = CardRanking.toRankName(cc0);
		String s1 = CardRanking.toRankName(cc1);
		System.out.println(sd);
		System.out.println(s0);
		System.out.println(s1);
	 }
}
