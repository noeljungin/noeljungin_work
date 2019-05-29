package part4_138;

public class HanoiUtil {
	public static void moveHanoi(int [][]a, int num, char ringA, char ringB, char ringC) {
		if (num == 1) {
			showHanoi(a, ringA, ringA);
		} else {
			moveHanoi(a, num-1, ringA, ringC, ringB);
			showHanoi(a, ringA, ringB);
			moveHanoi(a, num-1, ringC, ringB, ringA);
		}
	}
	
	public static void showHanoi(int [][]a, char ringA, char ringB) {
		int aa = 0;
		int ab = 1;
		
		switch(ringA) {
		case 'a': aa = 0; break;
		case 'b': aa = 1; break;
		case 'c': aa = 1; break;
		}
		
		switch(ringB) {
		case 'a': ab = 0; break;
		case 'b': ab = 1; break;
		case 'c': ab = 2; break;
		}
		
		System.out.println(ringA + " bar쪽에 있던 링이" + ringB + " bar쪽으로 이동");
		puts(a, aa, ab);
		showHanoi(a);
	}
	
	public static void showHanoi(int [][] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print("[\t");
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j]+"\t");
			}
			System.out.println("]");
		}
		System.out.println("============================");
	}
	
	public static int hasTray(int [][]a, int bar) {
		int no =-1;
		for (int i = 0; i < a.length; i++) {
			if (a[i][bar] != 0) {
				no = i;
				break;
			}
		}
		return no;
	}
	
	private static void change(int [][] a, int aa, int ab, int ba, int bb) {
		System.out.println("(" + aa + "," + ab + ")==>" + "(" + ba + "," + bb + ") :");
		a[ba][bb] = a[aa][ab];
		a[aa][ab] = 0;
	}
	
	public static void puts(int [][]a, int barA, int barB) {
		if (hasTray(a, barA) != -1) {
			if (hasTray(a, barB) != -1) {
				change(a, hasTray(a, barA), barA, hasTray(a, barB)-1, barB);
			} else {
				change(a, hasTray(a, barA), barA, a.length-1, barB);
			}
		}
	}
}

