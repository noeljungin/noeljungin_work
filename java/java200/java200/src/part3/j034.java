package part3;

public class j034 {

	public static void main(String[] args) {
		int temp = 99;
		if(temp %2 == 1) {
			temp = temp * 3 + 1;
		}
		else {
			temp = temp/2;
		}
		System.out.printf("계산후=%d\n", temp);
	}

}
