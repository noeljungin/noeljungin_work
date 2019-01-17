package com.example.app;

import java.io.InputStream;

//Calculator의 인자를 만들기 위한 인터페이스
public interface ArgumentResolver {
	Argument resolve(InputStream stream);
}
