package part4_146;

import part4_145.Matrix;

public class MatrixUtil {
	public static Matrix addMatrix(Matrix a, Matrix b) {
		int m = a.getMatrix().length;
		int n = a.getMatrix()[0].length;
		double [][]c = new double[m][n];
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++) {
				c[i][j] = a.getMatrix()[i][j] + b.getMatrix()[i][j];
			}
		}
		return new Matrix(c);
	}
	
	public static Matrix diffMatrix(Matrix a, Matrix b) {
		int m = a.getMatrix().length;
		int n = a.getMatrix()[0].length;
		double [][]c = new double[m][n];
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[0].length; j++) {
				c[i][j] = a.getMatrix()[i][j] - b.getMatrix()[i][j];
			}
		}
		return new Matrix(c);
	}
	public static Matrix mulMatrix(Matrix a, Matrix b) {
		int m = a.getMatrix().length;
		int n = a.getMatrix()[0].length;
		int p = b.getMatrix().length;
		double [][]c = new double[m][p];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < p; j++) {
				for (int k = 0; k < n; k++) {
					c[i][j] += a.getMatrix()[i][k] * b.getMatrix()[k][j];
				}
			}
		}
		return new Matrix(c);
	}
}
