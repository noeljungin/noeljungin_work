package part3;

public class j076 {

	public static void main(String[] args) {
		Character chr1 = new Character('W');
		Character chr2 = new Character('9');
		
		if(Character.isLetter(chr1.charValue())) {
			System.out.printf("1 " + chr1.charValue());
		}
		System.out.print("");
		System.out.print('\u0057');
		System.out.print("\t");
		System.out.println(Integer.toHexString((int)chr1));
		System.out.println((int)chr1);
		if(Character.isDigit(chr2.charValue())) {
			System.out.println("2 "+ (int)chr2.charValue());
		}
		
		System.out.println("3 "+Character.getType('a'));
		System.out.println("4 "+Character.getType('A'));
		System.out.println("5 "+Character.getType('3'));
		System.out.println("6 "+Character.getType('&'));
		System.out.println("7 "+Character.getType('\n'));
		System.out.println("8 "+(int)'\b');
		System.out.println("9 "+ (int)'\t');
		System.out.println(""+(int)'\n');
		System.out.println(""+(int)'\f');
		System.out.println(""+(int)'\r');
		System.out.println(""+Character.getNumericValue('9'));
		System.out.println(""+Character.isWhitespace(' '));
		System.out.println(""+Character.isWhitespace('\n'));
		System.out.println(""+Character.isWhitespace('\r'));
		System.out.println(""+Character.isWhitespace('\b'));
		System.out.println(""+Character.isLetterOrDigit('9'));
		System.out.println(""+Character.isLowerCase('A'));
		System.out.println(""+Character.isUpperCase('A'));
		
		System.out.println(""+Character.digit('8', 9));
		System.out.println(""+(int)' ');
		System.out.println(""+Character.isSpaceChar(' '));
		System.out.println(""+Character.isSpaceChar('\n'));
	}

}
