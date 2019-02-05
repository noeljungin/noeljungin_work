package part3;

public class j044 {

	public static void showOddnEven(int n) {
		int temp = n;
		do {
			if(temp %2 == 1) {
				temp = temp * 3 + 1;
			}
			else {
				temp /= 2;
			}
			System.out.print("[" + temp + "]");
		}while(temp != 1);
		System.out.println("\n----------");
	}
	
	public static void main(String[] args) {
		showOddnEven(122);
		

	}

}
