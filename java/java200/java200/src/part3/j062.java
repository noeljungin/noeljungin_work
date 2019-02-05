package part3;

public class j062 {

	public static void main(String[] args) {
		String sNum = "123";
		String nNum = "h";
		
		try {
			int a = Integer.parseInt(sNum);
			System.out.println(a);
		}
		catch(NumberFormatException ee){
			System.out.println("int인지 아닌지 확");
			System.out.println(ee.getMessage());
		}
		catch(Exception ee){
			System.out.println("plz good insert");
		}
		finally {
			System.out.println("important");
		}
	}

}
