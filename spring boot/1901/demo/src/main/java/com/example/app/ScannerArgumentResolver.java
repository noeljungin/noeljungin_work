package com.example.app;

import java.io.InputStream;
import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
//java.util.scanner로 인자를 생성햇 반환하는 클래스(ArgumentResolver의 본체)
public class ScannerArgumentResolver implements ArgumentResolver{
	
	@Override
	public Argument resolve(InputStream stream) {
		Scanner scanner = new Scanner(stream);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		return new Argument(a, b);
	}
}
