package part4;

public class j083_2 {

	public static void main(String[] args) {
		j083 b1 = new j083(1, "Despacito", 1, "https://www.billboard.com/images/pref_images/q61808osztw.jpg", "luis fonsi");
		showAbout(b1);
		j083 b = b1;
		showAbout(b);
	}
	
	public static void showAbout(j083 bb) {
		String sf = String.format("%d, %s, %d, %s, %s", 
				bb.getRank(), bb.getSong(), bb.getLastweek(), bb.getImagesrc(), bb.getArtist());
		System.out.println(sf);
	}
}
