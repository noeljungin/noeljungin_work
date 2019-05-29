package part4_143;

public class Floyd {
	
	private int[][] data;
	private int[][] p;
	public String[] name;
	public Floyd() {
		init();
	}
	public void init() {
		data = new int[][] {
			{0, 2, 3, 1000, 7},
			{2, 1000, 0, 6, 1000},
			{1000, 1000, 3, 0, 4},
			{6, 1, 6, 2, 0}
			};
		p = new int[data.length][data.length];
		name = new String[] {"P1", "P2", "P3", "P4", "P5"};
	}
	
	public void distance() {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length; j++) {
				p[i][j] = -1;
			}
		}
		for (int k = 0; k < data.length; k++) {
			for (int i = 0; i < data.length; i++) {
				for (int j = 0; j < data.length; j++) {
					if (data[i][j] > data[i][k] + data[k][j]) {
						p[i][j] = k;
						data[i][j] = data[i][k] + data[k][j];
					}
				}
			}
		}
	}
	
	public void Path(int q, int r) {
		if (p[q][r] != -1) {
			Path(q, p[q][r]);
			System.out.printf("%s ->", name[p[q][r]]);
			Path(p[q][r], r);
		}
	}
	
	public void printPath() {
		int count = data.length;
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < count; j++) {
				System.out.printf("%d\t", data[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Floyd floy = new Floyd();
		floy.printPath();
		System.out.println("-------------------");
		floy.distance();
		floy.printPath();
		int start = 0;
		int goal = 4;
		System.out.printf("%s->", floy.name[start]);
		floy.Path(start, goal);
		System.out.printf("%s", floy.name[goal]);
		System.out.println();
	}
	
}
