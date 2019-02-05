package part2;

public class j023 {

	public static void main(String[] args) {
		char a = '닳';
		String letter="동해물과 백두산이 마르고 닳도록 하느님이 보우하사";
		int letterNumber = letter.length();
		int loc = letter.indexOf(a);
		System.out.printf("\"%s\"=>%d자이며, '%c'은 %d번째에 있다 \n", letter, letterNumber, a, loc);
		char b = letter.charAt(loc);
		System.out.printf("\"%s의 %d번째 문자는 '%c'이다", letter, loc, b);
		
	}

}
