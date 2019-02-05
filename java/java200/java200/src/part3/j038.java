package part3;

public class j038 {

	public static String textInfor(PEI index, double value) {
		String result = "";
		switch(index) {
		case PHYSICAL : result = "body : "; break;
		case EMOTIONAL : result = "emotinal : "; break;
		case INTELLECTUAL : result = "intelli : "; break;
		default : result = "no : "; break;
		}
		return result + (value * 100);
	}
	
	
	public static void main(String[] args) {
		PEI index = PEI.PHYSICAL;
		double value = 0.86;
		System.out.println("value" + index.getPei());
		String st = textInfor(index, value);
		System.out.println(index.ordinal());
		System.out.println(index.name());
		System.out.println(index);
		System.out.println(index.getPei());
		
	}

}
