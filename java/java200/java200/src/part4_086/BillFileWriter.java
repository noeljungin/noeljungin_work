package part4_086;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import part4_083.Billboard;

public class BillFileWriter {

	public static void main(String[] args) {
		Billboard b1 = new Billboard(1, "Despacito1", 1, "http://jpg1", "luis fonsi1");
		Billboard b2 = new Billboard(2, "Despacito2", 2, "http://jpg2", "luis fonsi2");
		Billboard b3 = new Billboard(1, "Despacito3", 3, "http://jpg3", "luis fonsi3");
		
		ArrayList <Billboard> bblist = new ArrayList<>();
		bblist.add(b1);
		bblist.add(b2);
		bblist.add(b3);
		
		File f = new File("billboard");
		if(!f.exists()) {
			f.mkdirs();
		}
		
		try(PrintWriter pw = new PrintWriter(new FileWriter("bill.txt", false), true)) {
			for(Billboard bb : bblist) {
				pw.println(bb);
			}
		} catch (IOException e) {
			System.out.println(e);
		}

	}

}
