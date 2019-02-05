package part3;

public class j029 {
	
	public static final int PHYSICAL = 23;
	
	public static double getBioRhythm(long days, int index, int max) {
		return max * Math.sin((days % index) * 2 * Math.PI / index);
	}
	
	public static void main(String[] args) {
		int days = 120;;
		double phyval = getBioRhythm(days, PHYSICAL, 100);
		System.out.printf("나의 신체 지수 %1$.2f입니\n", phyval);
	}

}
