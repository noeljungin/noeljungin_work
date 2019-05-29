package part4_158;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

public class ObjectStudentRWG<T> {
	public int write(String fname, Vector<T> v) throws IOException{
		int objectNumber = 0;
		try {
			FileOutputStream fos = new FileOutputStream(fname);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			objectNumber = v.size();
			oos.writeInt(objectNumber);
			System.out.println(objectNumber + "개의 data 가 입력됨");
			for (int i = 0; i < objectNumber; i++) {
				oos.writeInt(i);
				oos.writeObject(v.get(i));
				oos.flush();
				System.out.println(i + "번째의 data가 입력");
			}
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			System.out.println("wrong file name");
		} catch(Exception ee) {
			throw new IOException("wrong type"+ee);
		}
		return objectNumber;
	}
	public void read(String fname) throws IOException{
		try {
			FileInputStream fis = new FileInputStream(fname);
			ObjectInputStream ois = new ObjectInputStream(fis);
			int objectNumber = ois.readInt();
			System.out.println(objectNumber + "개의 data를 읽음");
			for (int i = 0; i < objectNumber; i++) {
				try {
					System.out.print(ois.readInt() + "번째");
					System.out.println(ois.readObject());
				} catch (ClassNotFoundException e1) {
					System.out.println("wrong type" + e1);
				}
			}
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			System.out.println("wrong file name");
		}
	}
}
