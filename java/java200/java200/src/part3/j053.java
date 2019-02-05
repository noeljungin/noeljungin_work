package part3;

public class j053 {
	public static void main(String[] args) {
		int s = 0;
		for(int i = 1; i <= 100; i++) {
			s += i;
		}
		System.out.println("1~100의 합 : " + s);
		s = 0;
		for (int i=1; i <= 100; i++) {
			if(i % 2 == 1) {
				s += i;
			}
		}
		System.out.println("1~100사이의 홀수의의 합" + s);
	}
}
