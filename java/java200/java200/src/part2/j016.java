package part2;

import java.util.Calendar;
import java.util.Date;

//API에서 제공하는 참조 타입 사용하기
public class j016 {

	public static void main(String[] args) {
		//기본 타입의 배열은 참조 타
		int[ ] m = {1, 2, 3};
		int [] n = new int[] {1,2,3};
		
		//참조 타입 - 객체 타입
		String card = "h8";
		Date d = new Date();	//today
		Calendar cal = Calendar.getInstance(); //today
		
		//참조 타입의 레퍼런스를 출력할떄 자동으로 toString이 붙어서내 정보(데이터)를 살펴볼 수 있다
		System.out.println(card);
		System.out.println(d);
		System.out.println(cal);
	}

}
