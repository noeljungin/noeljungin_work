package part4_148;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import part4_145.Matrix;



public class Sudoku {
	
	boolean isShuffle = true;
	double [][] sdoku;
	double [][] basic;
	int n;
	
	public Sudoku(int n) {
		this.n = n;
		sdoku = new double[n*n][n*n];
		basic = new double[n][n];
	}
	
	public Sudoku() {
		this(3);
	}
	
	private void clear() {
		int m = sdoku.length;
		for (int i = 0; i < m; i++) {
			Arrays.fill(sdoku[i], 0);
		}
	}
	
	public boolean isShuffle() {
		return isShuffle;
	}
	
	public void setShuffle(boolean isShuffle) {
		this.isShuffle = isShuffle;
	}
	
	public void init() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				basic[i][j] = i * n + j + 1;
				sdoku[i][j] = basic[i][j];
			}
		}
	}
	
	public void shuffle() {
		if (isShuffle()) {
			Matrix msdo = MatrixUtil.toTwoOne(new Matrix(basic));
			double [][]mms = msdo.getMatrix();
			ArrayList<Double> list = new ArrayList<Double>();
			for (int i = 0; i < mms[0].length; i++) {
				list.add(mms[0][i]);
			}
			Collections.shuffle(list);
			for (int i = 0; i < mms[0].length; i++) {
				mms[0][i] = list.get(i);
			}
			msdo = MatrixUtil.toOneTwo(new Matrix(mms),n, n);
			basic = msdo.getMatrix();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					sdoku[i][j] = basic[i][j];
				}
			}
		}
	}

}
