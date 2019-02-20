package part3;

import java.util.ArrayList;

public class j080 {

	public static void main(String[] args) {
		int intNm1 = 123;
		long longNum1 = 345L;
		double doubleNum = 123.123;
		Integer intWrap1 = intNm1;
		Long longWrap1 = longNum1;
		Double doubleWrap1 = doubleNum;
		double dd = doubleWrap1;
		Integer intWrap2 = intNm1;
		intNm1 = intWrap2;
		System.out.println(intNm1);
		
		ArrayList<Integer> ilists = new ArrayList<>();
		ilists.add(new Integer(3));
		ilists.add(5);
		int a = ilists.get(0);
		System.out.println(a);
		
		int b = Integer.parseInt("123");
		System.out.println(b);

	}

}
