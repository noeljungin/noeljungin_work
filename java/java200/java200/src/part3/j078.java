package part3;

public class j078 {

	public static void main(String[] args) {
		String[] myNum = new String [] {"2016-08-17", "2016-09-17", "2016-03-17"};
		String[] myNum2 = {"2016-08-17", "2016-09-17", "2016-03-17"};
		System.out.println(myNum2[0]);
		print(myNum);
		
		myNum = new String[] {"2016-08-17", "2016-09-17", "2016-03-17", "2016-04-17"};
		String [] tos = new String[myNum.length];
		System.arraycopy(myNum, 0, tos, 0, myNum.length);
		print(tos);
	}
	
	public static void print(String [] tos) {
		for(String ss:tos) {
			System.out.printf(ss + "\t");
		}
		System.out.println();
	}

}
