package part4_151;

import java.util.Arrays;
import java.util.Scanner;

public class Hitter {
	private int[] gong;
	private int n;
	private int num = 10;
	public Hitter() {
		this(10, 3);
	}
	
	public Hitter(int num, int n) {
		this.n = n;
		this.num = num;
		gong = new int[n];
		Arrays.fill(gong, -1);
	}
	
	public int[] getGong() {
		return gong;
	}
	
	public void make() {
		System.out.println();
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		for (int i = 0; i < n; i++) {
			gong[i] = s.charAt(i)-'0';
		}
	}
	
	public void print() {
		System.out.println("Hitter");
		for (int i = 0; i < n; i++) {
			System.out.printf("%d\t", gong[i]);
		}
		System.out.println();
	}
}
