package part4_150;

public class FifteenPuzzleMain {

	public static void main(String[] args) {
		int [][]m = {
				{1,2,3,4},
				{5,6,0,7},
				{9,10,11,8},
				{13,14,15,12}
		};
		FifteenPuzzle puzzle = new FifteenPuzzle(m);
		puzzle.testPuzzles();
		puzzle.print();
		
		FifteenPuzzle puzzle2 = new FifteenPuzzle();
		puzzle2.makePuzzle(false);
		puzzle2.print();
	}

}
