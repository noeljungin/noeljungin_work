package part4_147;

import part4_145.Matrix;

public class MatrixUtil {
	public static Matrix revMatrix(Matrix a) {
		double [][] matricex = a.getMatrix();
		double [][] matrices = new double[matricex.length][matricex[0].length*2];
		
		for (int i = 0; i < matricex.length; i++) {
			for (int j = 0; j < matricex[i].length; j++) {
				matrices[i][j] = matricex[i][j];
			}
		}
		for (int i = 0; i < matricex.length; i++) {
			matrices[i][i+matricex[i].length] = 1.0;
		}
		int row = matrices.length;
		int col = matrices[0].length;
		for (int k = 0; k < row; k++) {
			double max = 0.0;
			int pivotRow = k;
			for (int j = k; j < row; j++) {
				double tempMax = Math.abs(matrices[j][k]);
				if (max < tempMax) {
					max = tempMax;
					pivotRow = j;
				}
			}
			if (k != pivotRow) {
				for (int j = 0; j < col; j++) {
					double temp = matrices[k][j];
					matrices[k][j] = matrices[pivotRow][j];
					matrices[pivotRow][j] = temp;
				}
			}
			double pivot = matrices[k][k];
			for (int j = k; j < col; j++) {
				matrices[k][j] /= pivot;
			}
			for (int i = 0; i < row; i++) {
				if (i != k) {
					double delta = matrices[i][k];
					for (int j = k; j < col; j++) {
						matrices[i][j] -= delta*matrices[k][j];
					}
				}
			}
		}
		double [][] results = new double[matricex.length][matricex.length];
		for (int i = 0; i < matricex.length; i++) {
			for (int j = 0; j < matricex[i].length; j++) {
				results[i][j] = matrices[i][j+matricex[i].length];
			}
		}
		return new Matrix(results);
	}
}
