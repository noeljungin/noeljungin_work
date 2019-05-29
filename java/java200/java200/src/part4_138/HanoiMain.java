package part4_138;

import part4_137.Hanoi;

public class HanoiMain {

	public static void main(String[] args) {
		int tray = 4;
		Hanoi ha = new Hanoi(tray);
		int [][]a = ha.getRings();
		HanoiUtil.showHanoi(a);
		HanoiUtil.moveHanoi(a, tray, 'a', 'b', 'c');

	}

}
