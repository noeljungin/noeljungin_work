package part4_150;

public class FifteenPuzzleUtil {
	public static void toTowOne(int [][] org, int[] tar) {
		int row = org.length;
		int col = org[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				tar[i*col+j] = org[i][j];
			}
		}
	}
	
	public static void toOneTwo(int [] org, int[][] tar) {
		int n = org.length;
		int col = tar[0].length;
		for (int i = 0; i < n; i++) {
			tar[i/col][i%col] = org[i];
		}
	}
}
