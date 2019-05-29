package part4_141;

public class PascalMain {

	public static void main(String[] args) {
		int[][] pt = Pascal.triAngel(10);
		for (int i = 0; i < pt.length; i++) {
			for (int j = 0; j < pt[i].length; j++) {
				System.out.printf("%d\t", pt[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		int []bt = Pascal.phibo(20);
		for (int i = 0; i < bt.length; i++) {
			System.out.printf("%d\t", bt[i]);
		}
	}
}
