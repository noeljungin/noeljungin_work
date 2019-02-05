package part3;

public class j069 {

	public static void main(String[] args) {
		StringBuffer sb1 = new StringBuffer();
		sb1.append("안녕하세요").append("또 만나요").append("기다려봐");
		System.out.println(sb1.toString()+sb1.hashCode());
		
		sb1.replace(0, 2, "나 보기가 역겨워");
		System.out.println(sb1.toString() + sb1.hashCode());
		
		sb1.reverse();
		System.out.println(sb1.toString());
		
		sb1.delete(10, 15);
		System.out.println(sb1.toString());
		
		replaces(sb1);
		System.out.println(sb1.toString());
		
	}
	
	public static void replaces(StringBuffer sb) {
		sb.reverse();
		sb.replace(0, 3, "GoGo");
	}

}
