package part4_127;

public class Smith {
	
	public static void primeSmith(int t1, int t2) {
		for (int i = 0; i < t2; i++) {
			if (!Java200Math.isPrime(i) && Java200Math.sumEach(i) == Java200Math.sumSmith(i)) {
				System.out.printf("%d is smith number", i);
				Java200Math.printPrimeDivide(i);
			}
			
		}
	}

	public static void main(String[] args) {
		primeSmith(100000, 200000);

	}

}
