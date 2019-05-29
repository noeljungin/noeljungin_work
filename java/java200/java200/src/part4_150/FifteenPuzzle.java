package part4_150;

public class FifteenPuzzle {
	private int [][] puzzle;
	private int n;
	
	public FifteenPuzzle(int n) {
		init(n);
	}
	
	public FifteenPuzzle() {
		this(4);
	}
	
	public void init(int n) {
		this.n = n;
		puzzle = new int[n][n];
		for (int i = 0; i < n*n; i++) {
			puzzle[i/n][i%n] = i;
		}
	}
	
	public int getPuzzle(int r, int c) {
		return puzzle[r][c];
	}
	
	private int num() {
		int row = puzzle.length;
		return (int)((row*row)*Math.random());
	}
	
	public void shuffle() {
		int row = puzzle.length;
		int col = puzzle[0].length;
		int []sh = new int[row * col];
		FifteenPuzzleUtil.toTowOne(puzzle, sh);
		for (int i = 0; i < sh.length; i++) {
			int temp = num();
			int mtemp = sh[i];
			sh[i] = sh[temp];
			sh[temp] = mtemp;
		}
		FifteenPuzzleUtil.toOneTwo(sh, puzzle);
	}
	
	private int invertnumber() {
		int row = puzzle.length;
		int col = puzzle[0].length;
		int []sh = new int[row * col];
		int location = 0;
		FifteenPuzzleUtil.toTowOne(puzzle, sh);
		for (int i = 0; i < sh.length; i++) {
			if(sh[i] == 0) {
				location = i;
				break;
			}
		}
		int ivn = 0;
		for (int i = 0; i < sh.length-1; i++) {
			for (int j = i+1; j < sh.length; j++) {
				if (i!=location && j!=location && sh[i] > sh[j]) {
					ivn++;
				}
			}
		}
		return ivn;
	}
	
	private int zero() {
		int row = puzzle.length;
		int col = puzzle[0].length;
		int []sh = new int[row * col];
		FifteenPuzzleUtil.toTowOne(puzzle, sh);
		int znum = 0;
		
		for (int i = 0; i < sh.length; i++) {
			if (sh[i] == 0) {
				znum = i/col;
				break;
			}
		}
		return znum;
	}
	
	public int evenpuzzle() {
		int num = 0;
		int invert = invertnumber();
		num += invert;
		num += puzzle.length;
		num += zero();
		return num;
	}
	
	public void makePuzzle(boolean show) {
		int num = 0;
		do {
			shuffle();
			num = evenpuzzle();
			if (show) {
				if (puzzle.length%2==0 && num%2==1) {
					System.out.println("even possible middle!");
					System.out.printf("row %d \n", puzzle.length);
					System.out.printf("ivn %d \n", invertnumber());
					System.out.printf("zero %d \n", zero());
					System.out.printf("tot %d \n", num);
					System.out.println("----------------------");
				} else if(puzzle.length%2==0) {
					System.out.println("even impossible middle!");
					System.out.printf("row %d \n", puzzle.length);
					System.out.printf("ivn %d \n", invertnumber());
					System.out.printf("zero %d \n", zero());
					System.out.printf("tot %d \n", num);
					System.out.println("----------------------");
				}
			}
		} while ((puzzle.length + num) %2 == 0);
	}
	
	public void print() {
		int n = puzzle.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.printf("%d \t", puzzle[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public FifteenPuzzle(int [][] pz) {
		this.n = pz.length;
		init(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				puzzle[i][j] = pz[i][j];
			}
		}
	}
	
	public void testPuzzles() {
		int num = evenpuzzle();
		if (puzzle.length%2==0 && num%2==1) {
			System.out.println("even possible middle!");
			System.out.printf("row %d \n", puzzle.length);
			System.out.printf("ivn %d \n", invertnumber());
			System.out.printf("zero %d \n", zero());
			System.out.printf("tot %d \n", num);
			System.out.println("----------------------");
		} else if(puzzle.length%2==0) {
			System.out.println("even impossible middle!");
			System.out.printf("row %d \n", puzzle.length);
			System.out.printf("ivn %d \n", invertnumber());
			System.out.printf("zero %d \n", zero());
			System.out.printf("tot %d \n", num);
			System.out.println("----------------------");
		}
	}
}
