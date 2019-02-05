package part3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class j059 {

	public static void main(String[] args) {
		List<Integer> ilist = new ArrayList<>();
		int s = 0;
		for (int i = 1; i <= 100; i++) {
			ilist.add(i);
		}
		s = ilist.stream().reduce(0, Integer::sum);
		System.out.println("1~100 사이의 합 " +s);
		s = 0;
		
		s = ilist.stream().filter(i->i%2==1).reduce(0, Integer::sum);
		System.out.println("1~100 사이 홀수의 합 " +s);
		
		s = ilist.stream().filter(i->i%2==1).reduce(0, (x,y)->x+y);
		System.out.println("1~100 사이 홀수의 합 " +s);
		
		s = ilist.stream().filter(i->i%2==1).reduce(0, new BinaryOperator<Integer>() {
			@Override
			public Integer apply(Integer t, Integer u) {
				return t + u;
			}
		});
		System.out.println("1~100사이 홀수의 합 " + s);

	}

}
