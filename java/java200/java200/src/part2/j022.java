package part2;

public class j022 {

	public static void main(String[] args) {
		double S = 6;
		double P = 0.75;
		double L = 200;
		double T = 0;
		double A = 1;
		double Y = 2;
		double ups1 = P * L * (Y+9);
		double downs = (T+1) * (A+1) * (Y+10) * (L+20);
		double ups2 = 12+3*S/8.0;
		double high = ups1 / downs * ups2;
		System.out.printf("적당한 하이힐 높이는 %1$.2fcm입니다", high);
	}

}
