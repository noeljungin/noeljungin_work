package part3;

public class j063 {

	public static void main(String[] args) {
		try {
			int x = 5;
			int y = 20 / (5-x);
			System.out.println(y);
		}
		catch(ArithmeticException e){
			System.out.println("==>0으로 나눴나 확인");
		}
		finally {
			System.out.println("must");
		}
	}
}
