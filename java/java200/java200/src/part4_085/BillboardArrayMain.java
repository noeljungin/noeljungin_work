package part4_085;

import java.util.ArrayList;

import part4_083.Billboard;

public class BillboardArrayMain {

	public static void main(String[] args) {
		ArrayList<Billboard> bills = new ArrayList<>();
		bills.add(new Billboard(1, "Despacito", 1, "http://jpg1", "luis fonsi"));
		bills.add(new Billboard(2, "That's What I Like", 2, "http://jpg2", "bruno mars"));
		bills.add(new Billboard(3, "I'm The One", 3, "http://jpg3", "jd khaled"));
		System.out.println(bills.size());
		
		showAbout(bills.get(0));
		bills.remove(1);
		System.out.println(bills.size());
		System.out.println("------------");
		
		for(Billboard bb : bills) {
			showAbout(bb);
		}
	}
	
	public static void showAbout(Billboard bb) {
		String sf = String.format("%d, %s, %d, %s, %s", bb.getRank(), bb.getSong(), bb.getLastweek(), bb.getImagesrc(), bb.getArtist());
		System.out.println(sf);
		
	}
	
}
