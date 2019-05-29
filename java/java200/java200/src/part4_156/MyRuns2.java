package part4_156;

public class MyRuns2 implements Runnable {

	private int i = 0;
	public void run() {
		show();
	}
	
	public synchronized void show() {
		for (int i = 0; i < 500; i++) {
			if (((Thread.currentThread()).getName()).equals("a")) {
				System.out.print("A");
			} else if(((Thread.currentThread()).getName()).equals("b")){
				System.out.print("B");
			} else if(((Thread.currentThread()).getName()).equals("c")) {
				System.out.print("c");
			} else {
				System.out.print("[" + Thread.currentThread().getName() + i + "]");
			}
		}
	}

}
