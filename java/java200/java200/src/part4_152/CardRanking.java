package part4_152;

import java.util.Arrays;

import part4_103.Card;

public class CardRanking {
	public static String fiveSuit(Card[] cd) {
		String s = "";
		for (int i = 0; i < cd.length; i++) {
			s = s + cd[i].getCard().charAt(0);
		}
		return s;
	}
	
	public static String fiveRank(Card[] cd) {
		String s = "";
		for (int i = 0; i < cd.length; i++) {
			s = s + cd[i].getCard().charAt(1);
		}
		return s;
	}
	
	public static int[] sameSuits(String s) {
		int[] t = new int[4];
		Arrays.fill(t, 0);
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case 'C': t[0] += 1; break;
			case 'D': t[1] += 1; break;
			case 'H': t[2] += 1; break;
			case 'S': t[3] += 1; break;
			}
		}
		return t;
	}
	
	public static boolean isStraightFlush(Card[] cd) {
		boolean isSF = false;
		if (isAllStraight(cd) && isAllFlush(cd)) {
			isSF = true;
		}
		return isSF;
	}
	
	public static boolean isAllStraight(Card[] cd) {
		boolean isSF = false;
		Card[] ccd = new Card[5];
		System.arraycopy(cd, 0, ccd, 0, cd.length);
		Arrays.sort(ccd, new CardRankComp());
		String fr = CardRanking.fiveRank(ccd);
		String basement = "A23456789TJQK";
		for (int i = 0; i < 9; i++) {
			String ts = basement.substring(i, 5+i);
			if (ts.equals(fr)) {
				isSF = true;
				break;
			}
		}
		if ("ATJQK".equals(fr)) {
			isSF = true;
		}
		return isSF;
	}
	
	public static boolean isAllFlush(Card[] cd) {
		boolean isSF = false;
		Card[] ccd = new Card[5];
		System.arraycopy(cd, 0, ccd, 0, cd.length);
		Arrays.sort(ccd, new CardSuitComp());
		String fs = CardRanking.fiveSuit(ccd);
		int[] ss = sameSuits(fs);
		for (int i = 0; i < ss.length; i++) {
			if (ss[i] == 5) {
				isSF = true;
				break;
			}
		}
		return isSF;
	}
	
	public static void print(Card[] cd) {
		for (int i = 0; i < cd.length; i++) {
			System.out.printf("%s\t", cd[i]);
		}
		System.out.println();
	}
	
	public static String toRankName(Card[] cd) {
		String s = "Nothing";
		
		if (isStraightFlush(cd)) {
			s = "StraightFlush";
		} else if(isFourKind(cd)){
			s = "Four of Kinds";
		}  else if(isFullHouse(cd)){
			s = "Full House";
		} else if(isFlush(cd)){
			s = "Flush";
		} else if(isStraight(cd)){
			s = "Straight";
		} else if(isThreeKind(cd)){
			s = "Three of Kinds";
		} else if(isTwoPairs(cd)){
			s = "Two Pairs";
		} else if(isOnePair(cd)){
			s = "One Pair";
		} else {
			s = "Nothing";
		}
		return s;
	}
}
