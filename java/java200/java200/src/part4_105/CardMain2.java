package part4_105;

public class CardMain2 {
	public static void main(String[] args) {
		
		Card c1 = new Card("H4");
		Card c2 = new Card("H4");
		
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
		System.out.println(c1.getCardVal());
		System.out.println(c2.getCardVal());
		System.out.println(c1.equals(c2));
		
		
	}
}
