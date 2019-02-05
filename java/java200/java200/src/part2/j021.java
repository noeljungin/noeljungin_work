package part2;

public class j021 {

	public static void main(String[] args) {
		int [] grade = {80, 90, 89};
		int tot = grade[0] + grade[1] + grade[2];
		int average = tot/3;
		System.out.printf("kor %d, end %d, math %d => \t", grade[0], grade[1], grade[2]);
		System.out.printf("total %d, average %d", tot, average);
	}

}
