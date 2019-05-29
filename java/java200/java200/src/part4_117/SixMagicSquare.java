package part4_117;

import part4_114.OddMagicSquare;

public class SixMagicSquare {
	
	private int [][] magic;
	private int n;
	
	public int [][] getMagic(){
		return magic;
	}
	
	public SixMagicSquare(int n) {
		magic = new int[n][n];
		this.n = n;
	}
	
	public SixMagicSquare() {
		this(6);
	}
	
	public void make() {
		makeA();
		makeB();
		makeCD();
		makeMulti();
		makeOdd();
	}
	
	private void makeA() {
		for (int i = 0; i < n/2; i++) {
			for (int j = 0; j < n/4; j++) {
				if (i == n/4) {
					magic[i][j+1] = 3;
				}
				else {
					magic[i][j]=3;
				}
			}
		}
	}
	
	private void makeB() {
		for (int i = 0; i < n/2; i++) {
			for (int j = 0; j < n/2; j++) {
				magic[i][j+n/2] = 1;
			}
		}
		for (int i = 0; i < n/2; i++) {
			for (int j = 0; j < n/2-(n/4-1); j++) {
				magic[i][j+n/2] = 2;
			}
		}
	}
	
	private void makeCD() {
		for (int i = 0; i < n/2; i++) {
			for (int j = 0; j < n/2; j++) {
				if(magic[i][j] == 0) {
					magic[i+n/2][j] = 3;
				}
				else {
					magic[i+n/2][j] = 0;
				}
				
				if (magic[i][j+n/2] == 1) {
					magic[i+n/2][j+n/2] = 2;
				} else {
					magic[i+n/2][j+n/2] = 1;
				}
			}
		}
	}
	
	private void makeMulti() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				magic[i][j] *= (n/2*n/2);
			}
		}
	}
	
	private void makeOdd() {
		OddMagicSquare odd = new OddMagicSquare(n/2);
		odd.make();
		int[][] mm = odd.getMagic();
		for (int i = 0; i < n/2; i++) {
			for (int j = 0; j < n/2; j++) {
				magic[i][j] += mm[i][j];
				magic[i][j+n/2] += mm[i][j];
				magic[i+n/2][j] += mm[i][j];
				magic[i+n/2][j+n/2] += mm[i][j];
			}
		}
	}

	public void print() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
	
	
}






