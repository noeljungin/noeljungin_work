package part4;

import java.util.ArrayList;

public class j085 {

	public static void main(String[] args) {
		ArrayList<j083> bills = new ArrayList<>();
		bills.add(new j083(1, "Despacito", 1, "http://jpg1", "luis fonsi"));
		bills.add(new j083(2, "That's What I Like", 2, "http://jpg2", "bruno mars"));
		bills.add(new j083(3, "I'm The One", 3, "http://jpg3", "jd khaled"));
		System.out.println(bills.size());
		
		showAbout(bills.get(0));
		bills.remove(1);
		System.out.println(bills.size());
		System.out.println("------------");
		
		for(j083 bb : bills) {
			showAbout(bb);
		}
	}
	
	public static void showAbout(j083 bb) {
		String sf = String.format("%d, %s, %d, %s, %s", bb.getRank(), bb.getSong(), bb.getLastweek(), bb.getImagesrc(), bb.getArtist());
		System.out.println(sf);
		
	}
	
}
