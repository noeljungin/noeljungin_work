package part3;

public class j049 {
	public static boolean isPrime(int n) {
		boolean isS = true;
		for(int i = 2; i <= (int)Math.sqrt(n); i++) {
			if(n%i == 0) {
				isS = false;
				break;
			}
		}
		return isS;
	}

	public static void main(String[] args) {
		int number = 1234567;
		boolean ifPrime = isPrime(number);
		if(ifPrime) {
			System.out.printf("%는 1과 자신으로만 나눠 떨어지는 소수", number);
		}else {
			System.out.printf("%d은 소수가 아니다", number);
		}
	}

}
