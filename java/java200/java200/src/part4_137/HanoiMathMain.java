package part4_137;

public class HanoiMathMain {

	public static void main(String[] args) {
		int tray = 4;
		Hanoi ha = new Hanoi(tray);
		ha.moveHanoi(tray, 'a', 'b', 'c');
	}
}
