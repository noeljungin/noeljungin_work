package part4;

public class j084 {

	public static void main(String[] args) {
		j083 b1 = new j083(1, "Despacito", 1, "http://jpg1", "luis fonsi");
		j083 b2 = new j083(2, "That's Waht I Like", 2, "http://jpg2", "bruno mars");
		j083 b3 = new j083(3, "I'm The One", 3, "http://jpg3", "dj khaled");
		
		showAbout(b1);
		showAbout(b2);
		showAbout(b1, b2);
		showAbout(b1, b2, b3);
		
		j083[] b = new j083[3];
		b[0] = new j083(1, "Despacito", 1, "http://jpg1", "luis fonsi");
		b[1] = b2;
		b[2] = b3;
		showAbout(b[0], b[1]);
		showAbout(b);
	}
	
	public static void showAbout(j083 bb) {
		System.out.println("1---------------");
		String sf = String.format("%d, %s, %d, %s, %s", 
				bb.getRank(), bb.getSong(), bb.getLastweek(), bb.getImagesrc(), bb.getArtist());
		System.out.println(sf);
	}
	
	public static void showAbout(j083 ... b) {
		System.out.println("2--------------");
		for(j083 bill : b) {
			showAbout(bill);
		}
		System.out.println("<==============2");
	}
	
	

}
