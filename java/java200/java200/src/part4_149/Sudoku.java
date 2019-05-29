package part4_149;

import part4_145.Matrix;
import part4_146.MatrixUtil;

public class Sudoku {
	public void make() {
		clear();
		init();
		shuffle();
		makeS1();
		makeS2();
		makeS3();
		makeS4();
		makeS5();
		makeS6();
		makeS7();
		makeS8();
	}
	
	private double [][] x2 = {{0,1,0}, {0,0,1}, {1,0,0}};
	private double [][] x1 = {{0,0,1}, {1,0,0}, {0,1,0}};
	
	public void makeS1() {
		Matrix s0 = new Matrix(basic);
		Matrix s1 = MatrixUtil.mulMatrix(new Matrix(x2), s0);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sdoku[i][j+n] = s1.getMatrix()[i][j];
			}
		}
	}
	
	public void makeS2() {
		
	}
	
	
}
