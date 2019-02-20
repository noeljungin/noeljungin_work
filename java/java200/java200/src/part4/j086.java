package part4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class j086 {

	public static void main(String[] args) {
		j083 b1 = new j083(1, "Despacito1", 1, "http://jpg1", "luis fonsi1");
		j083 b2 = new j083(2, "Despacito2", 2, "http://jpg2", "luis fonsi2");
		j083 b3 = new j083(1, "Despacito3", 3, "http://jpg3", "luis fonsi3");
		
		ArrayList <j083> bblist = new ArrayList<>();
		bblist.add(b1);
		bblist.add(b2);
		bblist.add(b3);
		
		File f = new File("billboard");
		if(!f.exists()) {
			f.mkdirs();
		}
		
		try(PrintWriter pw = new PrintWriter(new FileWriter("bill.txt", false), true)) {
			for(j083 bb : bblist) {
				pw.println(bb);
			}
		} catch (IOException e) {
			System.out.println(e);
		}

	}

}
