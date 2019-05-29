package part4_158;

import java.io.IOException;
import java.util.Vector;

public class ObjectStudentWriteMain {

	public static void main(String[] args) {
		ObjectStudentRWG<Student> osw = new ObjectStudentRWG<>();
		Vector<Student> v = new Vector<>();
		v.add(new Student("aaaa", 17, "bbbb"));
		v.add(new Student("cccc", 27, "dddd"));
		v.add(new Student("eeee", 37, "ffff"));
		v.add(new Student("gggg", 47, "hhhh"));
		
		try {
			osw.write("noel\\stu.obj", v);
		} catch (IOException e) {
			System.out.println(e);
		}

	}

}
