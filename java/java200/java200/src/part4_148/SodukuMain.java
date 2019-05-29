package part4_148;

public class SodukuMain {

	public static void main(String[] args) {
		Sudoku sd = new Sudoku(3);
		sd.setShuffle(false);
		sd.init();
		sd.shuffle();
		sd.print();
		

	}

}
