package part4_127;

public class Java200Math {
	
	public static int sumEach(int n) {
		int tot = 0;
		while (n != 0) {
			tot += n%10;
			n /= 10;
		}
		return tot;
	}
	
	public static boolean isPrime(int n) {
		boolean isS = true;
		
		for (int i = 2; i < (int)Math.sqrt(n); i++) {
			if (n%i == 0) {
				isS = false;
				break;
			}
		}
		return isS;
	}
	
	public static int sumSmith(int n) {
		int tot = 0;
		int a = 2;
		
		while (n != 1) {
			if (n%a == 0) {
				tot += sumEach(a);
				n /= a;
			} else {
				a ++;
			}
		}
		return tot;
	}
	
	public static void printPrimeDivide(int n) {
		int a = 2;
		while(n != 1) {
			if (n%a == 0) {
				if (n/a == 1) {
					System.out.println(a);
				} else {
					System.out.print(a+"x");
				}
				n/=a;
			} else {
				a++;
			}
		}
	}
}
