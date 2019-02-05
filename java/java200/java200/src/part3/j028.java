package part3;

public class j028 {
	public static final int PHYSICAL = 23;
	public static void main(String[] args) {
		int index = PHYSICAL;
		int days = 1200;
		double phyval = 100*Math.sin((days % index) * 2 * Math.PI / index);
		System.out.printf("나의 신체지수 %1$.2f입니다 \n", phyval);
	}

}
