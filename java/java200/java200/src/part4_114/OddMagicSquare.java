package part4_114;

public class OddMagicSquare {
	private int[][] magic;
	private int n;
	
	public int[][] getMagic(){
		return magic;
	}
	
	public OddMagicSquare(int n) {
		magic = new int[n][n];
		this.n = n;
	}
	
	public OddMagicSquare() {
		this(3);
	}
	
	public void make() {
		int x = 0;
		int y = n/2;
		for (int i = 0; i < n*n; i++) {
			int temX = x;
			int temY = y;
			System.out.printf("(%d,%d)\t", x, y);
			magic[x][y]=i;
			
			if (x-1<0) {
				x = n-1;
			}
			else {
				x--;
			}
			
			if (y-1<0) {
				y = n-1;
			} else {
				y--;
			}
			
			if (magic[x][y] != 0) {
				x = temX+1;
				y = temY;
			}
		}
	}
	
	public void print() {
		System.out.println();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.println(magic[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
