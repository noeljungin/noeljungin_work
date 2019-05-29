package part4_151;

public class HyoBaseBallMain {

	public static void main(String[] args) {
		Pitcher pit = new Pitcher();
		Hitter hit = new Hitter();
		Umpire ump = new Umpire();
		int iterCount = 0;
		pit.make();
		ump.setPitBall(pit.getGong());
		System.out.println("play base ball~~");
		while (true) {
			iterCount++;
			hit.make();
			System.out.printf("%d번째 입력한 공 : %d, %d, %d \n", iterCount, hit.getGong()[0], hit.getGong()[1], hit.getGong()[2]);
			ump.setHitBall(hit.getGong());
			int strike = ump.strike();
			int ball = ump.ball();
			System.out.printf("%d 번째 %dstrike %dball \n", iterCount, strike, ball);
			if (iterCount < 10 && strike == 3) {
				System.out.println("you win");
				break;
			} else if(iterCount >= 10 && strike < 3) {
				System.out.println("you lose");
				System.out.printf("투수 : %d, %d, %d \n", pit.getGong()[0], pit.getGong()[1], pit.getGong()[2]);
				break;
			}
		}

	}

}
