package part4_151;

import java.util.Arrays;

public class Pitcher {
	private int[] gong;
	private int n;
	private int num = 10;
	public Pitcher() {
		this(10, 3);
	}
	
	public Pitcher(int num, int n) {
		super();
		this.n = n;
		this.num = num;
		gong = new int[n];
		Arrays.fill(gong, -1);
	}
	
	public int[] getGong() {
		return gong;
	}
	
	public int makeOne() {
		return (int)(Math.random()*num);
	}
	
	public boolean contains(int gn) {
		boolean isC = false;
		for (int i = 0; i < n; i++) {
			if (gn == gong[i]) {
				isC = true;
				break;
			}
		}
		return isC;
	}
	
	public void make() {
		Arrays.fill(gong, -1);
		int count = 0;
		while (count != n) {
			int temp = makeOne();
			if (!contains(temp)) {
				gong[count++] = temp;
			}
		}
	}
	
	public void print() {
		for (int i = 0; i < n; i++) {
			System.out.printf("%d\t", gong[i]);
		}
		System.out.println();
	}
	
}
