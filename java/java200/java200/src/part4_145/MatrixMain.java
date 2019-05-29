package part4_145;

public class MatrixMain {

	public static void main(String[] args) {
		double [][] m1 = {
				{1,2,3},
				{2,3,4},
				{3,4,5}
		};
		Matrix mtr1 = new Matrix(m1);
		double [][] m2 = {
				{-1,2,-3},
				{2,-3,4},
				{-3,4,-5}
		};
		Matrix mtr2 = new Matrix(m2);
		mtr1.print();
		mtr2.print();
		
		Matrix mtr3 = mtr1.makeMatrix();
		mtr3.print();
		
		System.out.println(mtr1.equals(mtr3));

	}

}
