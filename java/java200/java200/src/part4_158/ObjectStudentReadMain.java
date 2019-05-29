package part4_158;

import java.io.IOException;

public class ObjectStudentReadMain {

	public static void main(String[] args) {
		ObjectStudentRWG<Student> osw = new ObjectStudentRWG<Student>();
		try {
			osw.read("noel\\stu.obj");
		} catch (IOException e) {
			System.out.println(e);
		}
		

	}

}
