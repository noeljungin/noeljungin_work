package part3;

public class j041 {

	public boolean isLeapYear(int year) {
		boolean isS = false;
		if((year %4 == 0 ) && (year % 100 != 0) || (year % 400 == 0)) {
			isS = true;
		}
		return isS;
	}
	
	public static void main(String[] args) {
		j041 hc = new j041();
		System.out.println(hc.isLeapYear(2017));
		
		
	}

}
