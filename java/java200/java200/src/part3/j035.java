package part3;

public class j035 {

	public static void main(String[] args) {
		int temp = 99;
		temp = (temp % 2 == 1) ? temp * 3 + 1 : temp/2;
		System.out.printf("계산후=%d\n", temp);

	}

}
