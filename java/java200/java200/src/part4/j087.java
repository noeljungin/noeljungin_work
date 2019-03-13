package part4;

import java.io.BufferedReader;
import java.io.FileReader;

public class j087 {

	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(
				new FileReader("bill.txt"))) {
			String msg = "";
			while ((msg=br.readLine()) != null) {
				System.out.println(msg);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
