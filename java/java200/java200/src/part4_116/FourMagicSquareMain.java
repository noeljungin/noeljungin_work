package part4_116;

import java.util.Scanner;

public class FourMagicSquareMain {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int n = scann.nextInt();
		System.out.println("4의 배수 정수를 입력하시오");
		FourMagicSqure fms = new FourMagicSqure(n);
		fms.make();
		System.out.println(fms);
		

	}

}
